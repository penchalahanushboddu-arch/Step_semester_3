
import java.util.Scanner;
import java.util.Arrays;

public class DutyRosterRotation {

    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n;

        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        int k = sc.nextInt();

        String[] result = rotateRoster(names, k);

        System.out.println(Arrays.toString(result));

        sc.close();
    }
}

// Time Complexity: O(n)
// Additional Space: O(n)
// Rotating one place at a time k times takes O(n * k) time,
// which is slow when k is very large.
