package Greedy;

public class MonotoneIncreasingDigits {
	public int monotoneIncreasingDigits(int n) {
		String numStr = String.valueOf(n);
		StringBuilder newNum = new StringBuilder();
		int lastIndexModified = -1;
		char lastChar= numStr.charAt(numStr.length()-1);
		for(int i = numStr.length()-2;i>=0;i--){
			if(numStr.charAt(i) > lastChar){
				lastIndexModified = i;
				lastChar = (char)(numStr.charAt(lastIndexModified) - 1 );
			}else{
				lastChar = numStr.charAt(i);
			}
		}
		if(lastIndexModified == -1) return n;
		for(int i=0;i<lastIndexModified;i++){
			newNum.append(numStr.charAt(i));
		}
		newNum.append((char)(numStr.charAt(lastIndexModified) - 1 ));
		for(int i=lastIndexModified+1;i<numStr.length();i++){
			newNum.append("9");
		}
		return newNum.length() == 0 ? 0 : Integer.parseInt(newNum.toString());
	}
}
