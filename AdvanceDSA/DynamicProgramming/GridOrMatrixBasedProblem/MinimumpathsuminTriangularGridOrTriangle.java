package GridOrMatrixBasedProblem;
import java.util.* ;
import java.io.*; 
public class MinimumpathsuminTriangularGridOrTriangle {
    /*
     * 
     * Problem Description: 

            We are given a Triangular matrix. We need to find the minimum path sum from the 
            first row to the last row.
            At every cell we can move in only two directions: either to the 
            bottom cell (↓) or to the bottom-right cell(↘)

            OR
            You are given a right triangle grid consisting of n rows, where row i (0-indexed) 
            contains i + 1 cells, where each cell has an integer value. You must start from the top row and 
            reach the bottom row, and your score is the sum of the values of the cells you pass through. 
            If you are at index j in row i, you can move to either index j or 
            index j + 1 in row i + 1.

            Return the minimum score of a path from the top row to the bottom row.

            Input

                3
                2
                3 4
                6 5 7
            Output

                10
     * 
    */
}

class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        // return recursion(0, 0, triangle);
        // int[][] dp = new int[triangle.length][triangle.length];
        // for(int[] arr : dp){
        //    Arrays.fill(arr,-1);
        // }
        // return memo(0, 0,triangle, dp);

        // return tab(triangle);
        return tabOptimization(triangle,n);
    }

    //recursion for the problem
    static int recursion(int i,int j,int[][] arr){
        if(i == arr.length - 1) return arr[arr.length-1][j];

        int down = arr[i][j] + recursion(i+1, j, arr);
        int dia = arr[i][j] + recursion(i+1, j+1, arr);

        return Math.min(down,dia);
    }

    //memoization 
    // is giving TLE
    static int memo(int i,int j,int[][] arr,int[][] dp){
        if(i == arr.length - 1) return arr[arr.length-1][j];

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int down = arr[i][j] + recursion(i+1, j, arr);
        int dia = arr[i][j] + recursion(i+1, j+1, arr);

        return dp[i][j] = Math.min(down,dia);
    }

    static int tab(int[][] arr){
        //as our recursion started 0 to n(top-down)
        //this will be bottom up

        int n = arr.length;
        int[][] dp = new int[n][n];

        //initialization
        //as destination can be any cell of the last row
        for(int j = 0 ; j<n ; j++){
            dp[n-1][j] = arr[n-1][j];
        }

        //now 
        for(int i = n-2 ; i>= 0 ; i--){
            for(int j=i ; j>=0 ; j--){
                int down = arr[i][j] + dp[i+1][j];
                int dia = arr[i][j] + dp[i+1][j+1];

                dp[i][j] = Math.min(down,dia);
            }
        }

        return dp[0][0];
    }
    
    //  static int tabOptimization(int[][] triangle, int n) {
    //     int[] dp = new int[n];
    //     for (int i = 0; i < n; i++)
    //     {
    //         dp[i] = triangle[n - 1][i];
    //     }
    //     for (int i = n - 2; i >= 0; i--)
    //     {
    //         for (int j = 0; j <= i ; j++)
    //         {
    //             dp[j] = triangle[i][j] + Math.min(dp[j], dp[j + 1]);
    //         }
    //     }
    //     return dp[0];
    // }

    static int tabOptimization(int[][] triangle, int n){
     
     int front[] = new int[n];
     int cur[] = new int[n];
    
    for(int j=0;j<n;j++){
        front[j] = triangle[n-1][j];
    }
    
    for(int i=n-2; i>=0; i--){
        for (int j = 0; j <= i ; j++){
            
            int down = triangle[i][j] + front[j];
            int diagonal =triangle[i][j] + front[j+1];
            
            cur[j] = Math.min(down, diagonal);
        }
        front=cur;
    }
    
    return front[0];
    
}
}
