package Greedy;

public class SplitArrayIntoConsecutiveSubsequences {
	final int LENGTH=2001;
	final int MAX_NUMBER=2002;
	public boolean isPossible(int[] nums) {
		for(int i=0;i<nums.length;i++){
			nums[i]=nums[i]+1001;
		}
		int[][] dp = new  int[LENGTH+1][MAX_NUMBER+1];
		for(int num: nums){
			int col = num-1;
			boolean gotSomeLists = false;
			for(int i=0;i<=LENGTH;i++){
				if(dp[i][col] > 0){
					gotSomeLists = true;
					dp[i][col]--;
					dp[i+1][col+1]++;
					break;
				}
			}
			if(gotSomeLists == false){
				dp[1][col+1]++;
			}
		}
		int count = 0;
		for(int i=1;i<3;i++){
			for(int j=0;j<=MAX_NUMBER;j++){
				if(dp[i][j] >= 1)count++;
			}
		}
		return count == 0;
	}
}
