package Greedy;

public class BestTimeToBuyAndSellStockWithTransactionFee {
	public int maxProfit(int[] prices, int fee) {
		int lower = prices[0], higher = prices[0], profit = 0;
		for(int i=1;i<prices.length;i++){
			if((higher - prices[i])>=fee){
				profit += higher-lower >= fee ? (higher - lower)-fee : 0;
				lower = prices[i];
				higher = prices[i];
			}else if(prices[i] > higher){
				higher = prices[i];
			}else if(prices[i] < lower ){
				lower = prices[i];
			}
		}
		profit += higher-lower >= fee ? (higher - lower)-fee : 0;
		return profit;

	}
}
