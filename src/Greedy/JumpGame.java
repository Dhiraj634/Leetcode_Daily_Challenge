package Greedy;

public class JumpGame {
	public boolean canJump(int[] nums) {
		int len = nums.length;
		if(len == 1) return true;
		boolean[] dp = new boolean[len];
		dp[len-1] = true;
		// Last Index from which we can reach the end
		int lastTrueIndex=len-1;

		for(int i=len-2;i>=0;i--){
			if(i+nums[i]>=lastTrueIndex){
				dp[i]=true;
				lastTrueIndex = i;
			}
		}
		return dp[0];
	}
}
