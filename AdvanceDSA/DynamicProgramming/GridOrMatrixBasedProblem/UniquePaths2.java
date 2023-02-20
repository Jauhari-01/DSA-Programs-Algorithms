package GridOrMatrixBasedProblem;

import java.util.*;
public class UniquePaths2 {
    /*
     * Problem Link: Maze Obstacles

        Problem Description: 
            We are given an “N*M” Maze. 
            The maze contains some obstacles. A cell is ‘blockage’ in the maze if its value is -1. 
            0 represents non-blockage. There is no path possible through a blocked cell.

        We need to count the total number of unique paths from the top-left 
            corner of the maze to the bottom-right corner. At every cell, 
            we can move either down or towards the right.

        Sample Input 1 :
            2    <--- test case
            2 2
            0 0
            0 0
            3 3
            0 0 0 
            0 -1 0 
            0 0 0
        Sample Output 1 :
            2
            2
    */


}

class Solution {
    static int mod = 1000000007;
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        // Write your code here.
        // return recursion(n-1, m-1, mat);

        //memoization
        // int[][] dp = new int[n][m];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }

        // return memo(n-1, m-1, mat, dp);

        //tab
        // return tab(n, m, mat);   
        return optimize(n, m, mat);    
        
    }

    //recursion
    static int recursion(int i,int j,ArrayList<ArrayList<Integer>> mat){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        //if i>=0 and j>=0 and mat[i][j] == -1

        if(mat.get(i).get(j) == -1) return 0;

        int up = recursion(i-1, j, mat);
        int left = recursion(i, j-1, mat);

        return up+left;
    }

    //we got TLE here because of stack call 
    static int memo(int i,int j,ArrayList<ArrayList<Integer>> mat,int[][] dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        //if i>=0 and j>=0 and mat[i][j] == -1

        if(mat.get(i).get(j) == -1) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int up = recursion(i-1, j, mat);
        int left = recursion(i, j-1, mat);

        return dp[i][j] = up+left;
    }
   
    static int tab(int n,int m,ArrayList<ArrayList<Integer>> mat){
        int[][] dp = new int[n][m];
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                
                if(mat.get(i).get(j) == -1){
                    dp[i][j] = 0; // we can ignore this case in java
                                // because bydefault it will be 0 in dp[][]
                    continue;
                }

                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                //else

                int left = 0;
                int up = 0;

                if(i>0){
                    up = dp[i-1][j]; 
                }
                if(j>0){
                    left = dp[i][j-1];
                }

                dp[i][j] = (left + up)%mod;
            }
        }

        return dp[n-1][m-1];
    }
    
    static int optimize(int n,int m,ArrayList<ArrayList<Integer>> mat){
        int[] pre = new int[m];
        int[] temp = new int[m];
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                
                if(mat.get(i).get(j) == -1){
                    temp[j] = 0; // we can ignore this case in java
                                // because bydefault it will be 0 in dp[][]
                    continue;
                }

                if(i == 0 && j == 0){
                    temp[j] = 1;
                    continue;
                }
                //else

                int left = 0;
                int up = 0;

                if(i>0){
                    up = pre[j]; 
                }
                if(j>0){
                    left = temp[j-1];
                }

                temp[j] = (left + up)%mod;
            }

            pre = temp;
        }

        return pre[m-1];
    }
}

