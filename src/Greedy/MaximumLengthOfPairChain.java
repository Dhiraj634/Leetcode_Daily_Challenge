package Greedy;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
	/**
	 * Removing minimum intervals so that the resulting pairs are non overlapping.*/
	public int findLongestChain(int[][] pairs) {
		if(pairs.length == 1) return 1;
		Arrays.sort(pairs,(a,b) -> a[0]-b[0]);
		int removed = 0,left = 0, right = 1;
		while(right < pairs.length){
			if(pairs[left][1] >= pairs[right][0]){
				if(pairs[left][1] >= pairs[right][1]){
					left =right;
				}
				removed++;
			}else{
				left = right;

			}
			right++;
		}
		 return pairs.length - removed;

	}
	/**
	 * Simple Greedy Solution
	 * class Solution {
	 *     public int findLongestChain(int[][] pairs) {
	 *         Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
	 *         int cur = Integer.MIN_VALUE, ans = 0;
	 *         for (int[] pair: pairs) if (cur < pair[0]) {
	 *             cur = pair[1];
	 *             ans++;
	 *         }
	 *         return ans;
	 *     }
	 * }
	 * */
}
