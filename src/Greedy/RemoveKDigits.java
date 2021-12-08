package Greedy;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		int len = num.length();
		int removed = 0;
		// If this condition is removed then also the code will work
		if(k == num.length()) return "0";
		StringBuilder sb = new StringBuilder();
		sb.append(num.charAt(0));
		int i=1;
		while(i < num.length() && removed != k){
			char ch = num.charAt(i);
			if(sb.length() == 0){
				sb.append(ch);i++;
			}
			else {
				char ch2 = sb.charAt(sb.length()-1);
				// here we are checking if the last element is greater than the current element
				// if yes then we remove it increase the count of removed by one
				// we keep doing this until the last digit is less than the incoming one, in that case we just add the incoming one and move to the next character
				if(ch2 - '0' > ch - '0'){
					sb.deleteCharAt(sb.length()-1);
					removed++;
				}else{
					sb.append(ch);
					i++;
				}
			}
		}
		sb.append(num.substring(i));
		i=0;
		// Once we have come out of while loop, that can be either of the removal of k digits or we reached the end of num string
		// that is why we take the substring to get string of length len-k
		// Note : this substring will be the minimum because of the above while loop
		String answer = sb.substring(0,len-k);

		// Removing the zeros in the beginning
		for(;i<answer.length();i++){
			if(answer.charAt(i)!='0'){
				break;
			}
		}
		answer = answer.substring(i);
		return answer.length() == 0 ? "0" : answer;

	}
}
