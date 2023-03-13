import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
                Scanner in = new Scanner(System.in);
                int n = in.nextInt();
                //printing the pattern
                for(int i=1;i<=n;i++){
                        for(int j=0;j<n-i;j++){
                                System.out.print(" ");
                        }
                        for(int j=0;j<(2*i-1);j++){
                                System.out.print(2*i-1);
                        }
                        System.out.println();
                }
	}
}
public class OddNumberPyramid {
    
}
