package AdvanceDSA.DynamicProgramming.LIS;
import java.util.* ;
import java.io.*; 
public class LongestBitonicSubsequence {
    /*
        A bitonic subsequence is a subsequence of an array in which the elements can be any of these three:

            First, increase till a point and then decrease.
            Goes on increasing (Longest increasing subsequence)
            Goes on decreasing (Longest decreasing subsequence)
    */   
}

class Solution {
    public static int longestBitonicSequence(int[] arr, int n) {
        // Write your code here.

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        //forword LIS
        for(int i=0 ; i<n ; i++){
            dp1[i] = 1;
            for(int j=0 ; j<i ; j++){
                if(arr[i]>arr[j] && 1+dp1[j]> dp1[i]){
                    dp1[i] = dp1[j]+1;
                }
            }
        }
        //backword LIS

        for(int i=n-1 ; i>=0 ; i--){
            dp2[i] = 1;
            for(int j=n-1 ; j>i ; j--){
                if(arr[i]>arr[j] && 1+dp2[j]> dp2[i]){
                    dp2[i] = dp2[j]+1;
                }
            }
        }

        int ans = 0;

        for(int i=0 ; i<n ; i++){
            ans = Math.max(ans,dp1[i]+dp2[i]-1);
        }

        return ans;
    }
}

