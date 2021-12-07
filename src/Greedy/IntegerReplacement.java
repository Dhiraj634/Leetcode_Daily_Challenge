package Greedy;


import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {
	Map<Long,Integer> map = new HashMap<>();
	public int integerReplacement(int n) {
		return (int)dfs(n);
	}
	// Please Note here we are using the return type and the parameter as Long to include the case where n = Integer.MAX_VALUE, in that n+1 can overflow
	// hence to avoid that situation
	private long dfs(long n){
		if(n == 1){
			return 0;
		}
		if(map.containsKey(n)) return map.get(n);
		long num = 0;
		if(n%2==0){
			num =  dfs(n/2)+1;
		}
		else{
			num =  Math.min(dfs(n+1),dfs(n-1))+1;
		}
		map.put(n, (int)num);
		return num;
	}
	/**
	 * Another Approach
	 *  public int integerReplacement(int n) {
	 *         int ans=0;
	 *         if(n>2147483646)
	 *             n--;
	 *
	 *         while(n!=1){
	 *              ans++;
	 *             if(n==3)return ans+1;
	 *
	 *             if(n%2==0)
	 *                 n=n/2;
	 *             else if(((n)/2)%2==1) // Doing this because we want to keep the number even as much as possible
	 *                 n=(n+1);
	 *             else
	 *                 n=n-1;
	 *         }
	 *         return ans;
	 *     }
	 * */
}
