package Greedy;

import java.util.Arrays;

public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (a,b) -> {
			if(a[1]==b[1]) return a[0]-b[0];
			else return a[1]-b[1];
		});
		Node root = new Node(people[0][0],people[0][1]);
		for(int j = 1;j<people.length;j++){
			int[] arr = people[j];
			int count = 0;
			Node temp = root, prevNode = root;
			while(temp!=null){
				if(temp.h >= arr[0]){
					count++;
				}
				if(count > arr[1]){
					break;
				}
				prevNode =  temp;
				temp = temp.next;
			}
			Node newNode = new Node(arr[0],arr[1]);
			newNode.next = prevNode.next;
			prevNode.next=newNode;
		}
		int[][] ans = new int[people.length][2];
		int m = 0;
		while(root!=null){
			ans[m][0] = root.h;
			ans[m][1] = root.k;
			m++;
			root = root.next;
		}
		return ans;
	}
	class Node {
		int h;
		int k;
		Node next ;
		Node(int h, int k){
			this.h = h;
			this.k = k;
			this.next = null;
		}
	}
}
