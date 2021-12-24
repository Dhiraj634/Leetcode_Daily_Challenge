package Dhiraj;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
		if(intervals.length ==1 ) return intervals;
		ArrayList<int[]> ans = new ArrayList<>();
		int start = intervals[0][0], end = intervals[0][1];
		for(int[] interval: intervals){
			if(interval[0]<=end)
				end = Math.max(end,interval[1]);
			else{
				ans.add(new int[]{start, end});
				start = interval[0];
				end = interval[1];
			}
		}
		ans.add(new int[]{start,end});
		return ans.toArray(new int[][]{{}});
	}
}
