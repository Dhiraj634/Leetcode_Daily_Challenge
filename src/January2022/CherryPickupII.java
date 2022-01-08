package January2022;

import java.util.Arrays;

public class CherryPickupII {
    public int cherryPickup(int[][] grid) {
       int row = grid.length, col = grid[0].length;
       int[][][] dp = new int[row][col][col];
       for(int[][] temp : dp){
           for(int[] temp2: temp){
               Arrays.fill(temp2,-1);
           }
       }
       return cherryPickRecursion(grid,0,0,col-1,dp);
//       return cherryPickDp(grid);
    }
    private int cherryPickRecursion(int[][] grid, int row, int col1, int col2, int[][][] dp){
        if(row == grid.length) return 0;
        if(dp[row][col1][col2] != -1) return dp[row][col1][col2];

        int result = grid[row][col1];
        result+= col1 !=col2 ? grid[row][col2] : 0;
        int max = 0;
        for(int newCol1 = Math.max(col1-1,0);newCol1 < grid[0].length && newCol1 <= col1+1;newCol1++){
            for(int newCol2 = Math.max(col2-1,0);newCol2 < grid[0].length && newCol2 <= col2+1;newCol2++){
                max = Math.max(max, cherryPickRecursion(grid,row+1, newCol1, newCol2,dp));
            }
        }
        result+=max;
        dp[row][col1][col2] = result;
        return result;
    }
    private int cherryPickDp(int[][] grid){
        int rows = grid.length, cols = grid[0].length;
        int[][][] dp = new int[rows +1][cols][cols];
        for(int row = rows - 1; row >=0; row--){
            for(int col1 = 0; col1 < cols; col1++){
                for(int col2 = 0; col2 < cols; col2++){
                    dp[row][col1][col2] = col1 == col2 ? grid[row][col2] + grid[row][col1] : grid[row][col2];
                    int max = 0;
                    for(int newCol1 = Math.max(col1-1,0);newCol1 <= Math.min(col1+1,grid[0].length-1);newCol1++){
                        for(int newCol2 = Math.max(col2-1,0);newCol2 <= Math.min(col2+1,grid[0].length-1);newCol2++){
                            max = Math.max(max, dp[row +1][newCol1][newCol2]);
                        }
                    }
                    dp[row][col1][col2]+=max;
                }
            }
        }
        return dp[0][0][cols -1];
    }
}
