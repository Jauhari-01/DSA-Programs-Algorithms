package AdvanceDSA.BackTracking.QuestionOnPermutationCombination.Premutation;

import java.io.*;
import java.util.*;
//choosing box not item at level
public class Permutation1 {
    /*
     * 
     * Place the Non-Identical Items
        You are given a number of boxes N and a number of non-identical items R.
        You are required to place the items in those boxes and print all such configurations possible.
        Items are numbered from 1 to R.
        Note 1: Number of boxes is greater than number of items, hence some of the boxes may remain empty.
        Note 2: Write the recursive code as intended without changing the signature. 
        The judge can't force you but intends you to teach a concept.

        Input

            4
            1
        Output

            1000
            0100
            0010
            0001

    */


     //Permutation + Combinations
  public static void permutations(int cb, int tb, boolean[] items, int itpsf, int ts, String asf){
    // write your code here

	  if(cb >  tb){
		  if(itpsf == ts){
			  System.out.println(asf);
		  }
		  
		  return;
	  }

	  for(int i=0;i<ts ; i++){
		  if(!items[i]){
			  items[i] = true;
			  permutations(cb+1,tb,items,itpsf+1,ts,asf+(i+1));
			  items[i] = false;
		  }
	  }

	   permutations(cb+1,tb,items,itpsf,ts,asf+"0");
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new boolean[ritems], 0, ritems, "");
  }

}

// CB- current box
// TB - total box
// ritems- total no of items
// itpsf - items placed so far
// ts - total items
// asf - answer so far
