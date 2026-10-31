
import java.util.Scanner;
import java.util.Arrays;

public class HeightLineUp {

    static void lineUp(int[] heights) {
        int n = heights.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;

                    swapped = true;
                }
            }

            System.out.println("Pass " + (i + 1) + ": "
                    + Arrays.toString(heights));

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        lineUp(heights);

        sc.close();
    }
}

// Sorting Algorithm: Optimized Bubble Sort
// Time Complexity: O(n^2), Best Case: O(n)
// Additional Space: O(1)
