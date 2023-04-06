package AdvanceDSA.DynamicProgramming.DpOnStocks;
import java.util.ArrayList;

public class BestTimeToBuyAndSellStock {
    /*
     * Best time to buy and sell stock

        We are given an array Arr[] of length n. 
        It represents the price of a stock on ‘n’ days. 
        The following guidelines need to be followed:

        We can buy and sell a stock only once.
        We can buy and sell the stock on any day 
        but to sell the stock, we need to first buy it on 
        the same or any previous day.
        We need to tell the maximum profit one can get 
        by buying and selling this stock.

        Sample Input 1:
            2
            4
            1 2 3 4
            4
            2 2 2 2
        Sample Output 1:
            3
            0

    */
}

class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        int maxProfit = 0;

        int min = prices.get(0);

        for(int i=1 ; i<prices.size() ; i++){
            int curProfit = prices.get(i) - min;
            maxProfit = Math.max(maxProfit,curProfit);
            min = Math.min(min,prices.get(i));
        }

        return maxProfit;
    }
}
