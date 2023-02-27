public class UnboundedKnapsack {
    /*
     * Unbounded Knapsack (DP-23)
        Problem Link: Unbounded Knapsack

            A thief wants to rob a store. He is carrying a bag of 
            capacity W. The store has ‘n’ items of infinite supply. 
            Its weight is given by the ‘wt’ array and its value by the ‘val’ 
            array. He can either include an item in its knapsack or exclude it 
            but can’t partially have it as a fraction. We need to find the maximum 
            value of items that the thief can steal. He can take a single item any 
            number of times he wants and put it in his knapsack.

        Sample Input 1
            2
            3 15
            7 2 4
            5 10 20
            2 3
            6 12
            4 17
        Sample Output 1
            21
            0

    */
} 
class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        // return recursion(n-1, w, profit, weight);
        // int[][] dp = new int[n][w+1];
        // for(int[] row : dp) Arrays.fill(row,-1);

        // return memo(dp, n-1, w, profit, weight);

        // return tab(n, w, profit, weight);
        return tabOpt(n, w, profit, weight);
    }

    static int recursion(int ind,int w,int[] val,int[] wt){

        if(ind == 0){
            // return ((int)(w/wt[0])) * val[0];
            if(w>=wt[0]) return (int)(w/wt[0])*val[0];
            return 0;
        }

        int notPick = 0 + recursion(ind-1, w, val, wt);
        int pick = Integer.MIN_VALUE;
        if(wt[ind] <= w)
            pick = val[ind] + recursion(ind, w-wt[ind], val, wt);

        return Math.max(pick,notPick);
    }

    static int memo(int[][] dp,int ind,int w,int[] val,int[] wt){

        if(ind == 0){
            // return ((int)(w/wt[0])) * val[0];
            if(w>=wt[0]) return (int)(w/wt[0])*val[0];
            return 0;
        }
        if(dp[ind][w] != -1) return dp[ind][w];
        int notPick = 0 + memo(dp,ind-1, w, val, wt);
        int pick = Integer.MIN_VALUE;
        if(wt[ind] <= w)
            pick = val[ind] + memo(dp,ind, w-wt[ind], val, wt);

        return dp[ind][w]= Math.max(pick,notPick);
    }

    static int tab(int n,int w,int[] val,int[] wt){
        int[][] dp = new int[n+1][w+1];
        //0th row and 0th coloum will be 0

        //------I can remove this condition from here and
        //------start loop from 1------------------------
        // for 1st row
        for(int j=wt[0];j<=w;j++){
            if(wt[0]<=j) 
                dp[1][j] = (int)(j/wt[0])*val[0];
            else dp[1][j] = 0;
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<=w;j++){
                int notPick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(wt[i-1] <= j)
                    pick = val[i-1] + dp[i][j-wt[i-1]];

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n][w];
    }

    static int tabOpt(int n,int w,int[] val,int[] wt){
        int[] pre = new int[w+1];
        int[] temp = new int[w+1];
        //------I can remove this condition from here and
        //------start loop from 1------------------------
        //0th row and 0th coloum will be 0
        // for 1st row
        for(int j=wt[0];j<=w;j++){
            if(wt[0]<=j) 
                pre[j] = (int)(j/wt[0])*val[0];
            else pre[j] = 0;
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<=w;j++){
                int notPick = pre[j];
                int pick = Integer.MIN_VALUE;
                if(wt[i-1] <= j)
                    pick = val[i-1] + temp[j-wt[i-1]];

                temp[j] = Math.max(pick, notPick);
            }

            int[] tt = pre;
            pre = temp;
            temp = tt;
        }

        return pre[w];
    }
}

