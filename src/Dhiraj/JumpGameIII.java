package Dhiraj;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {
	public boolean canReach(int[] arr, int start) {
		Queue<Integer> q =new LinkedList<>();
		q.add(start);
		boolean[] added = new boolean[arr.length];
		added[start] = true;
		while(!q.isEmpty()){
			int index = q.poll();
			if(arr[index]==0) return true;
			int right = index + arr[index];
			int left = index - arr[index];
			if(right < arr.length && !added[right])
			{
				q.add(right);
				added[right] = true;
			}
			if(left >= 0 && !added[left]){
				q.add(left);
				added[left] = true;
			}
		}
		return false;
	}
}
