package Greedy;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		int len = tasks.length;
		Node[] fre = new Node[26];
		for(char ch:tasks){
			if(fre[ch - 'A'] ==null){
				fre[ch - 'A'] = new Node(0,-n);
			}
			fre[ch-'A'].fre++;
		}
		int time = 1;
		while(len > 0){
			Node node = null;
			for(int i=0;i<26;i++){
				if(fre[i]!=null && fre[i].fre > 0 && time- fre[i].time > n)
				{
					if(node == null ) node =fre[i];
					else{
						if(node.fre < fre[i].fre)
							node = fre[i];
					}
				}
			}
			if(node != null){
				node.time = time;
				node.fre--;
				len--;
			}
			time++;
		}
		return time -1;


	}

	private static class Node {
		int fre;
		int time;
		 Node(int fre,int time){
			 this.fre = fre;
			 this.time = time;
		 }
	}
}
