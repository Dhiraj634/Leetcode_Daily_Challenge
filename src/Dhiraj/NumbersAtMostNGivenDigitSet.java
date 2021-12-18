package Dhiraj;

public class NumbersAtMostNGivenDigitSet {
	public int atMostNGivenDigitSet(String[] digits, int n) {
		int[] fre = new int[10];
		int[] cumFre = new int[10];
		for(String str: digits){
			fre[Integer.parseInt(str)]++;
		}
		for(int i=1;i<10;i++){
			cumFre[i] = fre[i] + cumFre[i-1];
		}
		String numStr = String.valueOf(n);
		int len = numStr.length();
		int ans = 0;
		for(int i=1;i<=len-1;i++){
			ans+= (int)Math.pow(digits.length,i);
		}

		boolean isNumber = true;
		for(int i=0;i<numStr.length();i++){
			int digit = Integer.parseInt(String.valueOf(numStr.charAt(i)));
			int temp = 0;
			if(digit !=0)
				temp = (int)(cumFre[digit-1] * Math.pow(digits.length, len-i-1));
			ans+=temp;
			/**Just above this part we have calculated all the numbers when the digit
			 * is less than the current digit
			 * Here we are checking is the digit itself is present or not. If not then we need not
			 * move forward as doing so means the digit is preset.
			 */
			isNumber = fre[digit] > 0;
			if(!isNumber) break;
		}
		if(isNumber)ans++;
		return ans;
	}
}
