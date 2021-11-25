package Dhiraj;

import java.util.Arrays;

public class MaximumSubArray {
	/**
	 * Check for Kadane's Algorithm
	 * */
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int sum = 0;
		int countNeg = 0;
		for(int num:nums){
			if(num <0) countNeg++;
			if(sum+num >= 0){
				sum += num;
				max = Math.max(sum, max);
			}else{
				sum = 0;
			}
		}
		if(countNeg == nums.length){
			return Arrays.stream(nums).max().getAsInt();
		}else{
			return max;
		}

	}
}
