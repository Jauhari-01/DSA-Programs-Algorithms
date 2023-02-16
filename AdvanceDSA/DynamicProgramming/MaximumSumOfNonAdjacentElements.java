import java.util.* ;
import java.io.*; 
import java.util.*;

/*
 * Problem statement 1 :
 *      Given an array arr of size N. Return the maximum sum of subsequence 
 *      with the constraint that no two elements are adjacent in the given array arr.


 Problem statement 2 :
        A Robbery
        Robin the thief wants to loot money from a society having n houses in a single line.
        He is a weird person and follows a certain rule when looting the houses.
        According to the rule, he will never loot two consecutive houses.
        At the same time, he wants to maximize the amount he loots.
        The thief knows which house has what amount of money but is 
        unable to come up with an optimal looting strategy.
        He asks for your help to find the maximum money he can get if 
        he strictly follows the rule. Each house has a[i] amount of money present in it.
 * 
 */
public class MaximumSumOfNonAdjacentElements {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int dp[] = new int[nums.size()];
		Arrays.fill(dp,-1);
		int ans = solve(nums,dp,nums.size()-1);

        // int ans = solve2(nums,dp);

        // int ans = solve(nums);

		return ans;
	}


	//Mamoization
	static int solve(ArrayList<Integer> arr,int[] dp,int index){
		if(index == 0) return arr.get(0);
		if(index < 0) return 0;

		if(dp[index] != -1) return dp[index];

		int pick = arr.get(index) + solve(arr,dp,index-2);
		int notpic = 0 + solve(arr,dp,index-1);

		dp[index] = Integer.max(pick,notpic);

		return dp[index];
	}

    //tabulization
	static int solve2(ArrayList<Integer> arr,int[] dp){
		dp[0] = arr.get(0);

		for(int i=1 ; i<arr.size() ; i++){
			int pic = arr.get(i);

			if(i > 1){
				pic += dp[i-2];
			}

			int notpic = 0+dp[i-1];

			dp[i] = Math.max(notpic,pic);
		}

		return dp[arr.size()-1];
	}

    
	//tabulization (optimize)
	static int solve3(ArrayList<Integer> arr){
		int pre1 = arr.get(0);
		int pre2 = 0;

		for(int i=1 ; i<arr.size() ; i++){
			int pic = arr.get(i);

			if(i > 1){
				pic += pre2;
			}

			int notpic = 0+pre1;

			int cur_i = Math.max(notpic,pic);
			pre2 = pre1;
			pre1 = cur_i;
		}

		return pre1;
	}
}