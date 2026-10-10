
import java.util.Scanner;

public class SecondBestScore {

    static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.println(secondHighest(scores));

        sc.close();
    }
}

// Time Complexity: O(n)
// Additional Space: O(1)
// Sorting first takes O(n log n) time, while this solution
// finds the second-highest distinct score in one pass.
