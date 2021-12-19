package Dhiraj;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
		Stack<Character> stack = new Stack<>();
		StringBuilder ans = new StringBuilder();
		for(char ch: s.toCharArray()){
			if(ch == ']'){
				getRepeatedString(stack);
			}else{
				stack.add(ch);
			}
		}
		for(char ch:stack){
			ans.append(ch);
		}
		return ans.toString();
	}

	private void  getRepeatedString(Stack<Character> stack){
		StringBuilder sb = new StringBuilder();
		/**
		 * Getting the string to repeat
		 * */
		while(stack.size() > 0 && stack.peek() != '['){
			sb.append(stack.pop());
		}
		if(stack.size()>0)stack.pop(); // Removing the '[' character
		/**
		 * Getting the number of times to repeat the above string
		 * */
		StringBuilder num = new StringBuilder();
		while(stack.size() > 0 && Character.isDigit(stack.peek())){
			num.append(stack.pop());
		}

		int rep = Integer.parseInt(num.reverse().toString());
		String repeatingString = sb.toString();

		StringBuilder temp =  new StringBuilder();
		for(int i=1;i<=rep;i++){
			temp.append(repeatingString);
		}

		for(int i=temp.length()-1;i>=0;i--){
			stack.push(temp.charAt(i));
		}

	}
}
