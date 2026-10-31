
import java.util.Scanner;

public class BestSingleTradeProfit {

    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }

            int profit = price - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println(maxProfit(prices));

        sc.close();
    }
}

// Single-pass Time Complexity: O(n)
// Single-pass Additional Space: O(1)
// Checking every pair: O(n^2) time.
