import java.util.*;
import java.io.*;
/*
 * 
    * Merge k Sorted Arrays
        Given K sorted arrays arranged in the form of a matrix of 
        size K*K. The task is to merge them into one sorted array.

    Input
        The first line contains an integers K.
        The next K lines contains K spaced integers, the elements of the matrix.

    Output
        Print the merged sorted list.

    Expected Time Complexity: O(n*Log(K)) -->Where n is no. of total elemets in matrix,K=no. of lists
    Expected Auxiliary Space: O(K)

    Example 1
    Input

        3
        1 2 3
        4 5 6 
        7 8 9
    Output

        1 2 3 4 5 6 7 8 9
 * 
*/
class Pair implements Comparable<Pair>{
	int listIndex;
	int elementIndex;
	int val;
	Pair(int i,int j,int val){
		this.listIndex = i;
		this.elementIndex = j;
		this.val = val;
	}

	public int compareTo(Pair o){
		return this.val - o.val;
	}
}
class Solution{
    static void mergeK(int a[][], int k){
        // Your code here. Print output here. 
		Queue<Pair> pq = new PriorityQueue<>();
		int n = a.length;
		for(int i=0;i<n;i++){
			pq.add(new Pair(i,0,a[i][0]));
		}

		//printing 
		while(pq.size() > 0){
			Pair p = pq.remove();
			System.out.print(p.val+" ");
			int i = p.listIndex;
			int j = p.elementIndex;

			if(j+1 < a[i].length){
				pq.add(new Pair(i,j+1,a[i][j+1]));
			}
		}
    }
}

public class MergeKSortedArrays {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = input.nextInt();
            }
        }
        Solution.mergeK(a, n);
    }
}
