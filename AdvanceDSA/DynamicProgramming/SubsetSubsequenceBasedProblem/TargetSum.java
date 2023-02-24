import java.util.* ;
import java.io.*;

public class TargetSum {
    /*
     * 
     * Problem Description:

        We are given an array ‘ARR’ of size ‘N’ and a number 
        ‘Target’. Our task is to build an expression from the given array 
        where we can place a ‘+’ or ‘-’ sign in front of an integer. 
        We want to place a sign in front of every integer of the array 
        and get our required target. We need to count the number of ways 
        in which we can achieve our required target.

        Input: nums = [1,1,1,1,1], target = 3
        Output: 5
        Explanation: 
            There are 5 ways to assign symbols to make the sum of nums be target 3.
            -1 + 1 + 1 + 1 + 1 = 3
            +1 - 1 + 1 + 1 + 1 = 3
            +1 + 1 - 1 + 1 + 1 = 3
            +1 + 1 + 1 - 1 + 1 = 3
            +1 + 1 + 1 + 1 - 1 = 3
     * 
    */
}

 
 class Solution {
    public static int targetSum(int n, int d, int[] arr) {
    	// Write your code here.
        /*
            s1 - s2 = diff
            s1 + s2 = sum 

            ==> 2s1 = (diff+sum)
                s1 = (diff+sum)/2  ----------->this will work for positive
                                                values of target

            ==> s2 = s1 - diff
                s2 = (diff+sum -2diff)/2
                s2 = (sum - diff)/2 ----------> we will use s2 as target
                                                it will work for both 
                                                positive and negative value
                                                of target

            ==>Also consider the base case for the size 1 array
        */



        //base case
        if(n == 1){
            if(Math.abs(d)-arr[0] ==0) return 1;
            return 0;
        }

        int sum = 0;
        for(int val : arr){
            sum += val;
        }

        if((sum-d)<0 || (sum-d)%2 == 1) return 0;

        return countTargetSubset(arr,(sum-d)/2,n);
    }

    //tabulation
    static int countTargetSubset(int[] arr,int tar,int n){
        int[][] dp = new int[n+1][tar+1];

        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=tar;j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][tar];
    }
}
