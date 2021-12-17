package Dhiraj;

public class MaximalSquare {
	/**
	 * See leetcode solution for optimized approach.
	 * */
	public int maximalSquare(char[][] matrix) {
		int row= matrix.length;
		int col= matrix[0].length;
		int[][] cummArr = new int[row+1][col+1];
		for(int i=0;i<row;i++){
			for(int j=col-1;j>=0;j--){
				cummArr[i][j] = cummArr[i][j+1] + (matrix[i][j] - '0');
			}
		}
		for(int i=0;i<col;i++){
			for(int j=row-1;j>=0;j--){
				cummArr[j][i] = cummArr[j+1][i] + cummArr[j][i];
			}
		}
		int maxArea = 0;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(matrix[i][j] == '0') continue; // this line is important
				int len =1;
				while(j+len <= col && i+len <= row){
					int temp = cummArr[i][j] - cummArr[i][j+len] -cummArr[i+len][j] + cummArr[i+len][j+len];
					if(temp == len*len)
						maxArea= Math.max(temp, maxArea);
					else // This line is important
						break;
					len++;
				}
			}
		}
		return maxArea;
	}
}
