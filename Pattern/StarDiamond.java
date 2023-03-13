import java.util.*;

class Solution {
    public void pattern(int row_size) {
        // your code here
		int n = row_size;

		//for upper part
		for(int i=1 ; i<= n ; i++){
			//space
			for(int j = 1 ; j <= n-i+1 ; j++) System.out.print(" ");
			for(int j = 1 ; j <= i ; j++) System.out.print("* ");
			System.out.println();
		}
		//middle row
		for(int i=1 ; i<=n+1 ; i++) System.out.print("* ");
		System.out.println();

		//lower part
		for(int i=n ; i>=0 ; i--){
			//space
			for(int j = 1 ; j <= n-i+1 ; j++) System.out.print(" ");
			for(int j = 1 ; j <= i ; j++) System.out.print("* ");
			System.out.println();
		}
    }
}

class Main {

    public static void main(String[] args) throws Throwable {
        Scanner cs = new Scanner(System.in);
        int n = cs.nextInt();
        cs.close();
        Solution solution = new Solution();
        solution.pattern(n);
    }
}
public class StarDiamond {
    
}


