import java.util.*;
public class HalfFilledHourglassPattern {
    //run programm for n == 5 and n == 8
}
class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution.printHourglassPattern(n);
    }
}
class Solution {
    static void printHourglassPattern(int n) {
        //Your code here
		int sp = 0;
		int st = n;
		int row = 1;
		//upper part
		for(int i = 0 ; i < n/2 ; i++){
			for(int j=0 ; j<sp ; j++) System.out.print("  ");

			for(int j=0 ; j < st ; j++){
				if(i==0 || j==0 || j == st-1)
				System.out.print("* ");
				else
				System.out.print("  ");
			}
			sp++;
			st -= 2;
			row++;
			System.out.println();
		}

		//middle
		for(int i=0 ; i<n/2 ; i++) System.out.print("  ");
		System.out.println("* ");
		
		
		//upper part
		sp--;
		st += 2;
		for(int i = n/2-1 ; i >= 0 ; i--){
			for(int j=0 ; j<sp ; j++) System.out.print("  ");

			for(int j=0 ; j < st ; j++){
				// if(i==0 || j==0 || j == st-1)
				System.out.print("* ");
			}
			sp--;
			st += 2;
			row++;
			System.out.println();
		}
    }
}


