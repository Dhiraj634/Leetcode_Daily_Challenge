package Dhiraj;

public class MaximumRectangle {
	public int maximalRectangle(char[][] matrix) {
		int row = matrix.length;
		if(row == 0) return 0;
		int col = matrix[0].length;
		int[][] cummSum = new int[row+1][col+1];
		for(int i= 0 ;i<row;i++){
			for(int j = col-1;j>=0;j--){
				cummSum[i][j]= cummSum[i][j+1] + (matrix[i][j] - '0');
			}
		}
		for(int i= 0 ;i<col;i++){
			for(int j = row-1;j>=0;j--){
				cummSum[j][i]= cummSum[j+1][i] + cummSum[j][i];
			}
		}
		int maxArea = 0;
		for(int i=0;i<row;i++){
			for(int j = 0; j<col;j++){
				int tempArea = getTheMaxArea(i,j, cummSum, row+1, col+1);
				maxArea = Math.max(tempArea,maxArea);
			}
		}
		return maxArea;
	}
	private int getTheMaxArea(int start, int end, int[][] cummSum, int row, int col){
		int maxArea = -1;
		for(int len=1;end+len<col;len++){
			for(int width = 1;start+width<row;width++){
				int tempArea = cummSum[start][end] - cummSum[start][end+len] - cummSum[start+width][end] + cummSum[start+width][end+len];
				if(tempArea == len*width){
					maxArea = Math.max(tempArea, maxArea);
				}else{
					// If at a particular width the tempArea != len * width the going forward with width will definitely not match hence break
					break;
				}
			}
		}
		return maxArea;
	}
}
