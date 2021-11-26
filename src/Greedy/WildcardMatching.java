package Greedy;

public class WildcardMatching {
	/**
	 * Please see youtube video to understand this https://www.youtube.com/watch?v=NbgUZAoIz3g
	 * */
	public boolean isMatch(String s, String p) {
		int pLen = p.length();
		int sLen = s.length();
		boolean[][] dp = new boolean[pLen+1][sLen+1];
		dp[pLen][sLen] = true;
		for(int i=pLen-1;i>=0;i--){
			if(p.charAt(i) =='*'){
				dp[i][sLen] = dp[i+1][sLen];
			}
		}
		for(int i=pLen-1;i>=0;i--){
			for(int j = sLen-1 ; j>=0 ; j--){
				if(p.charAt(i) == s.charAt(j) || p.charAt(i) == '?'){
					dp[i][j] = dp[i+1][j+1];
				}else if(p.charAt(i) != s.charAt(j) && p.charAt(i) != '*'){
					dp[i][j]=false;
				}else{
					dp[i][j] = dp[i][j+1] || dp[i+1][j];
				}
			}
		}
		return dp[0][0];

	}
}
