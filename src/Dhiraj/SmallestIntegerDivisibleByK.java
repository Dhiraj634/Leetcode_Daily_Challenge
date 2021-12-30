package Dhiraj;

public class SmallestIntegerDivisibleByK {
	public int smallestRepunitDivByK(int k) {
		// Taking k length array since there can be atMax k remainders
		int[] rem = new int[k];
		int num = 1;
		int length =1;
		while(num%k!=0 && rem[num%k]!=1){
			int remainder = num%k;
			num = remainder * 10 + 1;
			length++;
			rem[remainder] = 1;

		}
		if(num%k == 0) return length;
		else return -1;
	}
	/**
	 * Why using remainder again and again?
	 *
	 * let a be some number
	 * and a % k = rem
	 * now when to the next number since rem != 0 we have
	 * b = 10 * a + 1
	 * and
	 * b % K = (10 * a + 1)%k = (10 % k) * (a % k) + 1 % k = rem * (10 % k) + 1 % K
	 * Now,
	 * (10 * a + 1)%k
	 * = (10 % k) * (a % k) + 1 % k
	 * = rem * (10 % k) + 1 % K
	 * since [ rem < k ] so, [rem = rem % k]
	 * = (rem % k) * (10 % K) + 1 % k
	 * = (rem * 10) % K + 1 % 10
	 * = (rem * 10 + 1) % k
	 *
	 */

	 /**
	 * Why loop is repeated only K times ?
	  * We are keeping track of the remainder that has come, and it is obvious that if the remainder is repeated then we do not have the number.
	  * Now suppose we do not get any repeated remainder with each iteration then after K iteration all the remainders will have come
	  * and in the (K+1)th iteration we will see repetition and exit and return -1
	  * And if we see repetition in less than K repetition then also we will exit returning -1.
	  * so in any case the loop will run at max of K times
	  * */
}
