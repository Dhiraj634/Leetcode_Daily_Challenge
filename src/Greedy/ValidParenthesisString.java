package Greedy;

import java.util.Stack;


public class ValidParenthesisString {
	public boolean checkValidString(String s) {
		int lo = 0, hi = 0;
		for (char c: s.toCharArray()) {
			// lower value will increase if c=='(' else decrease becz we try to minimize lower as much as possible
			// that can be done by converting * to )
			lo += c == '(' ? 1 : -1;
			// this hi records that at any point the number of close is not greater than number of open
			// If hi < 0 meaning at that index event if we convert all * to ( then also ) is greater hence not valid so break
			hi += c != ')' ? 1 : -1;
			if (hi < 0) break;
			//if li < 0 meaning in the first step we have decreased lo , which we should have increased so we are increasing
			// lo and setting it to 0.
			// Please note: the main work of lo is that when we reach the end it should be zero
			lo = Math.max(lo, 0);
		}
		return lo == 0;
	}
}
