package AdvanceDSA.DynamicProgramming.DpOnStocks;
import java.util.* ;
import java.io.*; 
public class BestTimetoBuyandSellStockIII {
    /*

     //Same way we can solve for k transactions also
     * We are given an array Arr[] of length n. It represents the price of a stock on ‘n’ days. The following guidelines need to be followed:

        We can buy and sell the stock any number of times.
        In order to sell the stock, we need to first buy it on the same or any previous day.
        We can’t buy a stock again after buying it once. In other words, we first buy a stock 
        and then sell it. After selling we can buy and sell again. But we can’t sell before 
        buying and can’t buy before selling any previously bought stock.
        We can do at most 2 transactions.
    */
}

class Solution {
	public static int maxProfit(ArrayList<Integer> prices, int n) {
        /*
         * Note ::: Instead of 3D dp int[n][buy][sell]
         *          we can use 2D dp int[n][2*trans]
         *              --> For that on Even values of trans we can buy stock
         *              --> and for odd values we can Sell it 
         *              --> Rest logic will be same
         * 
        */


		// Write your code here.
		// Your code goes here.
        // return recursion(prices, 0, 1,2);
        // int[][][] dp = new int[n][2][2+1];

        // return memo(prices, 0, 1, 2,dp);

        // return tabu(prices);

        return tabOptimal(prices);
    }

    //recursion for this problem
    static int recursion(ArrayList<Integer> arr,int ind,int buy,int trans){
        //base case
		if(trans == 0) return 0;
        if(ind == arr.size()) return 0;

        //other cases
        int profit = 0;
        if(buy == 1){
            //we need to perform buy
            //here we can have two options 
            //we can buy or we can ignore
            profit = Math.max(-arr.get(ind)+recursion(arr, ind+1, 0,trans),
                            0 + recursion(arr, ind+1, 1,trans));

        }else{
            //we had bought something we need to sell that
            //we need to perform sell
            //here we can have two options 
            //we can sell or we can ignore
            profit = Math.max(arr.get(ind)+recursion(arr, ind+1, 1,trans-1),
                            0 + recursion(arr, ind+1, 0,trans));
        }

        return profit;
    }

    //memoization
    static int memo(ArrayList<Integer> arr,int ind,int buy,int trans,int[][][] dp){
        //base case
		//
		if(trans == 0) return 0;
        if(ind == arr.size()) return 0;

        if(dp[ind][buy][trans] != 0) return dp[ind][buy][trans];

        //other cases
        int profit = 0;
        if(buy == 1){
            //we need to perform buy
            //here we can have two options 
            //we can buy or we can ignore
            profit = Math.max(-arr.get(ind)+memo(arr, ind+1, 0,trans,dp),
                            0 + memo(arr, ind+1, 1,trans,dp));

        }else{
            //we had bought something we need to sell that
            //we need to perform sell
            //here we can have two options 
            //we can sell or we can ignore
            profit = Math.max(arr.get(ind)+memo(arr, ind+1, 1,trans-1,dp),
                            0 + memo(arr, ind+1, 0,trans,dp));
        }

        return dp[ind][buy][trans] = profit;
    }

    //as memoization can give stack overFlow
    //we need to use tabulation
    static int tabu(ArrayList<Integer> arr){
        int n = arr.size();
        // for base cases
        int[][][] dp = new int[n+1][2][2+1];
        for(int ind=0 ; ind <=n ; ind++){
			for(int buy = 0 ; buy < 2 ; buy++){
				dp[ind][buy][0] = 0;
			}
		}

		for(int buy = 0 ; buy < 2 ; buy++){
			for(int trans = 1 ; trans < 3 ; trans++){
				dp[n][buy][trans] = 0;
			}
		}

        for(int ind = n-1 ; ind >= 0 ; ind--){
            for(int buy = 0 ; buy < 2 ; buy++){
				for(int trans = 1; trans < 3 ; trans++){
					int profit = 0;
					if(buy == 1){
						//we need to perform buy
						//here we can have two options 
						//we can buy or we can ignore
						profit = Math.max(-arr.get(ind)+dp[ind+1][0][trans],
										0 + dp[ind+1][1][trans]);

					}else{
						//we had bought something we need to sell that
						//we need to perform sell
						//here we can have two options 
						//we can sell or we can ignore
						profit = Math.max(arr.get(ind)+dp[ind+1][1][trans-1],
										0 + dp[ind+1][0][trans]);
					}

					dp[ind][buy][trans] = profit;
				}
            }
        }

        return dp[0][1][2];
    }

    //tabulation optimization
    static int tabOptimal(ArrayList<Integer> arr){
        int n = arr.size();

		int[][] cur = new int[2][2+1];
		int[][] after = new int[2][2+1];
        

        for(int ind = n-1 ; ind >= 0 ; ind--){
            for(int buy = 0 ; buy < 2 ; buy++){
				for(int trans = 1; trans < 3 ; trans++){
					int profit = 0;
					if(buy == 1){
						//we need to perform buy
						//here we can have two options 
						//we can buy or we can ignore
						profit = Math.max(-arr.get(ind)+after[0][trans],
										0 + after[1][trans]);

					}else{
						//we had bought something we need to sell that
						//we need to perform sell
						//here we can have two options 
						//we can sell or we can ignore
						profit = Math.max(arr.get(ind)+after[1][trans-1],
										0 + after[0][trans]);
					}

					cur[buy][trans] = profit;
				}
            }
			int[][] temp = after;
			after = cur;
			cur = temp;
        }

        return after[1][2];
    }

}
