import java.util.*;
public class CoinChange2 {
    /*
     * Coin Change 2 (DP – 22)
        Problem Link: Ways to Make a Coin Change

        We are given an array Arr with N distinct coins and a 
        target. We have an infinite supply of each coin denomination. 
        We need to find the number of ways we sum up the 
        coin values to give us the target.

        Sample Input 1 :
            3
            1 2 3
            4
        Sample Output 1:
            4
    */
}

class Solution {

	public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here			
		int n = denominations.length;
		// return recursion(denominations, n-1, value);
		// long[][] dp = new long[n][value+1];
		// for(long[] row : dp) Arrays.fill(row,-1L);
		// return memo(denominations, n-1, value,dp);
		return tab(denominations, n, value);
		// return tabOpt(denominations,n,value);
	}

	static long recursion(int[] arr,int ind,int tar){
		if(ind == 0){
			if(tar%arr[0] == 0) return 1;
			return 0;
		}

		long notPick =  recursion(arr, ind-1, tar);
		long pick = 0L;
		if(arr[ind] <= tar)
			pick = recursion(arr, ind, tar-arr[ind]);

		return pick+notPick;

	}
	
	static long memo(int[] arr,int ind,int tar,long[][]dp){
		if(ind == 0){
			if(tar%arr[0] == 0) return 1;
			return 0;
		}
		if(dp[ind][tar] != -1) return dp[ind][tar];
		long notPick =  memo(arr, ind-1, tar,dp);
		long pick = 0L;
		if(arr[ind] <= tar)
			pick = memo(arr, ind, tar-arr[ind],dp);

		return dp[ind][tar] = pick+notPick;

	}
	static long tab(int[] arr,int n,int tar){
	
		int T = tar;
		long dp[][]=new long[n+1][T+1];
		
		
		//Initializing base condition
		for(int i=0;i<=T;i++){
			if(i%arr[0]==0)
				dp[1][i]=1;
			// Else condition is automatically fulfilled,
			// as dp array is initialized to zero
		}
		for(int i=0;i<=n;i++) dp[i][0] = 1;
		
		for(int ind=2; ind<=n;ind++){
			for(int target=0;target<=T;target++){
				long notTaken = dp[ind-1][target];
				
				long taken = 0;
				if(arr[ind-1]<=target)
					taken = dp[ind][target-arr[ind-1]];
					
				dp[ind][target] = notTaken + taken;
			}
		}
		
		return dp[n][T];
	}
	static long tabOpt(int[] arr,int n,int T){
	
		long[] prev=new long[T+1];
		long cur[]=new long[T+1];
    
    	//Initializing base condition
		//1th row initilization
		for(int i=0;i<=T;i++){
			if(i%arr[0]==0)
				prev[i]=1;
			// Else condition is automatically fulfilled,
			// as prev array is initialized to zero
		}
		
		for(int ind=2; ind<=n;ind++){
			// cur[0] = 1;
			for(int target=0;target<=T;target++){
				long notTaken = prev[target];
				
				long taken = 0;
				if(arr[ind-1]<=target)
					taken = cur[target-arr[ind-1]];
					
				cur[target] = notTaken + taken;
			}
			long[] tt = prev;
			prev = cur;
			cur = tt;
		}
    
    	return prev[T];

	}
}