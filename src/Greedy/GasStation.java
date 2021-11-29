package Greedy;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;

		int startIndex = -1, totalCost = 0;

		/**
		 * Fetching the index after which the sum of the costs is non-negative
		 * */
		for(int i=0;i<len;i++){
			if((gas[i] - cost[i]) + totalCost >= 0){
				totalCost+=(gas[i] - cost[i]);
				startIndex = startIndex == -1 ? i : startIndex;
			}else{
				startIndex = -1;
				totalCost = 0;
			}
		}
		// If there is none then we return -1
		if(startIndex == -1) return -1;
		else{
			int temp =0;

			/**
			 * If there is some index after which the totalCost is non-negative
			 * then we check if the sum of the (gas[i]-cost[i]) just before the index
			 * the sum of cost before the index and after the index are non-negative then return the
			 * startIndex else -1
			 * */
			for(int i=0;i<startIndex;i++){
				temp+= (gas[i] - cost[i]);
			}
			if(totalCost+temp >= 0){
				return startIndex;
			}else{
				return -1;
			}
		}
	}
}
