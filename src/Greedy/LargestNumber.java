package Greedy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		String ans= Arrays.stream(nums).boxed().map(String::valueOf).sorted((a,b)->-(a+b).compareTo(b+a)).collect(Collectors.joining());
		return (ans.charAt(0)=='0'?"0":ans);
	}
}
