package Dhiraj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if(n == 1) return Collections.singletonList(0);
		if(n == 2) return Arrays.asList(0,1);
		ArrayList<HashSet<Integer>> tree = new ArrayList<>(n);
		for(int i=0;i<n;i++){
			tree.add(new HashSet<>());
		}
		for(int[] edge: edges){
			tree.get(edge[0]).add(edge[1]);
			tree.get(edge[1]).add(edge[0]);
		}
		ArrayList<Integer> leaves = new ArrayList<>();
		for(int i=0;i< n;i++){
			if(tree.get(i).size() == 1 ){
				leaves.add(i);
			}
		}
		int remainingNodes = n;
		while(remainingNodes > 2){
			remainingNodes -= leaves.size();
			ArrayList<Integer> newLeaves = new ArrayList<>();
			for(int leafNode: leaves){

				for(int connectedToLeafNode : tree.get(leafNode)){
					tree.get(connectedToLeafNode).remove(leafNode);
					if(tree.get(connectedToLeafNode).size() == 1){
						newLeaves.add(connectedToLeafNode);
					}
				}
			}
			leaves = newLeaves;
		}
		return  leaves;
	}
}
