import java.util.*;
/*
 * Ugly Number II
        An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
        Given an integer n, return the nth ugly number.

    Input Format
        A integer N.

    Output Format
        Print nth ugly number.

    Example 1
        Input
            5
        Output
            5
    Explanation
        [1, 2, 3, 4, 5, 6, 8, 9, 10, 12,....] is the sequence of starting ugly numbers.

    Example 2
        Input
            8
    Output
            9
    Explanation
            [1, 2, 3, 4, 5, 6, 8, 9, 10, 12,....] is the sequence of starting ugly numbers.
*/
class Solution {
    public  static int nthUglyNumber(int n)
    {
       //Write your code here
		Queue<Long> pq = new PriorityQueue<>();
		pq.add(1L);

		//as first number is already in the priorityQueue
		for(int i=1; i <= n-1 ; i++){
			long val = pq.remove();

			//for repeating values
			while(pq.size() > 0 && pq.peek() == val) pq.remove();

			pq.add(val*2);
			pq.add(val*3);
			pq.add(val*5);
		}

		long ans = pq.remove();
		return (int)ans;
    }
    
}

public class UglyNumberII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Solution.nthUglyNumber(n));
    }
}
