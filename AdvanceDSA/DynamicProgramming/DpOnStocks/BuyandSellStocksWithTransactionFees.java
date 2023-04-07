package AdvanceDSA.DynamicProgramming.DpOnStocks;
import java.util.* ;
import java.io.*; 
public class BuyandSellStocksWithTransactionFees {
    //Extension : Best time to buy and sell stock - II (infinite trasections allowed)
    // --> Same code of buy and sell -II just one line changed
    /*
     * 
     * Buy and Sell Stocks With Transaction Fees | (DP – 40)
            We are given an array Arr[] of length n. 
            It represents the price of a stock on ‘n’ days. 
            The following guidelines need to be followed:

        We can buy and sell the stock any number of times.
        In order to sell the stock, we need to first buy it on the same or any previous day.
            We can’t buy a stock again after buying it once. In other words, 
            we first buy a stock and then sell it. After selling we can buy and sell again. 
            But we can’t sell before buying and can’t buy before selling any previously bought stock.
        After every transaction, there is a transaction fee (‘fee’) associated with it.

        Sample Input 1 :
            2
            2 0
            1 2
            4 2
            1 3 5 6
        Sample Output 1 :
            1
            3
        Explanation Of Sample Input 1 :
        For the first test case, we can buy the chocolate on the first 
        day and sell it on the second day to generate the maximum profit of 1 cent.

        For the second test case wee can buy the chocolate on the 
        first day and sell it on the last day to get the profit of (6 - 1 - 2) = 3 cents.
     * 
    */
}

class Solution {
	public static int maximumProfit(int n, int fee, int[] prices) {
		// Write your code here.
		// return fun(prices,0,1,fee);
		// int[][] dp = new int[prices.length][2];
		// for(int[] row : dp){
		// 	Arrays.fill(row,-1);
		// }
		// return memo(prices,0,1,fee,dp);

		// return tab(prices,fee);
		return tabOptimization(prices, fee);
	}

	//recursion
	private static int fun(int[] arr,int ind,int buy,int fee){
		if(ind == arr.length) return 0;

		int profit = 0;
		
		if(buy == 1){
			profit = Math.max(-arr[ind]+fun(arr,ind+1,0,fee),0+fun(arr,ind+1,1,fee));
		}else{
			profit = Math.max(arr[ind]-fee+fun(arr,ind+1,1,fee),0+fun(arr,ind+1,0,fee));
		}

		return profit;
	}

	//memoization
	private static int memo(int[] arr,int ind,int buy,int fee,int[][] dp){
		if(ind == arr.length) return 0;

		if(dp[ind][buy] != -1) return dp[ind][buy];
		int profit = 0;
		
		if(buy == 1){
			profit = Math.max(-arr[ind]+memo(arr,ind+1,0,fee,dp),0+memo(arr,ind+1,1,fee,dp));
		}else{
			profit = Math.max(arr[ind]-fee+memo(arr,ind+1,1,fee,dp),0+memo(arr,ind+1,0,fee,dp));
		}

		return dp[ind][buy] = profit;
	}

	//tabulation
	private static int tab(int[] arr,int fee){
		int n = arr.length;
		int[][] dp = new int[n+1][2];

		dp[n][0] = 0;
		dp[n][1] = 0;

		for(int ind = n-1 ; ind>=0 ; ind--){
			for(int buy = 0 ; buy < 2 ; buy++){
				int profit = 0 ;

				if(buy == 1){
					profit = Math.max(-arr[ind]+dp[ind+1][0],0+dp[ind+1][buy]);
				}else{
					profit = Math.max(arr[ind]-fee+dp[ind+1][1],0+dp[ind+1][0]);
				}

				dp[ind][buy] = profit;
			}
		}

		return dp[0][1];
	}

	private static int tabOptimization(int[] arr,int fee){
		int n = arr.length;
		int[] after = new int[2];
		int[] cur = new int[2];

		after[0] = 0;
		after[1] = 0;

		for(int ind = n-1 ; ind>=0 ; ind--){
			for(int buy = 0 ; buy < 2 ; buy++){
				int profit = 0 ;

				if(buy == 1){
					profit = Math.max(-arr[ind]+after[0],0+after[1]);
				}else{
					profit = Math.max(arr[ind]-fee+after[1],0+after[0]);
				}

				cur[buy] = profit;
			}

			int[] temp = after;
			after = cur;
			cur = temp;
		}

		return after[1];
	}
}
