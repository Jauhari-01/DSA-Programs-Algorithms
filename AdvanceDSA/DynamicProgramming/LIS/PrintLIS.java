package AdvanceDSA.DynamicProgramming.LIS;

public class PrintLIS {
    /*
     * Printing Longest Increasing Subsequence 
    */
}
class Main
{
	public static void main(String[] args) {
		int[] arr = {5,4,11,1,16,8};
		printLIS(arr);
	}
	
	static void printLIS(int[] arr){
	    int n = arr.length;
	    
	    int[] dp = new int[n];
	    int[] hash = new int[n];
	    int max = 0;
	    int lastInd = -1;
	    
	    for(int i=0 ; i<n ; i++){
	        dp[i] = 1;
	        hash[i] = i;
	        
	        for(int j=0 ; j<i ; j++){
	            if(arr[i] > arr[j] && 1+dp[j] > dp[i]){
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
	    
	    //printing
	    for(int i=0 ; i<ans.length ; i++){
	        System.out.print(ans[i]+" ");
	    }
	}
}

