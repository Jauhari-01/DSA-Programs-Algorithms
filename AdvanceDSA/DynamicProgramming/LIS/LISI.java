package AdvanceDSA.DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
public class LISI{
    public static void main(String[] args) {
        /*
         * Longest Increasing Subsequence | (DP-41)
                In the coming articles, we will discuss problems related to ‘Longest Increasing Subsequence’. 
                Before proceeding further, let us understand the “Longest Increasing Subsequence”, or rather what is a “subsequence”?

                A subsequence of an array is a list of elements of the array where some elements are deleted 
                ( or not deleted at all) and they should be in the same order in
                 the subsequence as in the original array.

                For example, for the array: [2,3,1] , the subsequences 
                will be [{2},{3},{1},{2,3},{2,1},{3,1},{2,3,1}} but {3,2} is not a 
                subsequence because its elements are not in the same order as the original array.

                What is the Longest Increasing Subsequence?
                        The longest increasing subsequence is described as a subsequence of an array where:

                All elements of the subsequence are in increasing order.
                This subsequence itself is of the longest length possible.


            Approach 1: Using Brute Force

                We are given an array arr[]. To find the longest increasing subsequence, 
                    the brute force method that comes to our mind is to generate all 
                    subsequences and then manually filter the subsequences whose elements 
                    come in increasing order and then return the longest such subsequence. 
                This naive approach will give us the correct answer but to generate all the subsequences, 
                we will require exponential ( 2n ) time. Therefore we will try some other approaches.

            Approach 2: Using Dynamic Programming

                We would want to try something that can give us the longest increasing subsequence on 
                    the way of generating all subsequences. To generate all subsequences we will use 
                    recursion and in the recursive logic we will figure out a way to solve this problem.

        */
    }
}

class TUF{

    // this is recursion + dp approach // will not work give TLE
    static int getAns(int arr[], int n,  int ind, int prev_index,int[][] dp){
        
        // base condition
        if(ind == n)
            return 0;
            
        if(dp[ind][prev_index+1]!=-1)
            return dp[ind][prev_index+1];
        
        int notTake = 0 + getAns(arr,n,ind+1,prev_index,dp);
        
        int take = 0;
        
        if(prev_index == -1 || arr[ind] > arr[prev_index]){
            take = 1 + getAns(arr,n,ind+1,ind,dp);
        }
        
        return dp[ind][prev_index+1] = Math.max(notTake,take);
    }
    
    static int longestIncreasingSubsequence(int arr[], int n){
        
        int dp[][]=new int[n][n+1];
        for(int row[]: dp)
        Arrays.fill(row,-1);
        
        return getAns(arr,n,0,-1,dp);
    }
    
    public static void main(String args[]) {
        
        int arr[] = {10,9,2,5,3,7,101,18};
        
        int n = arr.length;
        
        System.out.println("The length of the longest increasing subsequence is "+longestIncreasingSubsequence(arr,n));
        
    }
    }


class Solution {

    //Tabulation + Binary Search will work 
    //
        //also there is tablutaion using 2d dp will also not work
        //TC --> O(n*n)
        //SC --> O(n)
        public static int longestIncreasingSubsequence(int arr[]) {
            //Your code goes here
            return lisBinarySearch(arr);
        }
    
        //TC --> O(n^2)  SC --> O(n)

        //most used method 
        //this approach will help in solving other problems
        static int lis(int[] arr){
            int n = arr.length;
            int[] dp = new int[n];
    
            int max = 0;
            for(int i=0 ; i<n ; i++){
                dp[i] = 1;
                for(int j=0 ; j<i ; j++){
                    if(arr[i]>arr[j] && 1+dp[j]>dp[i]){
                        dp[i] = 1+dp[j];
                    }
                }
                if(max <dp[i]){
                    max = dp[i];
                }
            }
    
            return max;
        }
    

        //TC --> O(nlogn)
        //SC --> O(n)
        //we will use binaray search for solving this problem
        static int lisBinarySearch(int[] arr){
            int n = arr.length;
            ArrayList<Integer> temp = new ArrayList<>();
    
            temp.add(arr[0]);
    
            int k = 0;
            for(int i=1 ; i<n ; i++){
                if(arr[i] > temp.get(k)){
                    temp.add(arr[i]);
                    k++;
                }else{
                    //find the place where we can put
                    //our element 
                    int ind = lowerBound(temp,k,arr[i]);
    
                    temp.set(ind,arr[i]);
                }
            }
    
            return temp.size();
        }
    
        static int lowerBound(ArrayList<Integer> temp,int k,int key){
            int start = 0;
            int end = k;
    
            int ans = 0;
            while(start <= end){
                int mid = start + (end-start)/2;
    
                if(temp.get(mid) == key){
                    return mid;
                }else if(temp.get(mid) < key){
                    // ans = mid;
                    start = mid+1;
                }else{
                    ans = mid;
                    end = mid-1;
                }
            }
    
            return ans;
        }
    
    
    }