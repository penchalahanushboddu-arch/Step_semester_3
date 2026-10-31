
import java.util.Scanner;
import java.util.Arrays;

public class DiceThrowTally {

    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        // Count the occurrences of each dice value
        for (int roll : rolls) {
            count[roll]++;
        }

        // Print the counts
        System.out.print("Counts: ");
        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + count[i] + " ");
        }
        System.out.println();

        // Build the sorted array using the counts
        int[] result = new int[rolls.length];
        int index = 0;

        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < count[i]; j++) {
                result[index++] = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] rolls = new int[n];

        for (int i = 0; i < n; i++) {
            rolls[i] = sc.nextInt();
        }

        int[] sorted = diceSort(rolls);

        System.out.println("Sorted: " + Arrays.toString(sorted));

        sc.close();
    }
}

// Sorting Algorithm: Counting Sort
// Time Complexity: O(n + 6) = O(n)
// Additional Space: O(n + 7) = O(n)
// No comparisons between individual dice throws.
