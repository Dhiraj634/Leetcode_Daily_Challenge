package Greedy;

public class MonotoneIncreasingDigits {
	public int monotoneIncreasingDigits(int n) {
		if(n == 0) return 0;
		String numStr = String.valueOf(n);
		StringBuilder newNum = new StringBuilder();
		int lastIndexModified = -1;
		char[] lastChar= numStr.toCharArray();
		/** Checking the index which was updated last when traversing from end
		 *  We will get the index of it and then just reduce that index value by 1
		 * */
		for(int i = numStr.length()-2;i>=0;i--){
			if(lastChar[i] > lastChar[i+1]){
				lastIndexModified = i;
				lastChar[i]--;
			}
		}
		// if lastIndexModified == 1, means all the digits are already monotonically increasing
		if(lastIndexModified == -1) return n;

		// if lastIndexModified != -1 , we add till the lastIndexModified and then add all '9' after that
		for(int i=0;i<=lastIndexModified;i++){
			newNum.append(lastChar[i]);
		}

		// Adding all '9' after lastIndexModified
		for(int i=lastIndexModified+1;i<numStr.length();i++){
			newNum.append("9");
		}
		return Integer.parseInt(newNum.toString());
	}
}
