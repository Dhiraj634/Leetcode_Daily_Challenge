package Greedy;

import java.util.ArrayList;

public class WiggleSubsequence {
	public int wiggleMaxLength(int[] nums) {

		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(nums[0]);
		// removing all the consecutive nums which are equal
		for(int num: nums){
			if(num != ans.get(ans.size()-1)){
				ans.add(num);
			}
		}
		if(ans.size() ==1) return 1;
		int count=2; // for first and the last
		// Counting for each of the num, if it is a peak or valley
		for(int i=1;i<=ans.size()-2;i++){
			if(ans.get(i)> ans.get(i-1) && ans.get(i) > ans.get(i+1)){
				count++;
			}else if(ans.get(i) < ans.get(i-1) && ans.get(i) < ans.get(i+1)){
				count++;
			}
		}
		return count;
	}
	/**
	 * Another Approach by leetcode
	 *
	 * public class Solution {
	 *     public int wiggleMaxLength(int[] nums) {
	 *         if (nums.length < 2)
	 *             return nums.length;
	 *         int prevdiff = nums[1] - nums[0];
	 *         int count = prevdiff != 0 ? 2 : 1;
	 *         for (int i = 2; i < nums.length; i++) {
	 *             int diff = nums[i] - nums[i - 1];
	 *             if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
	 *                 count++;
	 *                 prevdiff = diff;
	 *             }
	 *         }
	 *         return count;
	 *     }
	 * }
	 *
	 * */
}

