package Dhiraj;

public class HouseRobber {
	public int rob(int[] nums) {
		int len = nums.length;
		// dp[i][0] -> denotes that we are not robbing the current house
		// dp[i][1] -> denotes that we are robbing the current house
		int[][] dp = new int[len][2];
		dp[len-1][0] = 0;
		dp[len-1][1] = nums[len-1];
		for(int i=len-2;i>=0;i--){
			// If you are not including the current one then you can either rob the next apartment or leave it
			// and we will decide to rob it or not based on the maximum money that we can get
			dp[i][0] = Math.max(dp[i+1][1],dp[i+1][0]);

			// if we are robbing the current house then definitely do not rob the next house
			dp[i][1] = dp[i+1][0] + nums[i];
		}
		return Math.max(dp[0][0],dp[0][1]);
	}
}
