package AdvanceDSA.DynamicProgramming.DpOnStocks;
public class BuyandSellStocksWithCooldown{
    public static void main(String[] args) {
        //Extension of Buy and Sell stocks - II(infinite transections)
        //Space optimization not done because it will need three arrays  because of (ind+2)
        /*
         * 
         * We are given an array Arr[] of length n. It represents the price of a stock on ‘n’ days. 
         *  The following guidelines need to be followed:

                We can buy and sell the stock any number of times.
                In order to sell the stock, we need to first buy it on the same or any previous day.
                We can’t buy a stock again after buying it once. In other words, we first buy 
                    a stock and then sell it. After selling we can buy and sell again. But we can’t 
                    sell before buying and can’t buy before selling any previously bought stock.
                We can’t buy a stock on the very next day of selling it. This is the cooldown clause.


            Sample Input 1:
                2
                5
                4 9 0 4 10
                4
                1 2 3 4
            Sample Output 1:
                11
                3
            Explanation:
            For the first test case, prices = [4, 9, 0, 4, 10], 
                To get maximum profits you will have to buy on day 0 and sell on day 1 to 
                make a profit of 5, and then you have to buy on day 3  and sell on day 4 
                to make the total profit of 11. Hence the answer is 11.

            For the second test case, prices = [1, 2, 3, 4]. 
                To get the maximum profit you have to buy the stock on 
                day 0 and sell on day 3 to get the maximum profit of 4. 
                Hence the answer is 4.
         * 
        */
    }
}

class Solution {

	public static int stockProfit(int[] prices) {
		// Write your code here.

		// return fun(prices,0,1);
		// int[][] dp = new int[prices.length][2];
		// for(int[] row : dp){
		// 	Arrays.fill(row,-1);
		// }
		// return memo(prices, 0, 1, dp);

		return tab(prices); // dp size for tabulation dp[n+2][2] // n+2 because 
																 // if ind will be n-1
																 // then the last will be
																 // (n+1) -- because we are doing 
																 // ind+2 -- so size should be 1 more
																 // i.e. why it will be n+2
	}

	//recursion
	private static int fun(int[] arr,int ind,int buy){
		//same as unlimited transaction
		if(ind >= arr.length) return 0;

		//
		int pro = 0;
		if(buy == 1){
			pro = Math.max(-arr[ind]+fun(arr,ind+1,0),
						     fun(arr,ind+1,1));
		}else{
			pro = Math.max(arr[ind]+fun(arr,ind+2,1),
						    fun(arr,ind+1,0));
		}

		return pro;
	}
	private static int memo(int[] arr,int ind,int buy,int[][] dp){
		//same as unlimited transaction
		if(ind >= arr.length) return 0;

		if(dp[ind][buy] != -1) return dp[ind][buy];
		//
		int pro = 0;
		if(buy == 1){
			pro = Math.max(-arr[ind]+memo(arr,ind+1,0,dp),
						     memo(arr,ind+1,1,dp));
		}else{
			pro = Math.max(arr[ind]+memo(arr,ind+2,1,dp),
						    memo(arr,ind+1,0,dp));
		}

		return dp[ind][buy] = pro;
	}

	//Tabulation
	private static int tab(int[] arr){
		int n = arr.length;
		int[][] dp = new int[n+2][2];

		for(int ind = n-1 ; ind >= 0 ; ind--){
			for(int buy = 0 ; buy < 2 ; buy++){
				int profit = 0;

				if(buy==1){
					profit = Math.max(-arr[ind]+dp[ind+1][0],0+dp[ind+1][1]);
				}else{
					profit = Math.max(arr[ind]+dp[ind+2][1],0+dp[ind+1][0]);
				}

				dp[ind][buy] = profit;
			}
		}

		return dp[0][1];
	}
}
