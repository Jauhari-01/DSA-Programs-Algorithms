import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // write code here

		for(int i=1 ; i<=n ; i++){
			for(int j = i ; j <= n ; j++){
				System.out.print("* ");
			}
			System.out.println();
		}
    }
}

public class StarPring {
    
}
