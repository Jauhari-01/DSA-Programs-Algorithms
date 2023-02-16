import java.util.ArrayList;
public class SubSequenceLoop {
    /*
     * 
     * the subseqBitManipulation method takes an array as 
     * input. It initializes an integer variable "n" as the 
     * length of the array. It then uses a nested loop to iterate 
     * through all possible binary numbers from 0 to 2^n - 1. For each 
     * binary number, it checks if the j-th bit is set using the bitwise 
     * AND operator. If the bit is set, it prints out the corresponding 
     * element in the array.


      
     *
     * In this example, the subseqRecursive method takes an array, 
     * an integer index, and an ArrayList current as input. It 
     * initializes an empty ArrayList called ans, which will store 
     * the subsequences. It then checks if the index is equal to the 
     * length of the array, if it is then it adds a new ArrayList which 
     * is a copy of current ArrayList to ans and returns ans. If the 
     * index is not equal to the length of the array, it creates a new 
     * ArrayList called current1 which is a copy of the current ArrayList. 
     * Then it recursively calls the subseqRecursive method for the next 
     * index and for both the current and current1 ArrayLists, and adds 
     * the returned ArrayLists to ans. The final ans is returned. 
    */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ArrayList<ArrayList<Integer>> ans = subseqRecursive(arr, 0, new ArrayList<Integer>());
        for (ArrayList<Integer> sub : ans) {
            System.out.println(sub);
        }
    }
    public static ArrayList<ArrayList<Integer>> subseqRecursive(int[] arr, int index, ArrayList<Integer> current) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (index == arr.length) {
            ans.add(new ArrayList<Integer>(current));
            return ans;
        }
        ArrayList<Integer> current1 = new ArrayList<Integer>(current);
        ans.addAll(subseqRecursive(arr, index + 1, current));
        current1.add(arr[index]);
        ans.addAll(subseqRecursive(arr, index + 1, current1));
        return ans;
    }
  /**
   * This will generate all subsequences of the array 
   * and will return them in the form of an ArrayList. 
   * The time complexity of this approach is O(2^n) where 
   * n is the size of the array and space complexity is O(n*2^n) 
   * as we are storing all the subsequences in memory.
  */
}
