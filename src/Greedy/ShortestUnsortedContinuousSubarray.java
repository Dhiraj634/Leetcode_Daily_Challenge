package Greedy;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
	/**
	 * This problem can be solved in O(n) time using stack
	 * We first insert in the stack and when we encounter any lesser number we pop
	 * after doing this we will compare the original array to stack elements and the place where the
	 * mismatch starts is the start index of the subarray we need to sort.
	 * Do the same in reverse order to get the end index.
	 * */
	public int findUnsortedSubarray(int[] nums) {
		int[] sortedNum = Arrays.stream(nums).sorted().toArray();
		int count = 0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==sortedNum[i])count++;
			else break;
		}
		for(int i= nums.length-1;i>=0;i--){
			if(nums[i]==sortedNum[i])count++;
			else break;
		}

		return Math.max(nums.length-count,0);
	}
}
