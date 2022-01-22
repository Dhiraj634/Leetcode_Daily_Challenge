package January2022;

public class StoneGameIV {
    int[][] dp;
    public boolean winnerSquareGame(int n) {
        dp = new int[n+1][2];
        for(int[] row : dp){
            row[0]=-1;
            row[1]=-1;
        }
        int winner = getWinner(n,0);
        return winner ==0;
    }
    private int getWinner(int n,int turn){
        if(n == 0){
            return turn ^ 1;
        }
        if(dp[n][turn] != -1) return dp[n][turn];
        int tempWinner = turn^1;
        for(int i=1 ;i*i<=n;i++){
            if(turn == 0){
                tempWinner = tempWinner & getWinner(n - i*i , turn^1);
            }else{
                tempWinner = tempWinner | getWinner(n - i*i , turn^1);
            }
            if(tempWinner == turn){
                break;
            }
        }
        dp[n][turn] = tempWinner;
        return tempWinner;
    }
}
