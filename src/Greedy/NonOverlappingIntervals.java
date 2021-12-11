package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
//		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
		Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
		int left = 0, right = 1;
		int count = 0;
		while(right < intervals.length) {
//			int overlapLeft = Math.max(intervals[left][0], intervals[right][0]);
//			int overlapRight = Math.min(intervals[left][1], intervals[right][1]);
			/**
			 * If over-lap is not there we simply move aur left pointer to right and right = right+1 and continue checking
			 */
//			if(overlapLeft >= overlapRight){
//				left = right;
//			}
			if(intervals[left][1] <= intervals[right][0]){
				left = right;
			}
			/**
			 * If over-lap is there, we need to remove either left one or the right one.
			 * So we remove the one whose right end is minimum to minimize the overlap possibility going forward
			 * if the end pointer of the right one is grater we move the right=right+1
			 * else we move the left pointer to left = right and right = right+1
			 * */
			else{
				if( intervals[left][1] >= intervals[right][1] ){
					left = right;
				}
				count++;
			}
			right++;
		}
		return count;

	}
}
