package GridOrMatrixBasedProblem;
import java.util.* ;
import java.io.*; 
public class MaximumPathSuminthematrix {
    /*
     * 
     * Minimum/Maximum falling path sum.

        Problem Link: Variable Starting and Ending Point

        Problem Description: 
            We are given an ‘N*M’ matrix. 
            We need to find the maximum path sum from any cell of the first row to any cell of the last row.
            At every cell we can move in three directions: to the bottom cell (↓), 
            to the bottom-right cell(↘), or to the bottom-left cell(↙).

        Input 1 :
            2
            4 4
            1 2 10 4
            100 3 2 1
            1 1 20 2
            1 2 2 1
            3 3
            10 2 3
            3 7 2
            8 1 5
        Output 1 :
            105
            25
    */
}
class Solution {
	public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
		//int max
		int n = matrix.length;
		int m = matrix[0].length;

		// int[][] dp = new int[n][m];
		// for(int[] row : dp){
		// 	Arrays.fill(row,-1);
		// }

		// int max = Integer.MIN_VALUE;
		// for(int i=0 ; i<matrix[0].length;i++){
		// 	max = Math.max(max,memo(matrix.length-1, i, matrix,dp));
		// }

		// return max;

		//for tabulation
		// return tab(n, m, matrix);
		return tabOptimization(n,m,matrix);
	}

	//recursion for this problem
	static int recursion(int i,int j,int[][] arr){
		//base case as j can be out of bount
		if(j < 0 || j >= arr[0].length) return (int)-1e9; //not int min because of overflow
		if(i == 0) return arr[0][j];

		//calculation for three direction
		int up = arr[i][j] + recursion(i-1, j, arr);
		int leftDig = arr[i][j] + recursion(i-1, j-1, arr);
		int rightDig = arr[i][j] + recursion(i-1, j+1, arr);

		return Math.max(up,Math.max(leftDig,rightDig));
	}

	//memoization
	static int memo(int i,int j,int[][] arr,int[][] dp){
		//base case as j can be out of bount
		if(j < 0 || j >= arr[0].length) return (int)-1e9; //not int min because of overflow
		if(i == 0) return arr[0][j];

		if(dp[i][j] != -1) return dp[i][j];

		//calculation for three direction
		int up = arr[i][j] + memo(i-1, j, arr,dp);
		int leftDig = arr[i][j] + memo(i-1, j-1, arr,dp);
		int rightDig = arr[i][j] + memo(i-1, j+1, arr,dp);

		return dp[i][j] = Math.max(up,Math.max(leftDig,rightDig));
	}

	//tabulation
	static int tab(int n,int m,int[][] arr){
		//base case as j can be out of bount
		int[][] dp = new int[n][m];

		//base case or initilization
		for(int j=0; j<m ;j++){
			dp[0][j] = arr[0][j];
		}

		for(int i=1 ; i<n; i++){
			for(int j=0 ; j<m ; j++){
				int up = arr[i][j] + dp[i-1][j];

				int ld = (j>0)?arr[i][j]+dp[i-1][j-1]:(int)-1e9;
				int rd = (j<m-1)?arr[i][j] + dp[i-1][j+1] : (int)-1e9;

				dp[i][j] = Math.max(up,Math.max(ld,rd));
			}
		}

		//calculaton for ans
		int max = Integer.MIN_VALUE;
		for(int j=0 ; j<m ; j++){
			max = Math.max(max,dp[n-1][j]);
		}

		return max;
	}
	
	//space optimization
	//code is correct but failing for the negative values
	static int tabOptimization(int n,int m,int[][] arr){
		//base case as j can be out of bount
		int[] pre = new int[m];
		int[] temp = new int[m];

		//base case or initilization
		for(int j=0; j<m ;j++){
			pre[j] = arr[0][j];
		}

		for(int i=1 ; i<n; i++){
			for(int j=m-1 ; j>=0 ; j--){
				int up = arr[i][j] + pre[j];

				// int ld = (j>0)?arr[i][j]+pre[j-1]:(int)-1e8;
				// int rd = (j<m-1)?arr[i][j] + pre[j+1] : (int)-1e8;
				int leftDiagonal= arr[i][j];
				if(j-1>=0) leftDiagonal += pre[j-1];
				else leftDiagonal += -1e9;
		
				int rightDiagonal = arr[i][j];
				if(j+1<m) rightDiagonal += pre[j+1];
				else rightDiagonal += -1e9;

				temp[j] = Math.max(up,Math.max(leftDiagonal,rightDiagonal));
			}

			pre = temp;
		}

		//calculaton for ans
		int max = Integer.MIN_VALUE;
		for(int j=0 ; j<m ; j++){
			max = Math.max(max,pre[j]);
		}

		return max;
	}
}
