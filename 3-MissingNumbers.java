import java.util.ArrayList;
import java.util.List;

public class MissingNumbers {
    public static List<Integer> findMissingNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        // Mark elements by setting their indexed positions to negative
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1; // Convert value to index
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // Mark as visited
            }
        }

        // Find missing numbers (indices that were not marked)
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // Convert index back to value
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findMissingNumbers(nums)); // Output: [5, 6]
    }
}
