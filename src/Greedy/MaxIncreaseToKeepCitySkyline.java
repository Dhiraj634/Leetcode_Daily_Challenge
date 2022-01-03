package Greedy;

public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] row = new int[n];
        int[] col = new int[n];
        for(int i =0 ;i<n;i++){
            for(int j=0;j<n;j++){
                row[i] = Math.max(row[i], grid[i][j]);
                col[i] = Math.max(col[i], grid[j][i]);
            }
        }
        int count = 0;
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                int height =  Math.min(row[i],col[j]) - grid[i][j];
                count += Math.max(height, 0);
            }
        }
        return count;
    }
}
