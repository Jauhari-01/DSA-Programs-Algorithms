import java.util.*;

class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       // Write your code here
		// char ch = 'A';
		for(int i=0 ; i< n ; i++){
			for(int j=0; j<=i ; j++){
				System.out.print((char)('A'+i));
			}
			System.out.println();
		}
    }
}

public class PrintCharacterPattern {
    
}
