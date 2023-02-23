import java.util.*;
import java.io.*;
public class SubsetSumProblem {
    /*
     * 
     * Subset Sum Problem
        Given an array of integers and a sum, determine if there is a subset of 
        the array such that the sum of elements in 
        the subset is equal to the given sum.

        Input
            5 12
            1 2 3 7 5
        Output
            YES
    */
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int sum = Integer.parseInt(line[1]);
        int[] arr = new int[n];
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        Solution sol = new Solution();
        Boolean ans = sol.subsetSum(arr, n, sum);
        if(ans) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}



class Solution2 {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        // return recurion(n-1, k, arr);
        // Boolean[][] dp = new Boolean[n][k+1];

        // return memo(n-1, k, arr, dp);
        // return tab(n,k,arr,dp);

        return tabOpt(n,k, arr);
    }

    //recurion
    static boolean recurion(int ind,int target,int[] arr){
        //base case 
        if(target < 0) return false;
        if(target == 0) return true;
        if(ind == 0) return arr[0] == target;


        //now for every index we have two options
        boolean pick = recurion(ind-1, target-arr[ind], arr);
        boolean notPick = recurion(ind-1, target, arr);

        return pick || notPick;
    }

    //memoization
    static boolean memo(int ind,int target,int[] arr,Boolean[][] dp){
        //base case 
        if(target < 0) return false;
        if(target == 0) return true;
        if(ind == 0) return arr[0] == target;

        if(dp[ind][target]!=null) return dp[ind][target];


        //now for every index we have two options
        boolean pick = memo(ind-1, target-arr[ind], arr,dp);
        boolean notPick = memo(ind-1, target, arr,dp);

        return dp[ind][target] = pick || notPick;
    }

    
    //tabulation
    static boolean tab(int n,int target,int[] arr,Boolean[][] dp){
       
        //initialization
        for(int j = 0; j<=target ; j++){
            dp[0][j] = false;
        }
        for(int i=0 ; i<n  ; i++){
            dp[i][0] = true; //this will handle base case dp[0][arr[target]] = true
        }
        if(arr[0]<= target)
            dp[0][arr[0]] = true;
        for(int i=1 ; i<n ; i++){
            for(int j=1 ; j<=target ; j++){
                boolean pick = false;
                if(j-arr[i] >= 0)
                    pick = dp[i-1][j-arr[i]];
                boolean notPick = dp[i-1][j];

                dp[i][j]= pick||notPick;
            }
        }


        //now for every index we have two options
        

        return dp[n-1][target];
    }

    static boolean tabOpt(int n,int target,int[] arr){

        boolean[] pre = new boolean[target+1];
        boolean[] temp = new boolean[target+1];       
        //initialization
        for(int j = 0; j<=target ; j++){
            pre[j] = false;
        }
        pre[0] = true;
        if(arr[0]<= target)
            pre[arr[0]] = true;
        for(int i=1 ; i<n ; i++){
            temp[0] = true;
            for(int j=1 ; j<=target ; j++){
                boolean pick = false;
                if(j-arr[i] >= 0)
                    pick = pre[j-arr[i]];
                boolean notPick = pre[j];

                temp[j]= pick||notPick;
            }

            boolean[] tt = pre;
            pre = temp;
            temp = tt;
        }


        //now for every index we have two options
        

        return pre[target];
    }

}
//old logic
class Solution {
    public boolean subsetSum(int[] arr, int n, int sum) {
		Boolean[][]dp = new Boolean[n+1][sum+1];

		// return memo(arr,dp,0,sum);
		return tab(arr,dp,sum);
    }
	static boolean tab(int[] arr,Boolean[][] dp,int tar){
		//initilization
		for(int i=0 ; i<dp.length ; i++){
			for(int j=0 ; j<dp[0].length ; j++){
				if(i==0){
					dp[i][j] = false;
				}
				if(j==0){
					dp[i][j] = true;
				}
			}
		}
		
		//now other part
		int n = arr.length;
		int sum = tar; // we already used sum in dp size here it will have no use
		for(int i=1 ; i<=n ; i++){
           for(int j=1 ; j<=sum ; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = (dp[i-1][j-arr[i-1]] || dp[i-1][j]) ;
                }
                else{
                    dp[i][j] = dp[i-1][j] ;   
                }
           }
       }
       return dp[n-1][sum-1] ;
	}
	static boolean memo(int[] arr,Boolean[][] dp,int ind,int tar){
		if(tar == 0){
			return true;
		}

		if(ind == arr.length){
			return false;
		}

		if(dp[ind][tar] != null){
			return dp[ind][tar];
		}

		if(tar >= arr[ind]){
			boolean pick = memo(arr,dp,ind+1,tar-arr[ind]);
			boolean notPic = memo(arr,dp,ind+1,tar);
			return dp[ind][tar] = pick || notPic;
		}else{
			return dp[ind][tar] = memo(arr,dp,ind+1,tar);
		}
		
	}
}
