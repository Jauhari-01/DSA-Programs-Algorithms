import java.util.* ;
import java.io.*; 

/*
    --> Special program in initilization of tabulation dp
        have a look
*/
/*
 * Problem Statement:  Minimum Coins

    Problem Link: Minimum Coins
        We are given a target sum of ‘X’ and ‘N’ distinct numbers denoting the coin denominations. 
        We need to tell the minimum number of coins required to reach the target sum. 
        We can pick a coin denomination for any number of times we want.

        Sample Input 1 :
            2
            3 7
            1 2 3
            1 0
            1
        Sample Output 1 :
            3
            0
*/
public class MinimumCoins {

    // (int)1e9 === (int)Math.pow(10,9)
    public static int minimumElements(int num[], int x) {
        // Write your code here..

        // return recursion(num.length-1, x, num);
        int n= num.length;
        int[][] dp = new int[n][x+1];
        for(int[] row : dp) Arrays.fill(row,-1);

        // return memo(n-1, x, num, dp);
        // return minimumElementsUtil(num,n-1,x,dp);
        // int ans =   memo(n-1, x, num, dp);
        // if(ans >= (int)Math.pow(10,9)) return -1;
        // return ans;
        return tab(num, x, n);
        // return tabOpt(num, x, n);
}

    static int recursion(int ind,int tar,int[] arr){

        //base case
        if(ind == 0){
            if(tar%arr[0] == 0) return tar/arr[0];
            return (int)1e9;
        }

        int notPick = 0 + recursion(ind-1, tar, arr);
        int pick = (int)1e9;
        if(arr[ind] <= tar)
            pick = 1 + recursion(ind, tar - arr[ind], arr);

        return Math.min(pick,notPick);
    }
    static int memo(int ind,int tar,int[] arr,int[][] dp){

        //base case
        if(ind == 0){
            if(tar%arr[0] == 0) return tar/arr[0];
            return (int)1e9;
        }
        if(dp[ind][tar] != -1) return dp[ind][tar];
        int notPick = 0 + memo(ind-1, tar, arr,dp);
        int pick = (int)1e9;
        if(arr[ind] <= tar)
            pick = 1 + memo(ind, tar - arr[ind], arr,dp);

         return dp[ind][tar] = Math.min(pick,notPick);
    }

    static int tab(int[] arr,int tar,int n){
        int[][] dp = new int[n+1][tar+1];

        for(int i=0;i<=n;i++) dp[i][0] = 0; // this condition is for 0th colom
                                            // which is telling that ith coin used to
                                            // get 0 as target

        for(int j=1;j<=tar;j++) dp[0][j] = (int)1e9; // this is condition for 0th row
                                                     // if bag is empty and we are having
                                                     // j as target we need infinite number
                                                     // of coins for getting the target

        //special case as 1st row initilization
        for(int j=0;j<=tar;j++){
            if(j%arr[0] == 0) dp[1][j] = j/arr[0]; // accoding to dp recursion
            else dp[1][j] = (int)1e9;
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<=tar;j++){
                int notPick =0+ dp[i-1][j];
                int pick = (int)1e9;
                if(arr[i-1] <= j)
                    pick = 1 + dp[i][j-arr[i-1]];

                dp[i][j] = Math.min(pick,notPick);
            }
        } 

        int ans = dp[n][tar];
        if(ans >=(int)Math.pow(10,9)) return -1;
        return ans;
    }

    static int tabOpt(int[] arr,int tar,int n){
        int[]pre = new int[tar+1];
        int[]temp = new int[tar+1];

        // for(int i=0;i<=n;i++) dp[i][0] = 0; // this condition is for 0th colom
                                            // which is telling that ith coin used to
                                            // get 0 as target

        // for(int j=1;j<=tar;j++) pre[j] = (int)1e9; // this is condition for 0th row
                                                     // if bag is empty and we are having
                                                     // j as target we need infinite number
                                                     // of coins for getting the target

        //special case as 1st row initilization
        for(int j=0;j<=tar;j++){
            if(j%arr[0] == 0) pre[j] = j/arr[0]; // accoding to dp recursion
            else pre[j] = (int)1e9;
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<=tar;j++){
                int notPick =0+ pre[j];
                int pick = (int)1e9;
                if(arr[i-1] <= j)
                    pick = 1 + temp[j-arr[i-1]];

                temp[j] = Math.min(pick,notPick);
            }
            int[] tt = pre;
            pre = temp;
            temp = tt;
            // pre = temp;
        } 

        int ans = pre[tar];
        if(ans >=(int)1e9) return -1;
        return ans;
    }
}