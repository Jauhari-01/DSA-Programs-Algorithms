package GridOrMatrixBasedProblem;
import java.util.* ;
import java.io.*; 
public class GridUniquePaths {
    /*
        ---> You are given two integers m and n, representing the dimensions 
                of a matrix. Your task is to start from the upper left position, 
                i.e. (0, 0) and end up at the bottom right cell, i.e. (m - 1, n - 1) 
                with the condition that you can only travel either downwards or rightwards, 
                i.e. from (r, c) you can go to either (r + 1, c) or (r, c + 1).

                Find the total number of unique paths from the source to the destination.




     * Given two values M and N, which represent a matrix[M][N]. 
     * We need to find the total unique paths from the top-left 
     * cell (matrix[0][0]) to the rightmost cell (matrix[M-1][N-1]).

        At any cell we are allowed to move in only two directions:- bottom and right.


        Input

            2 <-- test case
            2 2
            1 1
        Output

            2
            1
    */

	public static int uniquePaths(int m, int n) {
		// Write your code here.
		//for recursion
		// return recursion(m-1, n-1);

		//for memo
		// int[][] dp = new int[m][n];
		// for (int[] row : dp)
        // 	Arrays.fill(row, -1);
		// return memo(dp, m-1, n-1);

		//for tab
		// return tab(m, n);

		return optimizeTab(m, n);
	} 

	static int recursion(int i,int j){
		if(i==0&&j==0) return 1; // we got 1 path
		if(i<0 || j<0) return 0 ; //path not possibtle

		//for up call
		int up = recursion(i-1, j);
		int left = recursion(i, j-1);

		return up+left;
	}
	static int memo(int[][] dp , int i,int j){
		if(i==0 && j==0) return 1; // we got 1 path
		if(i<0 || j<0) return 0 ; //path not possibtle

		//if we already have calculated
		if(dp[i][j] !=  -1){
			return dp[i][j];
		}
		//for up call
		int up = memo(dp,i-1, j);
		int left = memo(dp,i, j-1);

		dp[i][j] = (up+left);

		return up+left;
	}
	static int tab(int m,int n){
		int[][] dp = new int[m][n];

		for(int i=0 ; i<m ; i++){
			for(int j=0 ; j<n; j++){
				if(i==0 &&j==0){
					dp[i][j] = 1;
					continue;
				}
					//left
				int left=0;
				//up
				int up = 0;
				if(j>0)
					left = dp[i][j-1]; 
				if(i>0)
					up = dp[i-1][j];
				dp[i][j] = left+up;

			}
		}

		return dp[m-1][n-1];
	}

	static int optimizeTab(int m,int n){

		//we will create 1d array for row only
		int[] pre = new int[n];
		int[] temp = new int[n];

		for(int i=0 ; i<m ; i++){
			// int[] temp = new int[n];
			for(int j=0 ; j<n; j++){
				if(i==0 &&j==0){
					temp[j] = 1;
					continue;
				}
				//else
				int up=0;
				int left =0;
				
				if(i>0)
					up = pre[j];
				if(j>0)
					left = temp[j-1];
					
				temp[j] = up + left;
			}
			pre = temp;
		}

		return pre[n-1];
	}
}