import java.util.ArrayList;
/*
 * 
 * In Java, an array is a collection of elements of the same type, stored in a contiguous 
 * memory location. A subset of an array is a sub-collection of elements from the original array.
*/
public class SubSetRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> ans = subsetRecursive(arr, 0, new ArrayList<Integer>());
        for (ArrayList<Integer> sub : ans) {
            System.out.println(sub);
        }
    }

    public static ArrayList<ArrayList<Integer>> subsetRecursive(int[] arr, int index, ArrayList<Integer> current) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (index == arr.length) {
            ans.add(new ArrayList<>(current));
            return ans;
        }
        current.add(arr[index]);
        ans.addAll(subsetRecursive(arr, index + 1, current));
        current.remove(current.size() - 1);
        ans.addAll(subsetRecursive(arr, index + 1, current));
        return ans;
    }
}
