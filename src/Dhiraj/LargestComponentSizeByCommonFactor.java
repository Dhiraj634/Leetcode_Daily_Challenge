package Dhiraj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LargestComponentSizeByCommonFactor {
	int[] parent;
	int[] rank;
	public int largestComponentSize(int[] nums) {
		int max = Arrays.stream(nums).max().getAsInt();
		parent = new int[max+1];
		rank = new int[max+1];
		for(int i=0;i<parent.length;i++){
			parent[i] = i;
		}
		for(int num:nums){
			getTheParent(num);
		}

		HashMap<Integer,Integer> map = new HashMap<>();
		for(int num:nums){
			int parent1 = getParent(num);
			map.put(parent1,  map.getOrDefault(parent1,0)+1);
		}
		return map.values().stream().max(Comparator.comparingInt(a->a)).get();
	}

	private void getTheParent(int num){

		for(int i=2;i*i<=num;i++){
			if(num%i == 0){
				setRankAndParent(i, num);
				setRankAndParent(num/i, num);
			}
		}
	}
	private void setRankAndParent(int num1, int num2){
		int parent1 = getParent(num1);
		int parent2 = getParent(num2);
		if(parent1 != parent2){
			if(rank[parent1] >= rank[parent2]){
				rank[parent1]++;
				parent[parent2] = parent1;
			}else{
				rank[parent2]++;
				parent[parent1] = parent2;
			}
		}
	}
	private int getParent(int num){
		while(parent[num] !=num){
			num = parent[num];
		}
		return num;
	}
}
