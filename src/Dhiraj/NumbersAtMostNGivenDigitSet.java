package Dhiraj;

import java.util.Arrays;
import java.util.HashSet;

public class NumbersAtMostNGivenDigitSet {
	public int atMostNGivenDigitSet(String[] digits, int n) {
		int[] fre = new int[10];
		int[] cummfre = new int[10];
		for(String str: digits){
			fre[Integer.parseInt(str)]++;
		}
		for(int i=1;i<10;i++){
			cummfre[i] = fre[i] + cummfre[i-1];
		}
		int len = (int)Math.log10(n)+1;
		int ans = 0;
		for(int i=1;i<=len-1;i++){
			ans+= (int)Math.pow(digits.length,i);
		}
		String numStr = ""+ n;
		boolean isNumber = true;
		for(int i=0;i<numStr.length();i++){
			int digit = Integer.parseInt(numStr.charAt(i)+"");
			int temp = 0;
			if(digit !=0)
				temp = (int)(cummfre[digit-1] * Math.pow(digits.length, len-i-1));
			ans+=temp;
			isNumber = isNumber && fre[digit] > 0;
			if(!isNumber) break;
		}
		if(isNumber)ans++;
		return ans;
	}
}
