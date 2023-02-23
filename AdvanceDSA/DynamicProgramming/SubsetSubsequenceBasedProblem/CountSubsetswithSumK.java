import java.util.* ;
import java.io.*; 

public class CountSubsetswithSumK {
    /*
     *      Given an array arr[] of non-negative integers and an integer sum, 
     *          the task is to count all subsets of the given array with a 
     *          sum equal to a given sum.

            Note: Answer can be very large, so, output answer modulo 109+7 (In GFG)
    */
}
class Solution {

    //------------------------------------------------------------------------
    //worked on gfg dp[n][tar+1]
    //          code studio dp[n+1][tar+1] only
    int mod = 1000000007;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    
	    return solve(n,sum,arr);
	} 
	
	int solve(int n,int tar,int[] arr){
	    int[] pre = new int[tar+1];
	    int[] temp = new int[tar+1];
	    
	    for(int j=0;j<=tar;j++) pre[j] = 0;
	    pre[0] = 1;
	    
	    for(int i=0 ; i<n;i++){
	        temp[0] = 1;
	        for(int j=0;j<=tar;j++){
	            int pick = 0;
	            if(arr[i]<=j){
	                temp[j] = (pre[j] + pre[j-arr[i]])%mod;
	            }else{
	                temp[j] = pre[j];
	            }
	        }
	        
	        int[] tt=pre;
	        pre = temp;
	        temp = tt;
	    }
	    
	    return pre[tar];
	}

    //--------------------------------------------------------------------------

    public static int findWays(int num[], int tar) {
        // Write your code here..
        // return recursion(num.length-1, tar, num);
        int n = num.length;
        // int dp[][]=new int[n][tar+1];
        // for(int row[]: dp)
        //     Arrays.fill(row,-1);

        // return memo(n-1, tar, num, dp);

        // return tab(n, tar, num);
        return tabop(n, tar, num);
        
    }

    static int recursion(int ind,int tar,int[] arr){
        //base case 
        if(tar == 0) return 1;
        if(ind == 0) return (arr[0] == tar) ? 1 : 0;

        //pick and not pic
        int pick = 0;
        if(arr[ind] <= tar)
            pick = recursion(ind-1, tar-arr[ind], arr);
        int notPick = recursion(ind-1, tar, arr);

        return pick+notPick;
    }

    //memoization
    static int memo(int ind,int tar,int[] arr,int[][] dp){
        //base case 
        if(tar < 0) return 0;
        if(tar == 0) return 1;
        if(ind == 0) return (arr[0] == tar) ? 1 : 0;
        if(dp[ind][tar] != -1) return dp[ind][tar];
        //pick and not pic
        int pick = 0;
        if(arr[ind] <= tar)
            pick = memo(ind-1, tar-arr[ind], arr,dp);
        int notPick = memo(ind-1, tar, arr,dp);

        return dp[ind][tar] = pick+notPick;
    }

    //tabulation
    static int tab(int n,int tar,int[] arr){
        int[][] dp = new int[n+1][tar+1];
        //base case 
        //first colom will always be possible for any size of array tar == 0 
        // for(int j=0;j<=tar ; j++) dp[0][j] = 0;
        for(int i=0;i<n;i++) dp[i][0] = 1;

        for(int i=1 ; i<=n;i++){
            for(int j=0 ; j<= tar;j++){
                if(arr[i-1] <= j){
                    int pick = dp[i-1][j-arr[i-1]];
                    int notPick = dp[i-1][j];
                    dp[i][j] = pick + notPick;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][tar];
    
    }

    static int tabop(int n,int tar,int[] arr){
        int[] pre = new int[tar+1];
        int[] temp = new int[tar+1];
        //base case 
        //first colom will always be possible for any size of array tar == 0 
        for(int j=0;j<=tar ; j++) pre[j] = 0;
        pre[0] = 1;
        // for(int i=0;i<n;i++) dp[i][0] = 1;

        for(int i=1 ; i<=n;i++){
            temp[0] = 1;
            for(int j=0 ; j<= tar;j++){
                if(arr[i-1] <= j){
                    int pick = pre[j-arr[i-1]];
                    int notPick = pre[j];
                    temp[j] = pick + notPick;
                }else{
                    temp[j] = pre[j];
                }
            }
            int[] tt = pre;
            pre = temp;
            temp = tt;
        }
        return pre[tar];
    
    }
}
