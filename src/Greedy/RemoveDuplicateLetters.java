package Greedy;

import java.util.Arrays;
import java.util.Stack;

public class RemoveDuplicateLetters {

	/**
	 * Go through this video to understand this problem https://www.youtube.com/watch?v=2ayws5Y-WM4
	 *
	 * Basically we store the last Index of any particular character and then iterate over the string
	 * each time we see if the last character inserted is grater then the current one ,
	 * if yes then it can be replaced until it can come afterward and this is where our last index storage will come
	 * 		if it cannot come afterward then don't replace just add the current character to the stack.
	 * 		Repeat the above step until it is not possible to remove.
	 * if No then simply add the current character to the end.
	 *
	 * */
	public String removeDuplicateLetters(String s) {
		int[] index = new int[26];
		Arrays.fill(index,-1);
		boolean[] isPresent = new boolean[26];
		int m = 0;
		for(char ch : s.toCharArray()){
			index[ch - 'a'] = m++;
		}
		Stack<Character> stack = new Stack<>();
		m=0;
		for(char ch: s.toCharArray()){
			if(isPresent[ch -'a']){m++;continue;}
			while(!stack.isEmpty()){
				char top = stack.peek();
				if( ch < top && index[top - 'a'] > m){
					char popped = stack.pop();
					isPresent[popped - 'a'] = false;
				}else{
					break;
				}
			}
			stack.push(ch);
			isPresent[ch-'a'] = true;
			m++;
		}
		StringBuilder sb = new StringBuilder();
		for(char ch:stack){
			sb.append(ch);
		}
		return sb.toString();
	}
}
