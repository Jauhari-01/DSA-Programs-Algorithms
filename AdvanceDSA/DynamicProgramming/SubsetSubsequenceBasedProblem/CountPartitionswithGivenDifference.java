import java.util.* ;
import java.io.*; 

public class CountPartitionswithGivenDifference {
    /*
     * Problem Description:

        We are given an array ‘ARR’ with N positive 
            integers and an integer D. We need to count the number of ways 
            we can partition the given array into two subsets, S1 and S2 such 
            that S1 – S2 = D and S1 is always greater than or equal to S2.
    */
}
class Solution {
	static int mod = 1000000007;
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		/*
			s1 - s2 = d
			s1 + s2 = sum

			2s1 = sum+d

			s1 = (sum+d)/2

			now we need to count the subset having sum s1 

			since 1 set is having s1 means other will have s2 
		
		*/


		int sum = 0;
		for(int val : arr) sum += val;

		if((sum+d)%2 == 1) return 0;

		return countSubSet(n,(sum+d)/2,arr);
	}

	static int countSubSet(int n,int tar,int[] arr){
		int[][] dp = new int[n+1][tar+1];

		//base case
		for(int i=0;i<=n;i++) dp[i][0] = 1;

		for(int i=1;i<=n ; i++){
			for(int j=0;j<=tar;j++){
				if(arr[i-1] <= j){
					dp[i][j] = (dp[i-1][j-arr[i-1]] + dp[i-1][j])%mod; // pick + notPick
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[n][tar];
	}
}