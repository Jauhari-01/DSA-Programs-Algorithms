import java.util.ArrayList;

public class SubSequenceRec {
    /*
     * A subsequence of an array is a subset of the array 
     * where the order of the elements is preserved, 
     * unlike a subset where the order of elements does not matter.
    */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ArrayList<ArrayList<Integer>> ans = subseqRecursive(arr, 0, new ArrayList<Integer>());
        for (ArrayList<Integer> sub : ans) {
            System.out.println(sub);
        }
    }
    /**
     * 
     * In this example, the subseqRecursive method takes an array, 
     * an integer index, and an ArrayList current as input. 
     * It initializes an empty ArrayList called ans, which will 
     * store the subsequences. It then checks if the index is equal 
     * to the length of the array, if it is then it adds the current 
     * ArrayList to ans and returns ans. If the index is not equal to 
     * the length of the array, it creates a new ArrayList called current1 
     * which is a copy of the current ArrayList and adds the element at the 
     * current index of the array to it. Then it recursively calls the 
     * subseqRecursive method for the next index and for both the current 
     * and current1 ArrayLists, and adds the returned ArrayLists to ans. 
     * The final ans is returned.
     * 
    */
    public static ArrayList<ArrayList<Integer>> subseqRecursive(int[] arr, int index, ArrayList<Integer> current) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (index == arr.length) {
            ans.add(current);
            return ans;
        }
        ArrayList<Integer> current1 = new ArrayList<Integer>(current);
        current1.add(arr[index]);
        ans.addAll(subseqRecursive(arr, index + 1, current));
        ans.addAll(subseqRecursive(arr, index + 1, current1));
        return ans;
    }

    /*
     * 
     * The time complexity of this approach is O(2^n) 
     * where n is the size of the array, as for every element 
     * of array we can either include it or not, so for every 
     * element we are making two recursive calls and for a total 
     * of n elements, it becomes 2^n. The space complexity of this 
     * approach is O(n*2^n) as we are storing all the subsequences in memory.
    */
}
