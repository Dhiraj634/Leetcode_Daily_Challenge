package Greedy;

import java.util.Arrays;

public class JumpGameII {
	public int jump(int[] nums) {
		int len = nums.length;
		int[] dp = new int[nums.length];
		Arrays.fill(dp,100000);
		dp[len-1] = 0;
		for(int i=len-2;i>=0;i--){
			for(int j = 1; j<=nums[i];j++){
				if(i+j>=len){
					break;
				}
				dp[i] = Math.min(dp[i+j]+1,dp[i]);
			}
		}
		return dp[0];
	}
}
