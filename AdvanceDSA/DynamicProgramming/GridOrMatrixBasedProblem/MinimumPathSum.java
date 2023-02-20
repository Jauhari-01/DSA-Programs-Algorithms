package GridOrMatrixBasedProblem;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Solution - 2 class having n to 0 recursion approach
//Imp :  (int)Math.pow(10,9);
class Solution2 {

	/*
	 * We are given an “N*M” matrix of integers. 
	 * We need to find a path from the top-left corner to the bottom-right 
	 * corner of the matrix, such that there is a minimum cost past that we select.

		At every cell, we can move in only two directions: right and bottom. 
		The cost of a path is given as the sum of values of 
		cells of the given matrix.
	*/

	
    /**
     * 
     *  Minimum Path Sum
        You are given a matrix of size m*n. Each cell of the matrix consists of a non-positive integer. 
        You need to find a path from top left to bottom right, 
        which minimizes the sum of all numbers along its path.

        Note: You can only move either down or right at any point in time.

        Note:- The input and output has been managed for you. 
                You just need to complete the function minPathSum() 
                and return the minimum cost path sum.

        Input

            2 3
            2 3 4
            5 6 7
        Output

            16
     * 
    */
	
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        int n = grid.length;
        int m = grid[0].length;

        // return recursion(n-1, m-1, grid);
        // int[][] dp = new int[n][m];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }

        // return memo(n-1,m-1,grid,dp);

        // return tab(n, m, grid);
        return tabOptimize(n, m, grid);
    }

    //recursion
    static int recursion(int i,int j,int[][] matrix){
        if(i==0 && j == 0)
            return matrix[0][0];
        if(i<0 || j<0)
            // return Integer.MAX_VALUE;
            return (int)Math.pow(10,9);
    
        int up = matrix[i][j]+recursion(i-1,j,matrix);
        int left = matrix[i][j]+recursion(i,j-1,matrix);
  
        return Math.min(up,left);
    }
    static int memo(int i,int j,int[][] matrix,int[][] dp){
        if(i==0 && j == 0)
            return matrix[0][0];
        if(i<0 || j<0)
            // return Integer.MAX_VALUE;
            return (int)Math.pow(10,9);

        if(dp[i][j] != -1) return dp[i][j];
        int up = matrix[i][j]+memo(i-1,j,matrix,dp);
        int left = matrix[i][j]+memo(i,j-1,matrix,dp);
  
        return dp[i][j] = Math.min(up,left);
    }

    //tabulation 
    static int tab(int n,int m,int[][] matrix){
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0 ; j<m ; j++){
                if(i==0 && j == 0){
                    dp[i][j] = matrix[i][j];
                }else{
                    int left = 0;
                    int up = 0;
                    up = (i>0)?matrix[i][j] + dp[i-1][j] : (int)Math.pow(10,9);
                    left = (j>0) ? matrix[i][j] + dp[i][j-1] : (int)Math.pow(10,9);

                    dp[i][j] = Math.min(up,left);
                }
            }
        }

        return dp[n-1][m-1];
    }

     static int tabOptimize(int n,int m,int[][] matrix){
        int[] pre = new int[m];
        int[] temp = new int[m];

        for(int i=0; i<n; i++){
            for(int j=0 ; j<m ; j++){
                if(i==0 && j == 0){
                    temp[j] = matrix[i][j];
                }else{
                    int left = 0;
                    int up = 0;
                    up = (i>0)?matrix[i][j] + pre[j] : (int)Math.pow(10,9);
                    left = (j>0) ? matrix[i][j] + temp[j-1] : (int)Math.pow(10,9);

                    temp[j] = Math.min(up,left);
                }
            }

            pre = temp;
        }

        return pre[m-1];
    }
}

//Solution -  class having 0 to n recursion approach
class Solution {

	public static int minPathSum(int[][] input) {
		//Your code goes here
		int[][] dp = new int[input.length][input[0].length];
		// int ans = solve1(input,dp,0,0);
		int ans = solve2(input,dp);
		return ans;
	}
	//tabulation  // TC - O(n^2) // SC - O(n^2)
	static int solve2(int[][] input,int[][] dp){
		int n = input.length;
		int m = input[0].length;

		//do this 
		// dp[n-1][m-1] = input[n-1][m-1]; 
		// start loop i = n-2
		// start loop j = m-2
		// we will skip a row 
		
		
		for(int i = n-1 ; i>=0 ; i--){
			for(int j = m - 1 ; j >= 0 ; j--){
				if(i == n-1 && j == m-1){
					dp[i][j] = input[i][j];
					continue;
				}
				int right = j+1 >= m ? Integer.MAX_VALUE : dp[i][j+1];
				int down  = i+1 >= n ? Integer.MAX_VALUE : dp[i+1][j];

				dp[i][j] = input[i][j] + Math.min(right,down);
			}
		}
		
		return dp[0][0];
	}
	//memoization // TC - O(n^2) // SC - O(n^2) + O(n)
	static int solve1(int[][] input,int[][] dp,int sr,int sc){
		if(sr == input.length || sc == input[0].length){
			return Integer.MAX_VALUE;
		}
		if(sr == input.length-1 && sc == input[0].length-1){
			return input[sr][sc];
		}
		if(dp[sr][sc] != 0){
			return dp[sr][sc];
		}
		int right = solve1(input,dp,sr,sc+1);
		int down = solve1(input,dp,sr+1,sc);

		return dp[sr][sc] = input[sr][sc] +Math.min(right,down);
	}
}
public class MinimumPathSum {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[][] take2DInput() throws IOException {
        String[] strRowsCols = br.readLine().trim().split("\\s");
        int mRows = Integer.parseInt(strRowsCols[0]);
        int nCols = Integer.parseInt(strRowsCols[1]);

        if (mRows == 0) {
            return new int[0][0];
        }


        int[][] mat = new int[mRows][nCols];

        for (int row = 0; row < mRows; row++) {
            String[] strNums; 
            strNums = br.readLine().trim().split("\\s");
            
            for (int col = 0; col < nCols; col++) {
                mat[row][col] = Integer.parseInt(strNums[col]);
            }
        }

        return mat;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] mat = take2DInput();
        System.out.println(Solution.minPathSum(mat));
    }
}