package Dhiraj;

import java.util.ArrayList;
import java.util.Arrays;

public class IntervalListIntersection {
	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		int x = 0, y=0;
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		while(x < firstList.length && y < secondList.length)
		{
			if(secondList[y][0] >= firstList[x][0] && secondList[y][0] < firstList[x][1] && secondList[y][1] >= firstList[x][1]){
				ans.add(new ArrayList<>(Arrays.asList(secondList[y][0],firstList[x][1])));
				x++;
			}else if(firstList[x][0] >= secondList[y][0]  && firstList[x][0] < secondList[y][1]   && firstList[x][1] >= secondList[y][1] ){
				ans.add(new ArrayList<>(Arrays.asList(firstList[x][0],secondList[y][1])));
				y++;
			} else if(secondList[y][0] > firstList[x][0] && secondList[y][1] < firstList[x][1]){
				ans.add(new ArrayList<>(Arrays.asList(secondList[y][0],secondList[y][1])));
				y++;
			}else if(firstList[x][0] > secondList[y][0]  && firstList[x][1] < secondList[y][1]) {
				ans.add(new ArrayList<>(Arrays.asList(firstList[x][0], firstList[x][1])));
				x++;
			}
//			}else if(firstList[x][0] == secondList[y][0]  && firstList[x][1] == secondList[y][1]){ 	// This case is redundant as it will be covered from first or second
//				ans.add(new ArrayList<>(Arrays.asList(firstList[x][0],firstList[x][1])));
//				x++;y++;
//			}
			else{
				if(secondList[y][0] == firstList[x][1]){
					ans.add(new ArrayList<>(Arrays.asList(firstList[x][1],firstList[x][1])));
					x++;
				}else if(firstList[x][0] == secondList[y][1]){
					ans.add(new ArrayList<>(Arrays.asList(firstList[x][0],firstList[x][0])));
					y++;
				}else if(secondList[y][0] > firstList[x][1]){
					x++;
				}else if(firstList[x][0] > secondList[y][1]){
					y++;
				}
			}
		}
		int len = ans.size();
		int[][] arrayAns = new int[len][2];
		int m = 0;
		for(ArrayList<Integer> arr: ans){
			arrayAns[m++] = arr.stream().mapToInt(Integer::intValue).toArray();
		}
		return arrayAns;
	}
}
