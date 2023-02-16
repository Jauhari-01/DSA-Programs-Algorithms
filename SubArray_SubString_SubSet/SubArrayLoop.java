import java.util.ArrayList;
public class SubArrayLoop {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ArrayList<ArrayList<Integer>> ans = subarrayLoop(arr);
        for (ArrayList<Integer> sub : ans) {
            System.out.println(sub);
        }
    }
    public static ArrayList<ArrayList<Integer>> subarrayLoop(int[] arr) {
        int n = arr.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ArrayList<Integer> sub = new ArrayList<Integer>();
                for (int k = i; k <= j; k++) {
                    sub.add(arr[k]);
                }
                ans.add(sub);
            }
        }
        return ans;
    }
}
