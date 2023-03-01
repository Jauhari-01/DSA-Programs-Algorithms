import java.util.* ;
import java.io.*; 
public class ShortestSupersequence {

    //how we can calculate the length of shortestSupersequence
    // (n+m) - LCS(a,b) --> because we want to add same elements onces
    //                      and all unique elements to create shortestSupersequence 

    /*
        *   Time Complexity: O(N*M)
                Reason: There are two nested loops

            Space Complexity: O(N*M)
                Reason: We are using an external array of size (N*M).

            Problem Statement: Shortest Common Supersequence

                We are given two strings ‘S1’ and ‘S2’. We need to return their 
                shortest common supersequence. A supersequence is defined as 
                the string which contains both the strings S1 and S2 as 
                subsequences.

            Sample Input 1 :
                2
                brute
                groot
                bleed
                blue
            Sample Output 1 :
                bgruoote
                bleued

            //Note : There can be multiple answers
    */

    public static String shortestSupersequence(String a, String b) {
        // Write your code here..
        int[][] dp = LCS(a, b);

        String ans = getShortestSupersequence(a,b,dp);

        return ans;
    }


    //Helper functions
    static String getShortestSupersequence(String s,String t,int[][] dp){
        int n = s.length();
        int m = t.length();

        int i = n;
        int j = m;

        StringBuilder str = new StringBuilder();

        while(i>0 && j > 0){
            char c1 = s.charAt(i-1);
            char c2 = t.charAt(j-1);

            if(c1 == c2){
                //moving dig
                str.append(c1);
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                //changing row
                str.append(c1);
                i--;
            }else{
                //changig col
                str.append(c2);
                j--;
            }
        }

        while(i>0){
            str.append(s.charAt(i-1));
            i--;
        }

        while(j>0){
            str.append(t.charAt(j-1));
            j--;
        }

        return rev(str.toString());
    }

    static String rev(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1 ; i>= 0 ; i--){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
    static int[][] LCS(String s,String t){
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n ; i++){
            for(int j=1 ; j<=m ; j++){
                char ch1 = s.charAt(i-1);
                char ch2 = t.charAt(j-1);

                if(ch1 == ch2){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp;
    }                                                    
}