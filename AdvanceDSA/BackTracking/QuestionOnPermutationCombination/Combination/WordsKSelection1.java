import java.io.*;
import java.util.*;

/*
 * 
 *  1. You are given a word (may have one character repeat more than once).
    2. You are given an integer k.
    2. You are required to generate and print all ways you can select k distinct characters out of the 
        word.

Sample Input
    aabbbccdde
    3
Sample Output
    abc
    abd
    abe
    acd
    ace
    ade
    bcd
    bce
    bde
    cde
 * 
 */

public class WordsKSelection1 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int k = scn.nextInt();
    
        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
          if (unique.contains(ch) == false) {
            unique.add(ch);
            ustr += ch;
          }
        }
    
        combination(0, ustr, 0, k, "");
      }
    
    
      public static void combination(int i, String ustr, int ssf, int ts, String asf ) {
            
            //base case
            if(i == ustr.length()){
                if(ssf == ts){
                    System.out.println(asf);
                }
                return;
            }
            
            //in selection we have to use combination
            //we will going to have two choices
            
            char ch = ustr.charAt(i);
            //yes we can choose char 
            combination(i+1,ustr,ssf+1,ts,asf+ch);
            //we cannot choose char
            combination(i+1,ustr,ssf,ts,asf);
            
      }
}
