import java.io.*;
import java.util.*;

public class WordsKSelection2 {

    /*
     * 
     *  1. You are given a word (may have one character repeat more than once).
        2. You are given an integer k.
        2. You are required to generate and print all ways you can select 
            k distinct characters out of the word.

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

    */


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
    
        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
          if (unique.contains(ch) == false) {
            unique.add(ch);
            ustr += ch;
          }
        }
    
        generateSelection(ustr, 1, k, -1, "");
      }
      
      private static void generateSelection(String str,int selected,int remain,int last,String asf){
          // this is noting but 
          // combination using permutation
          // or box select in combination
          
          //base case
          if(selected > remain){
              System.out.println(asf);
              return ;
          }
          
          for(int i = last+1 ; i<str.length(); i++){
              char ch = str.charAt(i);
              generateSelection(str,selected+1,remain,i,asf+ch);
          }
      }
}
