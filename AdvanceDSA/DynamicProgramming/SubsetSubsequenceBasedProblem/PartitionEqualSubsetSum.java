import java.io.*;
import java.util.*;

public class PartitionEqualSubsetSum {

    /*
     * 
     * Partition Equal Subset Sum
        You are given an array arr of N positive integers. 
        Your task is to find if we can partition the given array 
        into two subsets such that the sum of elements in both subsets is equal.

        For example, let’s say the given array is [2, 3, 3, 3, 4, 5], 
            then the array can be partitioned as [2, 3, 5], and [3, 3, 4] with equal sum 10.

        Example 1
        Input
            2
            6
            3 1 1 2 2 1
            5
            5 6 5 11 6
        Output
            true
            false
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Solution s = new Solution();
            System.out.println(s.twoEqualSubsets(arr));
        }
        
    }
}

class Solution {
	//optimized method
	static boolean targetSum(int n,int target,int[] arr){
		boolean[] pre = new boolean[target+1];
		boolean[] temp = new boolean[target+1];

		for(int j=0;j<=target;j++) pre[j] = false;
		pre[0] = true;

		for(int i=1;i<n;i++){
			temp[0] = true;
			for(int j=1;j<=target;j++){
				//
				if(arr[i] <= j){
					//we have two choices
					boolean pick = pre[j-arr[i]];
					boolean notPic = pre[j];
					temp[j] = pick||notPic;
				}else{
					temp[j] = pre[j]; //not pic only
				}
			}

			boolean[] tt = pre;
			pre = temp;
			temp = tt;
		}

		return pre[target];
	}
	static boolean subsetSum(int[] arr,boolean[][] dp){
		//initilization
		for(int i=0; i<dp.length;i++){
			for(int j=0 ; j<dp[0].length ; j++){
				if(i == 0){
					dp[i][j] = false;
				}
				if(j==0){
					dp[i][j] = true;
				}
			}
		}

		for(int i=1 ; i<dp.length ; i++){
			for(int j=1; j<dp[0].length ; j++){
				if(arr[i-1] <= j){
					dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[dp.length-1][dp[0].length-1];
	}
    static String twoEqualSubsets(int[] arr) {
		int sum = 0;
		for(int val : arr){
			sum += val;
		}

		if(sum%2==1){
			return "false";
		}
		int tar = sum/2;
		boolean[][] dp = new boolean[arr.length+1][tar+1];

		if(subsetSum(arr,dp)){
			return "true";
		}

		return "false";
    }
}