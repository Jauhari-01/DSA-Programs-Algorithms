package GridOrMatrixBasedProblem;

import java.util.* ;
import java.io.*; 
public class ChocolatePick3dDP{

	/*
	3-d DP : Ninja and his friends
	 * Problem Description: 

		We are given an ‘N*M’ matrix. Every cell of the matrix 
		has some chocolates on it, mat[i][j] gives us the number of chocolates. 
		We have two friends ‘Alice’ and ‘Bob’. initially, Alice is standing on the 
		cell(0,0) and Bob is standing on the cell(0, M-1). Both of them can move 
		only to the cells below them in these three directions: to the bottom cell (↓), 
		to the bottom-right cell(↘), or to the bottom-left cell(↙).

		When Alica and Bob visit a cell, they take all the chocolates from 
		that cell with them. It can happen that they visit the same cell, in that 
		case, the chocolates need to be considered only once.

		They cannot go out of the boundary of the given matrix, we need to 
		return the maximum number of chocolates that Bob and Alice can 
		together collect.

		Sample Input 1 :
			2
			3 4
			2 3 1 2
			3 4 2 2
			5 6 3 5
			2 2
			1 1
			1 2
		Sample Output 1 :
			21
			5
	*/


	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		// return recursion(0, 0, c-1, r, c, grid);

		// int[][][] dp = new int[r][c][c];

		// for(int[][] mat : dp){
		// 	for(int[] row : mat){
		// 		Arrays.fill(row,-1);
		// 	}
		// }

		// return memo(0,0, c-1, r, c, grid, dp);
		// return tab(r, c, grid);
		return tabOptimization(r, c, grid);
	}

	//recursion
	static int recursion(int i,int j1,int j2,int n,int m,int[][] grid){
		//base case
		if(j1 <0 || j1 >= m || j2 < 0 || j2 >= m) return (int)-1e9; // out of bound for colom

		//as we will reach last row for both the friends
		if(i == n-1){
			//we can have two case 
			if(j1 == j2) return grid[i][j1];
			else return grid[i][j1]+grid[i][j2] ; // for diffrent cell case
		}

		//apart from the last row
		//outer loop for movement of alice 
		int max = (int)-1e9;
		for(int d1 = -1 ; d1 <= 1 ; d1++){
			//inner loop showing movement of bob in respect to Alice
			for(int d2 = -1 ; d2 <= 1 ; d2++){
				int value = 0;
				if(j1 == j2) value = grid[i][j1];
				else value = grid[i][j1]+grid[i][j2];
				value += recursion(i+1, j1+d1, j2+d2, n, m, grid);

				max = Math.max(max,value);
			}
		}

		return max;
	}

	//DP solutions

	//1 memoization
	static int memo(int i,int j1,int j2,int n,int m,int[][] grid,int[][][] dp){
		//base case
		if(j1 <0 || j1 >= m || j2 < 0 || j2 >= m) return (int)-1e9; // out of bound for colom

		//as we will reach last row for both the friends
		if(i == n-1){
			//we can have two case 
			if(j1 == j2) return grid[i][j1];
			else return grid[i][j1]+grid[i][j2] ; // for diffrent cell case
		}

		if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
		//apart from the last row
		//outer loop for movement of alice 
		int max = (int)-1e9;
		for(int d1 = -1 ; d1 <= 1 ; d1++){
			//inner loop showing movement of bob in respect to Alice
			for(int d2 = -1 ; d2 <= 1 ; d2++){
				int value = 0;
				if(j1 == j2) value = grid[i][j1];
				else value = grid[i][j1]+grid[i][j2];
				value += memo(i+1, j1+d1, j2+d2, n, m, grid,dp);

				max = Math.max(max,value);
			}
		}

		return dp[i][j1][j2]= max;
	}

	//2. Tabulation
	static int tab(int n,int m,int[][] grid){
		int[][][] dp = new int[n][m][m];

		//base case / Initialization
		for(int j1=0 ; j1<m ; j1++){
			for(int j2=0 ; j2<m ;j2++){
				if(j1==j2) dp[n-1][j1][j2] = grid[n-1][j1];
				else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
			}
		}

		//other than base case
		for(int i=n-2 ; i>=0 ; i--){
			for(int j1=0; j1<m ; j1++){
				for(int j2=0 ; j2<m ; j2++){
					//apart from the last row
					//outer loop for movement of alice 
					int max = (int)-1e9;
					for(int d1 = -1 ; d1 <= 1 ; d1++){
						//inner loop showing movement of bob in respect to Alice
						for(int d2 = -1 ; d2 <= 1 ; d2++){
							int value = 0;
							if(j1 == j2) value = grid[i][j1];
							else value = grid[i][j1]+grid[i][j2];

							if(j1+d1 >=0 && j1+d1 <m && j2+d2 >=0 && j2+d2 <m)
								value += dp[i+1][j1+d1][j2+d2];
							else value  += (int) Math.pow(-10, 9);


							max = Math.max(max,value);
						}
					}

					dp[i][j1][j2]= max;
				}
			}
		}

		return dp[0][0][m-1];
	}

	static int tabOptimization(int n,int m,int[][] grid){
		int[][] pre = new int[m][m];
		int[][] temp = new int[m][m];

		//base case / Initialization
		for(int j1=0 ; j1<m ; j1++){
			for(int j2=0 ; j2<m ;j2++){
				if(j1==j2) pre[j1][j2] = grid[n-1][j1];
				else pre[j1][j2] = grid[n-1][j1] + grid[n-1][j2];
			}
		}

		//other than base case
		for(int i=n-2 ; i>=0 ; i--){
			for(int j1=0; j1<m ; j1++){
				for(int j2=0 ; j2<m ; j2++){
					//apart from the last row
					//outer loop for movement of alice 
					int max = (int)-1e9;
					for(int d1 = -1 ; d1 <= 1 ; d1++){
						//inner loop showing movement of bob in respect to Alice
						for(int d2 = -1 ; d2 <= 1 ; d2++){
							int value = 0;
							if(j1 == j2) value = grid[i][j1];
							else value = grid[i][j1]+grid[i][j2];

							if(j1+d1 >=0 && j1+d1 <m && j2+d2 >=0 && j2+d2 <m)
								value += pre[j1+d1][j2+d2];
							else value  += (int) Math.pow(-10, 9);

							max = Math.max(max,value);
						}
					}

					temp[j1][j2]= max;
				}
			}

	// 		for (int a = 0; a < m; a++) {
    //     front[a] = (int[])(cur[a].clone());
    //   }
			int[][] tt = pre;
			pre = temp;
			temp = tt;
		}

		return pre[0][m-1];
	}
}