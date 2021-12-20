package Dhiraj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		Arrays.sort(arr);
		int minDif = 1000001;
		for(int i=0;i<arr.length-1;i++){
			minDif = Math.min(arr[i+1]-arr[i], minDif);
		}
		ArrayList<List<Integer>> ans = new ArrayList<>();
		for(int i=0;i<arr.length-1;i++){
			if(arr[i+1]-arr[i] == minDif){
				ans.add(Arrays.asList(arr[i],arr[i+1]));
			}
		}
		return ans;
	}
}
