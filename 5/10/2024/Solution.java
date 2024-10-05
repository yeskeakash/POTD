// import java.util.*;

public class Solution {
    public long findSmallest(int[] arr) {
        int missing = 1;
        for (int num : arr) {
            if (num > missing) {
                break;
            }
            missing += num;
        }
        return missing;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3};
        long result = solution.findSmallest(arr);
        System.out.println("The smallest missing positive integer is: " + result);
    }
}
