import java.util.ArrayList;

/**
 * 
 * In this example, the subarrayBitManipulation method takes an 
 * array as input. It initializes an integer variable "n" as the 
 * length of the array. It then uses a nested loop to iterate through 
 * all possible binary numbers from 0 to 2^n - 1. For each binary 
 * number, it checks if the j-th bit is set using the bitwise AND 
 * operator. If the bit is set, it prints out the corresponding 
 * element in the array.

The time complexity of this approach is O(n*2^n) where 
n is the size of the array, and the space complexity is O(1) 
as we are not storing any subsets in memory.

In this approach, we don't need to store the subsets in any data structure, it directly prints the subset as we iterate through the array which makes it efficient in terms of space complexity.
 * 
*/
public class SubSetLoop {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> ans = subsetLoop(arr);
        for (ArrayList<Integer> sub : ans) {
            System.out.println(sub);
        }
    }

    public static ArrayList<ArrayList<Integer>> subsetLoop(int[] arr) {
        int n = arr.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < (1<<n); i++) {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    sub.add(arr[j]);
                }
            }
            ans.add(sub);
        }
        return ans;
    }
}
