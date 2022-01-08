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
       return cherryPick(grid,0,0,col-1,dp);
    }
    private int cherryPick(int[][] grid, int row, int col1, int col2, int[][][] dp){
        if(row == grid.length) return 0;
        if(dp[row][col1][col2] != -1) return dp[row][col1][col2];

        int result = grid[row][col1];
        result+= col1 !=col2 ? grid[row][col2] : 0;
        int max = 0;
        for(int newCol1 = Math.max(col1-1,0);newCol1 < grid[0].length && newCol1 <= col1+1;newCol1++){
            for(int newCol2 = Math.max(col2-1,0);newCol2 < grid[0].length && newCol2 <= col2+1;newCol2++){
                max = Math.max(max, cherryPick(grid,row+1, newCol1, newCol2,dp));
            }
        }
        result+=max;
        dp[row][col1][col2] = result;
        return result;
    }
}
