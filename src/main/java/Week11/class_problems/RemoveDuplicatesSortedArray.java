
import java.util.Scanner;
import java.util.Arrays;

public class RemoveDuplicatesSortedArray {

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int unique = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[unique]) {
                unique++;
                nums[unique] = nums[i];
            }
        }

        return unique + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int length = removeDuplicates(nums);

        System.out.println("Length = " + length);

        System.out.print("nums[0.." + (length - 1) + "] = ");
        System.out.println(Arrays.toString(Arrays.copyOf(nums, length)));

        sc.close();
    }
}

// Time Complexity: O(n)
// Additional Space: O(1)
// In-place modification uses the original array without another array.
