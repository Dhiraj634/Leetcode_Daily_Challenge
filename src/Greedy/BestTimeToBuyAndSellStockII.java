package Greedy;

public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
		if(prices.length == 1) return 0;
		boolean hasStock = false;
		int stock = -1;
		int profit = 0;
		for(int i=1;i<prices.length ;i++){
			if(prices[i] > prices[i-1] && !hasStock){
				stock = prices[i-1];
				hasStock = true;
			}else if(prices[i] < prices[i-1] && hasStock){
				profit+= (prices[i-1] - stock);
				hasStock = false;
			}
		}
		if(hasStock){
			profit += (prices[prices.length-1] - stock);
		}
		return profit;

	}
}
