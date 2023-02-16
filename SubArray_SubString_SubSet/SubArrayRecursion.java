import java.util.ArrayList;
public class SubArrayRecursion {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ArrayList<ArrayList<Integer>> ans = subarrayRecursive(arr, 0, arr.length - 1);
        for (ArrayList<Integer> sub : ans) {
            System.out.println(sub);
        }
    }

    public static ArrayList<ArrayList<Integer>> subarrayRecursive(int[] arr, int start, int end) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (start == end) {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            sub.add(arr[start]);
            ans.add(sub);
            return ans;
        }
        for (int i = start; i <= end; i++) {
            for (int j = i; j <= end; j++) {
                ArrayList<Integer> sub = new ArrayList<Integer>();
                for (int k = i; k <= j; k++) {
                    sub.add(arr[k]);
                }
                ans.add(sub);
            }
        }
        ans.addAll(subarrayRecursive(arr, start + 1, end));
        return ans;
    }
}
