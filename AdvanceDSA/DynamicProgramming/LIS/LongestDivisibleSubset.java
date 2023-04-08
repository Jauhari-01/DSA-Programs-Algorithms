package AdvanceDSA.DynamicProgramming.LIS;
import java.util.* ;
import java.io.*; 
public class LongestDivisibleSubset {
    // we will use LIS logic to solve this problem

    /*
     * 
     * You are given an array of distinct elements ,
     * your task is to return the largest subset of numbers from arr,
     * such that any pair of numbers a and b from the subset satisfies the
     * following :
     *  a%b == 0 or b%a ==0
     * 
    */
}


class Solution {
    public static ArrayList<Integer> divisibleSet(int arr[]) {
        // Write your code here..
        Arrays.sort(arr);

        int n = arr.length;
        //now same code as printing LIS
        int temp[] = printLIS(arr);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int val : temp){
            ans.add(val);
        }
        return ans;
    }

    static int[] printLIS(int[] arr){
	    int n = arr.length;
	    
	    int[] dp = new int[n];
	    int[] hash = new int[n];
	    int max = 0;
	    int lastInd = -1;
	    
	    for(int i=0 ; i<n ; i++){
	        dp[i] = 1;
	        hash[i] = i;
	        
	        for(int j=0 ; j<i ; j++){
	            if(arr[i]%arr[j]==0 && 1+dp[j] > dp[i]){
	                dp[i] = dp[j]+1;
	                hash[i] = j;
	            }
	        }
	        
	        if(dp[i] > max){
	            max = dp[i];
	            lastInd = i;
	        }
	    }
	    
	    //now creatins ans array 
	    int[] ans = new int[max];
	    ans[0] = arr[lastInd];
	    int k = 1;
	    while(hash[lastInd] != lastInd){
	        lastInd = hash[lastInd];
	        ans[k++] = arr[lastInd];
	    }
	    
	    //reversing ans array 
	    int s = 0;
	    int e = ans.length-1;
	    
	    while(s<e){
	        int temp = ans[s];
	        ans[s] = ans[e];
	        ans[e] = temp;
	        s++;
	        e--;
	    }
	    
	    return ans;
	}

}
