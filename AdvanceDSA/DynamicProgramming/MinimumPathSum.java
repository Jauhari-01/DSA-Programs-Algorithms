import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution {

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