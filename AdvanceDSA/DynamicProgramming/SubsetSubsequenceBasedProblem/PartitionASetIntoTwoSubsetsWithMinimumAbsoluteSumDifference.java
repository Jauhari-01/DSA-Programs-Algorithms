import java.util.* ;
import java.io.*; 

public class PartitionASetIntoTwoSubsetsWithMinimumAbsoluteSumDifference {
    /*
     *  We are given an array ‘ARR’ with N positive integers. 
     *  We need to partition the array into two subsets such that the 
     *  absolute difference of the sum of elements of the subsets is minimum.

        We need to return only the minimum absolute difference 
            of the sum of elements of the two partitions.


        Sample Input 1:
            1
            4
            1 2 3 4
        Sample Output 1:
            0
        Explanation For Sample Input 1:
            We can partition the given array into {2,3} and {1,4}, 
            as this will give us the minimum possible absolute 
            difference i.e (5-5=0) in this case.
            
        Sample Input 2:
            1
            3
            8 6 5
        Sample Output 2:
            3
        Explanation For Sample Input 2:
            We can partition the given array into {8} and 
            {6,5}, as this will give us the minimum possible 
            absolute difference i.e (11-8=3) in this case
    */
}
class Solution {
	public static int minSubsetSumDifference(int[] arr, int n) {
		// Write your code here.
		int sum = 0;

		for(int val : arr){
			sum += val;
		}
		// boolean[][] dp = new boolean[n][sum+1];
		// targetSum(n,sum, arr, dp);

		// //now calculation
		// int min = Integer.MAX_VALUE;

		// for(int i=0;i<=sum;i++){
		// 	if(dp[n-1][i] == true){
		// 		int diff = Math.abs((sum-i) - i);
		// 		min = Math.min(diff,min);
		// 	}
		// }
		boolean[] dp = new boolean[sum+1];
		int min = Integer.MAX_VALUE;
		dp = targetSumOptimize(n,sum, arr, dp);

		for(int i=0 ; i<=sum ; i++){
			if(dp[i] == true){
				int diff = Math.abs((sum-i)-i);
				min = Math.min(min,diff);
			}
		}
		return min;
	}

	//we will use tabulation method of target sum
	static void targetSum(int n,int target,int[] arr,boolean[][] dp){
		//base case Or initilization
		for(int i=0;i<=target;i++) dp[0][i] =false;
		for(int j=0;j<n;j++) dp[j][0] = true;

		for(int i=1;i<n;i++){
			for(int j=1;j<=target;j++){
				if(arr[i]<=j){
					boolean pick = dp[i-1][j-arr[i]];
					boolean notPick = dp[i-1][j];
					dp[i][j] = pick || notPick;
				}else{
					dp[i][j] = dp[i-1][j] ; //not pick
				}
			}
		}
	}

	//the opimal method
	static boolean[] targetSumOptimize(int n,int target,int[] arr,boolean[] dp){
		//base case Or initilization
		for(int i=0;i<=target;i++) dp[i] =false;
		boolean[] temp = new boolean[target+1];
		dp[0] = true;

		for(int i=1;i<n;i++){
			temp[0] = true;
			for(int j=1;j<=target;j++){
				if(arr[i]<=j){
					boolean pick = dp[j-arr[i]];
					boolean notPick = dp[j];
					temp[j] = pick || notPick;
				}else{
					temp[j] = dp[j] ; //not pick
				}
			}

			boolean[] tt = dp;
			dp = temp;
			temp = tt;
		}

		return dp;
	}

}

