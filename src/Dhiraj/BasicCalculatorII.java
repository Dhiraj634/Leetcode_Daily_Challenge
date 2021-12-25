package Dhiraj;

import java.util.ArrayList;
import java.util.Stack;

public class BasicCalculatorII {
	public int calculate(String s) {
		ArrayList<String> arr = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(char ch: s.toCharArray()){
			if(ch == ' ') continue;
			if(Character.isDigit(ch)){
				sb.append(ch);
			}else{
				arr.add(sb.toString());
				arr.add(String.valueOf(ch));
				sb.delete(0,sb.length());
			}
		}
		arr.add(sb.toString());
		arr = parseMultiplyDivide(arr);
		arr = parseAdditionSubs(arr);

		return Integer.parseInt(arr.get(0));
	}

	private ArrayList<String> parseMultiplyDivide(ArrayList<String> arr){
		Stack<String> parsedArr =  new Stack<>();
		for(String str: arr){
			if(parsedArr.isEmpty()){
				parsedArr.push(str);
				continue;
			}
			if(parsedArr.peek().equals("/")){
				parsedArr.pop();
				int num1 = Integer.parseInt(parsedArr.pop());
				int num2 = Integer.parseInt(str);
				parsedArr.push(String.valueOf(num1/num2));
			}else if(parsedArr.peek().equals("*")){
				parsedArr.pop();
				int num1 = Integer.parseInt(parsedArr.pop());
				int num2 = Integer.parseInt(str);
				parsedArr.push(String.valueOf(num1*num2));
			}else{
				parsedArr.push(str);
			}

		}
		return new ArrayList<>(parsedArr);
	}
	private ArrayList<String> parseAdditionSubs(ArrayList<String> arr){
		Stack<String> parsedArr =  new Stack<>();
		for(String str: arr){
			if(parsedArr.isEmpty()){
				parsedArr.push(str);
				continue;
			}
			if(parsedArr.peek().equals("+")){
				parsedArr.pop();
				int num1 = Integer.parseInt(parsedArr.pop());
				int num2 = Integer.parseInt(str);
				parsedArr.push(String.valueOf(num1+num2));
			}else if(parsedArr.peek().equals("-")){
				parsedArr.pop();
				int num1 = Integer.parseInt(parsedArr.pop());
				int num2 = Integer.parseInt(str);
				parsedArr.push(String.valueOf(num1-num2));
			}else{
				parsedArr.push(str);
			}

		}
		return new ArrayList<>(parsedArr);
	}
}
