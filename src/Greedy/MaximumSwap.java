package Greedy;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumSwap {
	public int maximumSwap(int num) {
		int[][] fre = new int[10][2];
		String numStr = String.valueOf(num);
		for(int i=0;i<numStr.length();i++){
			int digit = numStr.charAt(i)-'0';
			fre[digit][0]++;
			fre[digit][1]=i;
		}
		Queue<Integer> queue = new LinkedList<>();
		for(int i=9;i>=0;i--){
			for(int j=0;j<fre[i][0];j++){
				queue.add(i);
			}
		}
		StringBuilder sb = new StringBuilder(numStr);
		for(int i=0;i<numStr.length();i++){
			if(numStr.charAt(i)-'0' == queue.peek()){
				queue.poll();
			}else{
				int temp = queue.poll();
				sb.replace(i,i+1,String.valueOf(temp));
				sb.replace(fre[temp][1],fre[temp][1]+1,String.valueOf(numStr.charAt(i)));
				break;
			}
		}
		return Integer.parseInt(sb.toString());
	}

}
