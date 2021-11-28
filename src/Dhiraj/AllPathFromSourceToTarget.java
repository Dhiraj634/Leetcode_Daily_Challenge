package Dhiraj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathFromSourceToTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> answer = new ArrayList<>();
		int n = graph.length;
		getAllPath(graph,0, n-1,answer, new ArrayList<>(Arrays.asList(0)));
		return answer;
	}
	private void getAllPath(int[][] graph, int currentNode, int end, List<List<Integer>> answer, ArrayList<Integer> arr){
		if(currentNode == end){
			answer.add(new ArrayList<>(arr));
			return;
		}
		for(int nextNode:graph[currentNode]){
			arr.add(nextNode);
			getAllPath(graph, nextNode, end,answer,arr);
			arr.remove(arr.size()-1);
		}
	}
}
