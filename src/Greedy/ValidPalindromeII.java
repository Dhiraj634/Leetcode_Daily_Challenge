package Greedy;

public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
		int start = 0, end = s.length()-1;
		while(start <= end){
			if(s.charAt(start) != s.charAt(end)){
				/**
				 * boolean case1 = isPalindrome(s,start,end-1);
				 * boolean case2 = isPalindrome(s,start+1,end);
				 * return case1 || case2;
				 * */
				// This is good because in case we get true from the first function call we will not call the
				// second function, whereas in the above code 2 function call are made whatever be the case.
				return isPalindrome(s,start,end-1) || isPalindrome(s,start+1,end);

			}
			start++;
			end--;
		}
		return true;
	}
	private boolean isPalindrome(String s, int start, int end){
		while(start <= end){
			if(s.charAt(start) != s.charAt(end)){
					return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
