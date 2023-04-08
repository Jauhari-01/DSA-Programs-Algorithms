package AdvanceDSA.DynamicProgramming.LIS;

import java.util.* ;
import java.io.*;
public class NumberofLongestIncreasingSubsequences {
    
}
 
class Solution {
	public static int findNumberOfLIS(int n, int[] arr) {
		// Write your code here.
		int[] dp = new int[n];
		int[] count = new int[n];

		int max = 0;
		for(int i=0 ; i<n ; i++){
			dp[i] = 1;
			count[i] = 1;
			for(int j=0 ; j<i ; j++){
				if(arr[i]>arr[j] && 1+dp[j]>dp[i]){
					dp[i] = 1+dp[j];
					count[i] = count[j];
				}else if(arr[i]>arr[j] && 1+dp[j] == dp[i]){
					count[i] += count[j];
				}
			}
			if(max <dp[i]){
				max = dp[i];
			}
		}

		int ans = 0;

		for(int i=0 ; i<n ;i++){
			if(dp[i]==max){
				ans += count[i];
			}
		}

		return ans;
	}
}
