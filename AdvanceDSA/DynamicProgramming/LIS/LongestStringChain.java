package AdvanceDSA.DynamicProgramming.LIS;
import java.util.* ;
import java.io.*; 
public class LongestStringChain {
    /*
     * 
     * Problem Statement: We are given an array of strings (sat words[ ]), and we need to 
            return the longest string chain. This longest string chain is defined as:

            A subsequence of words[ ] of the string.
            Every element of this subsequence ( a string) except the first one 
                can be formed by inserting a single character into the previous element.
            The first element of this subsequence can be any string from the words[ ] array.

        This problem can be compared with the already discussed problem of , the longest increasing subsequence.

            There we used to compare two elements of the array and consider 
                the previous element of the array if it was smaller than the current element.
            In this problem, we will use the same technique and compare two values 
                of the array and consider the previous element of the array, if it is 
                just one character deletion from the current element.

     * 
    */
}

class Solution {
	private static boolean isPossible(String a,String b){
		if(a.length() != b.length()+1) return false;

		int f = 0;
		int s = 0;

		while(f < a.length()){
			if(b.length()>s && a.charAt(f)==b.charAt(s)){
				f++;
				s++;
			}else{
				f++;
			}
		}

		if(f == a.length() && s == b.length()) return true;

		return false;
	}
	public static int longestStrChain(int n, String[] arr) {
		// Write your code here.
		Arrays.sort(arr, (str1, str2) -> Integer.compare(str1.length(), str2.length()));

		int[] dp = new int[n];

		int max = 0;
		for(int i=0 ; i<n ; i++){
			dp[i] = 1;
			for(int j=0 ; j<i ; j++){
				if(isPossible(arr[i],arr[j])&& 1+dp[j] > dp[i]){
					dp[i]=1+dp[j];
				}
			}

			if(max < dp[i]){
				max = dp[i];
			}
		}

		return max;
	}
}
