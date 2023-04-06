package AdvanceDSA.DynamicProgramming.DpOnStocks;

public class BuyAndSellStocksII{
    /*
     * Problem Statement: 

        Buy and Sell Stock – II 

        Problem Link: Best Time to Buy and Sell Stock II

            We are given an array Arr[] of length n. It represents the price of a stock on ‘n’ days. 
            The following guidelines need to be followed:

                We can buy and sell the stock any number of times.
                In order to sell the stock, we need to first buy it on the 
                same or any previous day.
                We can’t buy a stock again after buying it once. 
                In other words, we first buy a stock and then sell it. 
                After selling we can buy and sell again. But we can’t sell before 
                buying and can’t buy before selling any previously bought stock.

        Sample Input 1 :
            1
            7
            1 2 3 4 5 6 7
        Sample Output 1 :
            6
        Explanation :
        We can make the maximum profit by buying the stock on the first day and selling it on the last day.
    */
}

class Solution {
    public static long getMaximumProfit (int n, long[] values) {
        // Your code goes here.
        // return recursion(values, 0, 1);
        // long[][] dp = new long[n][2];

        // return memo(values, 0, 1, dp);

        // return tabu(values);

        return tabOptimal(values);
    }

    //recursion for this problem
    static long recursion(long[] arr,int ind,int buy){
        //base case
        if(ind == arr.length) return 0;

        //other cases
        long profit = 0L;
        if(buy == 1){
            //we need to perform buy
            //here we can have two options 
            //we can buy or we can ignore
            profit = Math.max(-arr[ind]+recursion(arr, ind+1, 0),
                            0 + recursion(arr, ind+1, 1));

        }else{
            //we had bought something we need to sell that
            //we need to perform sell
            //here we can have two options 
            //we can sell or we can ignore
            profit = Math.max(arr[ind]+recursion(arr, ind+1, 1),
                            0 + recursion(arr, ind+1, 0));
        }

        return profit;
    }

    //memoization
    static long memo(long[] arr,int ind,int buy,long[][] dp){
        //base case
        if(ind == arr.length) return 0;

        if(dp[ind][buy] != 0) return dp[ind][buy];

        //other cases
        long profit = 0L;
        if(buy == 1){
            //we need to perform buy
            //here we can have two options 
            //we can buy or we can ignore
            profit = Math.max(-arr[ind]+memo(arr, ind+1, 0,dp),
                            0 + memo(arr, ind+1, 1,dp));

        }else{
            //we had bought something we need to sell that
            //we need to perform sell
            //here we can have two options 
            //we can sell or we can ignore
            profit = Math.max(arr[ind]+memo(arr, ind+1, 1,dp),
                            0 + memo(arr, ind+1, 0,dp));
        }

        return dp[ind][buy] = profit;
    }

    //as memoization can give stack overFlow
    //we need to use tabulation
    static long tabu(long[] arr){
        int n = arr.length;
        // for base cases
        long[][] dp = new long[n+1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int ind = n-1 ; ind >= 0 ; ind--){
            for(int buy = 0 ; buy < 2 ; buy++){
                long profit = 0L;
                if(buy == 1){
                    //we need to perform buy
                    //here we can have two options 
                    //we can buy or we can ignore
                    profit = Math.max(-arr[ind]+dp[ind+1][0],
                                    0 + dp[ind+1][1]);

                }else{
                    //we had bought something we need to sell that
                    //we need to perform sell
                    //here we can have two options 
                    //we can sell or we can ignore
                    profit = Math.max(arr[ind]+dp[ind+1][1],
                                    0 + dp[ind+1][0]);
                }

                dp[ind][buy] = profit;
            }
        }

        return dp[0][1];
    }

    //tabulation optimization
    static long tabOptimal(long[] arr){
        int n = arr.length;
        // for base cases
        long[][] dp = new long[n+1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;

        long[] cur = new long[2];
        long[] after = new long[2];

        for(int ind = n-1 ; ind >= 0 ; ind--){
            for(int buy = 0 ; buy < 2 ; buy++){
                long profit = 0L;
                if(buy == 1){
                    //we need to perform buy
                    //here we can have two options 
                    //we can buy or we can ignore
                    profit = Math.max(-arr[ind]+after[0],
                                    0 + after[1]);

                }else{
                    //we had bought something we need to sell that
                    //we need to perform sell
                    //here we can have two options 
                    //we can sell or we can ignore
                    profit = Math.max(arr[ind]+after[1],
                                    0 + after[0]);
                }

                cur[buy] = profit;
            }
            long[] temp = after;
            after = cur;
            cur = temp;
        }

        return after[1];
    }

}
