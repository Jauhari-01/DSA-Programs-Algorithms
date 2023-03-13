import java.util.*;

class Accio {
    public void linesStars(int m, int n) {
        //Write your code here and print output in this function

		for(int i=1 ; i<=m ; i++){
			for(int j=1 ; j<=n ; j++){
				System.out.print("*");
			}
			System.out.println();
		}
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Accio Obj = new Accio();
        Obj.linesStars(m, n);
        sc.close();
    }
}
public class LinesandStars {
    
}
