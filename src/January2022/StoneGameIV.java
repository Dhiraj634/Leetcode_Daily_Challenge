package January2022;

public class StoneGameIV {
    int[][] dp;
    public boolean winnerSquareGame(int n) {
        return 0 == getWinnerDP(n);
    }
    private int getWinnerRecursionWithMemo(int n){
        dp = new int[n+1][2];
        for(int[] row : dp){
            row[0]=-1;
            row[1]=-1;
        }
        return getWinner(n,0);
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
    private int getWinnerDP(int n){
        int[][] dp = new int[n+1][2];
        dp[0][1] = 0;
        dp[0][0] = 1;
        for(int i = 1;i<n+1;i++){
            int turn = 0;
            int tempWinner = turn^1;
            for(int j = 1;j*j<=i;j++){
                tempWinner = tempWinner & dp[i - j*j][ turn^1];
                if(tempWinner == turn){
                    dp[i][turn] = turn;
                    break;
                }
            }
            if(tempWinner != turn) dp[i][turn] =tempWinner;
            turn = 1;
            tempWinner = 0;
            for(int j = 1;j*j<=i;j++){
                tempWinner = tempWinner | dp[i - j*j][ turn^1];
                if(tempWinner == turn){
                    dp[i][turn] = turn;
                    break;
                }
            }
            if(tempWinner != turn) dp[i][turn] =tempWinner;
        }
        return dp[n][0];
    }
}
