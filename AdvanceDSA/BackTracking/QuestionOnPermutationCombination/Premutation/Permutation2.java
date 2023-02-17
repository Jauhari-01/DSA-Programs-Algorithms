package AdvanceDSA.BackTracking.QuestionOnPermutationCombination.Premutation;

import java.io.*;
import java.util.*;
public class Permutation2 {
    // cb -current box
    // tb - total boxes
    //itpsf - items placed so far
    // ts- total items
    //asf - answer so far
  public static void combinations(int cb, int tb, int itpsf, int ts, String asf){
  
	  if(cb > tb){
		  if(itpsf == ts)
			  System.out.println(asf);
		  return;
	  }

	  combinations(cb+1,tb,itpsf+1,ts,asf+"i");
	  combinations(cb+1,tb,itpsf,ts,asf+"-");
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int R = Integer.parseInt(br.readLine());
    combinations(1, N, 0, R, "");
  }
}
