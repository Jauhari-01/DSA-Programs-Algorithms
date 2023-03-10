package DpOnString;

public class WildcardPatternMatching {
    /*
     * 
     * Problem Statement: Wildcard Matching

        We are given two strings ‘S1’ and ‘S2’. String S1 can have the following two special characters:
            ‘?’ can be matched to a single character of S2.
            ‘*’ can be matched to any sequence of characters of S2. 
            (sequence can be of length zero or more).
        We need to check whether strings S1 and S2 match or not.


        Sample Input 1:
            3
            ?ay
            ray
            ab*cd
            abdefcd
            ab?d
            abcc
        Sample Output 1:
            True
            True
            False
        
        Explanation Of The Sample Input1:
            Test Case 1:
                The pattern is “?ay” and the text is ray.
                ‘?’ can match a character so it matches with a character ‘r’ of the text and rest 
                of the text matches with the pattern so we print True.

            Test Case 2:
                “ab” of text matches with “ab” of pattern and then ‘*’ of pattern matches 
                with “def” of the text and “cd” of text matches with “cd” of the pattern. 
                Whole text matches with the pattern so we print True.

            Test Case 3:
                “ab” of pattern matches with “ab” of text. ‘?’ of pattern matches with ‘c’ 
                of the text but ‘d’ of the pattern do not match with ‘c’ 
                of the text so we print False.

            Sample Input 1:
                1
                ba*a?
                baaabab
            Sample Output 1:
                True
     * 
    */
}

class Solution {
	public static boolean wildcardMatching(String pattern, String text) {
		// Write your code here.
		int n = pattern.length();
		int m = text.length();
		// return f(n-1, m-1, pattern, text);
		// Boolean[][] dp = new Boolean[n][m];
		
		// return memo(dp, n-1, m-1, pattern, text);

		// return tab(n, m, pattern, text);
		return tabOptimization(n, m, pattern, text);
	}

	//recursion
	static boolean f(int i,int j,String s,String t){
		//base case
		if(i<0 && j < 0) return true;
		if(i<0 && j >= 0) return false;
		if(i>=0 && j<0){
			for(int ii=0;ii<=i;ii++){
				if(s.charAt(ii) != '*') return false;
				return true;
			}
		}

		//case for '?' Or matching char
		if(s.charAt(i) == t.charAt(j) || s.charAt(i) == '?'){
			return f(i-1, j-1, s, t);
		}

		//case for '*'
		if(s.charAt(i) == '*'){
			return f(i-1, j, s, t) | f(i, j-1, s, t);
		}

		//if we are here we got a michmatching of char
		return false;
	}

	//Memoization
	static boolean memo(Boolean [][]dp,int i,int j,String s,String t){
		//base case
		if(i<0 && j < 0) return true;
		if(i<0 && j >= 0) return false;
		if(i>=0 && j<0){
			for(int ii=0;ii<=i;ii++){
				if(s.charAt(ii) != '*') return false;
				return true;
			}
		}

		//dp case
		if(dp[i][j] != null) return dp[i][j];

		//case for '?' Or matching char
		if(s.charAt(i) == t.charAt(j) || s.charAt(i) == '?'){
			return dp[i][j] = memo(dp,i-1, j-1, s, t);
		}

		//case for '*'
		if(s.charAt(i) == '*'){
			return dp[i][j] = memo(dp,i-1, j, s, t) | memo(dp,i, j-1, s, t);
		}

		//if we are here we got a michmatching of char
		return false;
	}


	static boolean isAllStars(String S1, int i) {

    // S1 is taken in 1-based indexing
    for (int j = 1; j <= i; j++) {
      if (S1.charAt(j - 1) != '*')
        return false;
    }
    return true;
  }

	static boolean tab(int n,int m,String s,String t){
		
		boolean [][]dp = new boolean[n+1][m+1];
		dp[0][0] = true;

		//if(i<0 && j >= 0) return false;
		for(int j=1 ; j<=m ; j++){
			dp[0][j] = false;
		}
		//if(i>=0 && j<0)
		for(int i = 1;i<=n ; i++){
			dp[i][0] = isAllStars(s, i);
		}
		for(int i=1; i<=n ; i++){
			for(int j=1 ; j<=m ; j++){
				char ch = s.charAt(i-1);
				char ch2 = t.charAt(j-1);

				if(ch == ch2 || ch == '?'){
					dp[i][j] = dp[i-1][j-1];
				}else if(ch == '*'){
					dp[i][j] = dp[i][j-1] ||  dp[i-1][j];
				}else{
					dp[i][j] = false;
				}
			}
		}

		return dp[n][m];
	}

	static boolean tabOptimization(int n,int m,String s,String t){
		
		boolean []cur = new boolean[m+1];
		boolean []pre = new boolean[m+1];
		pre[0] = true;

		//if(i<0 && j >= 0) return false;
		// for(int j=1 ; j<=m ; j++){
		// 	dp[0][j] = false;
		// }
		//if(i>=0 && j<0)
		// for(int i = 1;i<=n ; i++){
		// 	dp[i][0] = isAllStars(s, i);
		// }
		for(int i=1; i<=n ; i++){
			cur[0] = isAllStars(s, i);
			for(int j=1 ; j<=m ; j++){
				char ch = s.charAt(i-1);
				char ch2 = t.charAt(j-1);

				if(ch == ch2 || ch == '?'){
					cur[j] = pre[j-1];
				}else if(ch == '*'){
					cur[j] = cur[j-1] ||  pre[j];
				}else{
					cur[j] = false;
				}
			}
			boolean[] temp = pre;
			pre = cur;
			cur = temp;
		}

		return pre[m];
	}

}

