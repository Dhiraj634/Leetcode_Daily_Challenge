package Greedy;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumSwap {
	public int maximumSwap(int num) {
		/**
		 * fre[i][0] -> shows the frequency of that digit
		 * fre[i][1] -> shows the last index of that digit, since we are concerned with the replacement of the last index at which that digit has come
		 * */
		int[][] fre = new int[10][2];
		String numStr = String.valueOf(num);
		for(int i=0;i<numStr.length();i++){
			int digit = numStr.charAt(i)-'0';
			fre[digit][0]++;
			fre[digit][1]=i;
		}
		/**
		 * Adding the highest digit first, so that we will know what number we need to replace with
		 * */
		Queue<Integer> queue = new LinkedList<>();
		for(int i=9;i>=0;i--){
			for(int j=0;j<fre[i][0];j++){
				queue.add(i);
			}
		}
		StringBuilder sb = new StringBuilder(numStr);
		/**
		 * We continue to match the first digit and as soon as the digit does not match we will know we need to replace that digit with the top of the
		 * queue since the top one is the max element, and we will check the last index corresponding to the digit of the queue from fre and replace that
		 * index with the character at index i
		 * */
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
