package Greedy;

import java.util.Stack;
import java.util.stream.Collectors;

public class CreateMaximumNumber {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		String str = "0";
		for(int i=0;i<=k;i++){
			String temp1 = getMaxNumber(nums1,nums1.length - i);
			String temp2 = getMaxNumber(nums2,nums2.length - k+i);
			String finalAns = mergeTwoArray(temp1, temp2);
			if(str.length() <= finalAns.length()){
				if(str.length() < finalAns.length())
				{
					str = finalAns;
				}else if(str.compareTo(finalAns) < 0){
					str = finalAns;
				}
			}
		}
		int[] arr = new int[str.length()];
		int m = 0;
		for(char ch: str.toCharArray()){
			arr[m++] = ch - '0';
		}
		return arr;
	}

	private String getMaxNumber(int[] arr, int countOfRemove){
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while(i< arr.length && countOfRemove > 0){
			if(stack.isEmpty() || stack.peek() >= arr[i]){
				stack.push(arr[i]);
				i++;
			}else{
				stack.pop();
				countOfRemove--;
			}
		}
		while(i<arr.length){
			stack.push(arr[i++]);
		}
		while(countOfRemove > 0){
			stack.pop();
			countOfRemove--;
		}
		return stack.stream().map(String::valueOf).collect(Collectors.joining());
	}
	private String mergeTwoArray(String str1, String str2){
		StringBuilder sb = new StringBuilder();
		int left = 0, right = 0;
		while(left < str1.length() && right < str2.length()){
			if(str1.charAt(left) < str2.charAt(right)){
				sb.append(str2.charAt(right));
				right++;
			}else if(str1.charAt(left) > str2.charAt(right)){
				sb.append(str1.charAt(left));
				left++;
			}else{
				if(str1.substring(left).compareTo(str2.substring(right)) > 0){
					sb.append(str1.charAt(left));
					left++;
				}else{
					sb.append(str2.charAt(right));
					right++;
				}
			}
		}
		while(left < str1.length()){
			sb.append(str1.charAt(left++));
		}
		while(right < str2.length()){
			sb.append(str2.charAt(right++));
		}
		return sb.toString();

	}
}
