
import java.util.Scanner;

public class PairSumSorted {

    static void pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                System.out.println("(" + nums[left] + ", " + nums[right] + ")");
                return;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("Not Found");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        pairSumSorted(nums, target);

        sc.close();
    }
}

// Time Complexity: O(n)
// Additional Space: O(1)
// Brute-force approach: O(n^2) time and O(1) space.
