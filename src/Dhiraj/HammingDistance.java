/**
 * Daily Leetcode Challenge 19/Nov/2021
 * */
package Dhiraj;

public class HammingDistance {

	public int hammingDistance(int x, int y) {
		int count = 64;
		int ans=0;
		while(count!=0){
			int xBit = x & 1;
			int yBit = y & 1;
			if(xBit != yBit){
				ans++;
			}
			count--;
			x = (x>>1);
			y = (y >>1);
		}
		return ans;

	}
}
