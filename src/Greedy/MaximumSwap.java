package Greedy;

import java.util.PriorityQueue;

public class MaximumSwap {
	public int maximumSwap(int num) {
		PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> b-a);
		String numStr = String.valueOf(num);
		for(char ch: numStr.toCharArray()){
			pq.add(ch);
		}
		int indexToSwap = 0;
		char charToSwap = '\0';
		while(!pq.isEmpty()){
			if(numStr.charAt(indexToSwap) == pq.peek()){
				pq.poll();
				indexToSwap++;
			}else{
				charToSwap = pq.poll();
				break;
			}
		}
		if(charToSwap == '\0'){
			return num;
		}
		else {
			int indexToSwapWith = indexToSwap;
			for (int i = indexToSwap; i < numStr.length(); i++) {
				if (numStr.charAt(i) == charToSwap) {
					indexToSwapWith = i;
				}
			}
				StringBuilder finalAns = new StringBuilder();
				finalAns.append(numStr, 0, indexToSwap)
						.append(numStr.charAt(indexToSwapWith))
						.append(numStr, indexToSwap + 1, indexToSwapWith)
						.append(numStr.charAt(indexToSwap))
						.append(numStr.substring(indexToSwapWith + 1));
				return Integer.parseInt(finalAns.toString());
			}
		}


}
