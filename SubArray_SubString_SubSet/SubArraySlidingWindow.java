import java.util.ArrayList;
/*
 * 
 * In this example,
 *  the function subarraySlidingWindow takes an array and an integer 
 * k as input. It initializes an empty ArrayList called ans, which will 
 * store the subarrays. It then uses a nested loop to iterate through the
 *  array and create subarrays of size k by maintaining a window of size k 
 * and sliding it over the array from start to end. Each subarray is added 
 * to the ans ArrayList and the ans ArrayList is returned at the end.

The time complexity of this approach is O(n*k) 

//this approach will give us all the subarrays of size k
*/

public class SubArraySlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 1;
        ArrayList<ArrayList<Integer>> ans = subarraySlidingWindow(arr, k);
        for (ArrayList<Integer> sub : ans) {
            System.out.println(sub);
        }
    }
    public static ArrayList<ArrayList<Integer>> subarraySlidingWindow(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= arr.length - k; i++) {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            for (int j = i; j < i + k; j++) {
                sub.add(arr[j]);
            }
            ans.add(sub);
        }
        return ans;
    }
}
