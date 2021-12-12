package Dhiraj;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
	Boolean[][] mem = new Boolean[200][10001];
	public boolean canPartition(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		if(sum%2 != 0){
			return false;
		}
		return subsetSum(nums, 0, sum/2) ;
	}
	private boolean subsetSum(int[] nums, int index, int sum){
		if(sum == 0) return true;
		if(index >= nums.length || sum < 0){
			return false;
		}
		if(mem[index][sum] != null){
			return mem[index][sum];
		}
		boolean included = subsetSum(nums, index+1, sum-nums[index]) ;
		boolean notIncluded = subsetSum(nums, index+1, sum);

		mem[index][sum] = included || notIncluded;
		return included || notIncluded;

	}
}
