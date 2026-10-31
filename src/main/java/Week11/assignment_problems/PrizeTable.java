
import java.util.Scanner;
import java.util.Arrays;

public class PrizeTable {

    static int prizeTable(int[] marks) {
        int swaps = 0;

        for (int i = 0; i < marks.length - 1; i++) {
            int max = i;

            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[max]) {
                    max = j;
                }
            }

            if (max != i) {
                int temp = marks[i];
                marks[i] = marks[max];
                marks[max] = temp;

                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        int swaps = prizeTable(marks);

        System.out.println(Arrays.toString(marks));
        System.out.println("swaps = " + swaps);

        sc.close();
    }
}

// Sorting Algorithm: Selection Sort (Descending)
// Time Complexity: O(n^2)
// Additional Space: O(1)
