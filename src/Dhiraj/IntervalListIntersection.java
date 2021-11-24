package Dhiraj;

import java.util.ArrayList;

public class IntervalListIntersection {
	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		int x = 0, y=0;
		ArrayList<int[]> ans = new ArrayList<>();
		while(x < firstList.length && y < secondList.length)
		{
			/**
			 * Below 2 line are important to find the interval if they are intersecting i.e. maxStart and minEnd and then check if they are valid i.e. minEnd >= maxStart
			 * */
			int maxStart = Math.max(firstList[x][0],secondList[y][0]);
			int minEnd= Math.min(firstList[x][1],secondList[y][1]);
			if(maxStart <= minEnd){
				ans.add(new int[]{maxStart,minEnd});
			}
			if(firstList[x][1] > secondList[y][1]){
				y++;
			}else {
				x++;
			}
		}
		return ans.toArray(new int[ans.size()][]);
	}
}
