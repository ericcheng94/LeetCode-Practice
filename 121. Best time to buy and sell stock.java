/*
** PART I - EASY
*/

// Brute force method

// class Solution {
// 	public int maxProfit(int[] prices) {
// 		int profit = 0;
// 		for (int i = 0; i < prices.length - 1; i++) {
// 			for (int j = i + 1; j < prices.length; j++) {
// 				if (prices[j] > prices[i]) {
// 					if (profit < prices[j] - prices[i])
// 						profit = prices[j] - prices[i];
// 				}
// 			}
// 		}
// 		return profit;
// 	}
// }


// Dynamic programming method
class Solution {
	public int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int profit = 0;

		for (int i = 0; i < prices.length; i++) {
			if (minPrice > prices[i])
				minPrice = prices[i];
			if (profit < prices[i] - minPrice)
				profit = prices[i] - minPrice;
		}
		return (profit);
	}
}

/*
** PART II - EASY
*/

// Dynamic programming method
class Solution {
	public int maxProfit(int[] prices) {
		int minPrice    = Integer.MAX_VALUE;
		int maxProfit   = 0;
		int totalProfit = 0;
		int prevPrice   = 0;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < prevPrice) {
				minPrice = Integer.MAX_VALUE;
				totalProfit += maxProfit;
				maxProfit = 0;
			}
			if (minPrice > prices[i])
			minPrice = prices[i];
			if (maxProfit < prices[i] - minPrice)
				maxProfit = prices[i] - minPrice;
			prevPrice = prices[i];
		}
		if (maxProfit != 0)
			totalProfit += maxProfit;
		return (totalProfit);
	}
}

/*
** PART III - HARD
*/
// Dynamic programming method
class Solution {
	public int maxProfit(int[] prices) {
		int minPrice    = Integer.MAX_VALUE;
		int maxProfit   = 0;

		int totalProfit = 0;
		int prevPrice   = 0;

		int bestSaleOne = 0;
		int bestSaleTwo = 0;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < prevPrice) {
				if (maxProfit > bestSaleOne)
					bestSaleOne = maxProfit;
				else if (maxProfit > bestSaleTwo)
					bestSaleTwo = maxProfit;
				minPrice = Integer.MAX_VALUE;
				maxProfit = 0;
			}
			if (minPrice > prices[i])
			minPrice = prices[i];
			if (maxProfit < prices[i] - minPrice)
				maxProfit = prices[i] - minPrice;
			prevPrice = prices[i];
		}
		if (maxProfit != 0) {
			if (maxProfit > bestSaleOne)
				bestSaleOne = maxProfit;
			else if (maxProfit > bestSaleTwo)
				bestSaleTwo = maxProfit;
		}
		return (bestSaleOne + bestSaleTwo);
	}
}
