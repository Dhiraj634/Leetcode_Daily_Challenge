package Greedy;

import java.util.Arrays;
import java.util.TreeSet;

public class SetIntersectionSizeAtLeastTwo {
	public int intersectionSizeTwo(int[][] intervals) {
		if(intervals.length == 1) return 2;
		Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
		TreeSet<Integer> set = new TreeSet<>();
		int low = intervals[0][0];
		int high = intervals[0][1];
		for(int i=1;i<intervals.length;i++){
			int intersection_low = Math.max(low, intervals[i][0]);
			int intersection_high = Math.min(high, intervals[i][1]);
			if(intersection_low<intersection_high){
				set.add(intersection_high);
				set.add(intersection_low);
			}else if(intersection_low == intersection_high){
				set.add(intersection_high);
				set.add(intersection_high+1);
				set.add(intersection_high-1);
			}else{
				set.add(high);
				set.add(high-1);
			}
			if(intersection_low>=intersection_high){
				if(high < intervals[i][1]){
					high = intervals[i][1];
					low = intervals[i][0];
				}
			}else{
				low = intervals[i][0];
				high = intervals[i][1];
			}
		}
		return set.size();
	}
	private int checkHowManyPresent(int lowerValue, int[] set, int len){
		int count = 0;
		for(int i=0;i<len;i++){
			if(set[i] >= lowerValue){
				count++;
			}
		}
		return count;
	}
}
