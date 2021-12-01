package Dhiraj;

import java.util.Arrays;

public class HouseRobber {
	public int rob(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len+1];
		dp[len]=0;
		dp[len-1] = nums[len-1];
		int max = -1;
		for(int i=len-2;i>=0;i--){
			dp[i]= nums[i];
			int tempMax = 0;
			for(int j = i+2;j<len;j++){
				tempMax = Math.max(tempMax, dp[j]);
			}
			dp[i]+=tempMax;
		}
		return Arrays.stream(dp).max().getAsInt();
	}
}
