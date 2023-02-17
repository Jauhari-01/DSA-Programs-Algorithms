package AdvanceDSA.BackTracking.QuestionOnPermutationCombination.Premutation;

import java.io.*;
import java.util.*;

public class WordsKLengthWords1 {

  /**
   *    //same logic as Permutation - 1
   *    1. You are given a word (may have one character repeat more than once).
        2. You are given an integer k.
        3. You are required to generate and print all k length words 
            (of distinct chars) by using chars of the 
            word.

        Sample Input
            aabbbccdde
            3
        Sample Output
            abc
            abd
            abe
            acb
            adb
            aeb
            acd
            ace
            adc
            aec
            ade
            aed
            bac
            bad
            bae
            cab
            dab
            eab
            cad
            cae
            dac
            eac
            dae
            ead
            bca
            bda
            bea
            cba
            dba
            eba
            cda
            cea
            dca
            eca
            dea
            eda
            bcd
            bce
            bdc
            bec
            bde
            bed
            cbd
            cbe
            dbc
            ebc
            dbe
            ebd
            cdb
            ceb
            dcb
            ecb
            deb
            edb
            cde
            ced
            dce
            ecd
            dec
            edc

  */
 
  private static void permutation1(int boxfilled , String str , int charSfar , int totalchartoprint , Character[] asf){
      //base case
      if(boxfilled == str.length()){
          if(charSfar == totalchartoprint){
              for(char ch : asf){
                  System.out.print(ch);
              }
              System.out.println();
          }
          return;
      }
      //we are selecting jyada(boxes)
      for(int i=0 ; i<asf.length ; i++){
          if(asf[i] == null){
              asf[i] = str.charAt(boxfilled);
              permutation1(boxfilled+1,str,charSfar+1,totalchartoprint,asf);
              asf[i] = null;
          }
      }
      
      //so we will going to have empty space for not putting 
      //anything for that we need extra call
      //leaving current char
      permutation1(boxfilled+1,str,charSfar+0,totalchartoprint,asf);
  }
 
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

    permutation1(0,ustr,0,k,new Character[k]);
  }

}