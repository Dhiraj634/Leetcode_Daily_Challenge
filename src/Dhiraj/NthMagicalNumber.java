package Dhiraj;

public class NthMagicalNumber {
	public int nthMagicalNumber(int n, int a, int b) {
		int N = (int)Math.pow(10,9)+7;
		long longN = n * 1L;
		long maxNum = Math.min(a * longN, b* longN);
		long start = 1;
		long lcm = (a*b*1L)/gcdByEuclidsAlgorithm(a,b);
		while(start <= maxNum){
			long mid = (start+maxNum)/2;
			long count = (mid/a + mid / b - mid / lcm);
			if(count == longN){
				if(mid%a ==0 || mid %b==0 || mid%lcm==0){
					return (int)(mid%N);
				}else{
					maxNum = mid-1;
				}
			}else if(count > longN){
				maxNum = mid-1;
			}else{
				start = mid+1;
			}
		}
		return (int)(start%N);
	}

	int gcdByEuclidsAlgorithm(int n1, int n2) {
		if (n2 == 0) {
			return n1;
		}
		return gcdByEuclidsAlgorithm(n2, n1 % n2);
	}
}
