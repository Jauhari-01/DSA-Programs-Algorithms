import java.util.*;

class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
	
	//Write code here
		int sp = 0;
		int st = n;
		int row = 1;
		//upper part
		for(int i = 0 ; i < n/2 ; i++){
			for(int j=0 ; j<sp ; j++) System.out.print(" ");
	
			for(int j=0 ; j < st ; j++){
				if(j==0 || j == st-1)
				System.out.print("*");
				else
				System.out.print(" ");
			}
			sp++;
			st -= 2;
			row++;
			System.out.println();
		}

	  //middle part
	  if(n%2 == 1){
		  for(int i=0 ; i<n/2 ; i++)System.out.print(" ");
		  System.out.println("*");
	  }

	  sp--;
	  st += 2;
	  for(int i = 0 ; i < n/2 ; i++){
			for(int j=0 ; j<sp ; j++) System.out.print(" ");
	
			for(int j=0 ; j < st ; j++){
				if(j==0 || j == st-1)
				System.out.print("*");
				else
				System.out.print(" ");
			}
			sp--;
			st += 2;
			row++;
			System.out.println();
		}
  }
}


public class PatternXPrinting {
    
}
