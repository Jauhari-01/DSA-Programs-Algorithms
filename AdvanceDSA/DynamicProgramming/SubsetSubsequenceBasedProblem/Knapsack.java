// ==> 0/1 Knapsack

import java.util.* ;
import java.io.*; 

public class Knapsack{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            /* A thief wants to rob a store. He is carrying a 
                    bag of capacity W. The store has ‘n’ items. Its weight is given 
                    by the ‘wt’ array and its value by the ‘val’ array. He can 
                    either include an item in its knapsack or exclude it but can’t 
                    partially have it as a fraction. We need to find the maximum value 
                    of items that the thief can steal.

                Why a Greedy Solution doesn’t work?

                The first approach that comes to our mind is greedy. 
                    A greedy solution will fail in this problem because there is no 
                    ‘uniformity’ in data. While selecting a local better choice we may 
                    choose an item that will in long term give less value.

                Sample Input:
                    1 
                    4
                    1 2 4 5
                    5 4 8 6
                    5
                Sample Output:
                    13
            */
        // return recursion(weight, value, n-1, maxWeight);
        // int[][] dp = new int[n][maxWeight+1];
        // for(int[] row : dp) Arrays.fill(row,-1);

        // return memo(weight, value, n-1, maxWeight, dp);

        // return tab(weight,value,n,maxWeight);
        return tabOpt(weight,value,n,maxWeight);
    }

    static int recursion(int[] wt,int[] val,int ind,int w){

        //base case
        if(ind == 0){
            if(wt[0] <= w) return val[0];
            return 0;
        }

        int pick =val[ind] + recursion(wt, val, ind-1, w - wt[ind]);
        int notPick = recursion(wt, val, ind-1, w);

        return Math.max(pick,notPick);
    }
    
    static int memo(int[] wt,int[] val,int ind,int w,int[][] dp){

        //base case
        if(ind == 0){
            if(wt[0] <= w) return val[0];
            return 0;
        }
        if(dp[ind][w] != -1) return dp[ind][w];
        int pick = Integer.MIN_VALUE;
        if(wt[ind] <= w)
            pick =val[ind] + memo(wt, val, ind-1, w - wt[ind],dp);
        int notPick = memo(wt, val, ind-1, w,dp);

        return dp[ind][w] = Math.max(pick,notPick);
    }

    static int tab(int[] wt,int[] val,int n,int w){
        int[][] dp = new int[n+1][w+1];
        //base case
        for(int j=0;j<=w;j++) dp[0][j] = 0;
        for(int i=0;i<=n;i++) dp[i][0] = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][w];
    }

    static int tabOpt(int[] wt,int[] val,int n,int w){
        int[] pre = new int[w+1];
        int[] temp = new int[w+1];
        //base case
        for(int j=0;j<=w;j++) pre[j] = 0;
        // for(int i=0;i<=n;i++) dp[i][0] = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(wt[i-1] <= j){
                    temp[j] = Math.max(pre[j],val[i-1]+pre[j-wt[i-1]]);
                }else{
                    temp[j] = pre[j];
                }
            }
            int[] tt = pre;
            pre = temp;
            temp = tt;
        }

        return pre[w];
    
    }
}