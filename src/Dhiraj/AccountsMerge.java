package Dhiraj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class AccountsMerge {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		boolean[] visited = new boolean[accounts.size()];

		List<List<String>> answer = new ArrayList<>();

		/**
		 * Here we are storing the account's index corresponding to each mail
		 * */
		Map<String,List<Integer>> mailMap = new HashMap<>();
		int m = 0;
		for(List<String> account: accounts){
			for(int i=1;i< account.size();i++){
				String mail = account.get(i);
				mailMap.putIfAbsent(mail,new ArrayList<>());
				mailMap.get(mail).add(m);
			}
			m++;
		}

		/**
		 * Here we are creating the graph by iterating through each account and dropping the name and replacing
		 * the mails to the indexes of the account in which the email is present and make sure no repetition is there
		 * Example :
		 * let abc2@m.co be present in 1,2,0
		 * let abc1@m.co be present in 0,4
		 * [john, abc2@m.co, abc1@m.co] -> [0,1,2,4]
		 * */
		List<List<Integer>> graph = new ArrayList<>();
		for(List<String> account: accounts){
			HashSet<Integer> temp = new HashSet<>();
			for(String mail: account){
				if(mailMap.containsKey(mail)){
					temp.addAll(mailMap.get(mail));
				}
			}
			graph.add(new ArrayList<>(temp));
		}

		/**
		 * Now Just travel the graph and find out the connected component.
		 * Now you have the index of all the same account and now merge them and sort them.
		 * TreeSet has inbuilt functionality for sorting and removing duplicates
		 * */
		for(int i=0;i<visited.length;i++){
			if(!visited[i]){
				ArrayList<Integer> component = dfs(graph,i,visited, new ArrayList<>());
				TreeSet<String> temp = new TreeSet<>();
				for(int index: component){
					temp.addAll(accounts.get(index).stream().skip(1).collect(Collectors.toList()));
				}
				ArrayList<String> temp2 = new ArrayList<>();
				temp2.add(accounts.get(component.get(0)).get(0));
				temp2.addAll(temp);
				answer.add(temp2);
			}
		}

		return answer;

	}
	private ArrayList<Integer> dfs(List<List<Integer>> graph, int node, boolean[] visited, ArrayList<Integer> component){
		component.add(node);
		visited[node] = true;
		for(int nextNode: graph.get(node)){
			if(visited[nextNode])continue;
			dfs(graph,nextNode, visited,component);
		}
		return component;
	}

}
