import java.util.HashMap;
public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        // Empty prefix sum
        prefixSums.put(0, 1);
        int currentSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum + nums[i];
            int requiredSum = currentSum - k;
            if (prefixSums.containsKey(requiredSum)) {
                count = count + prefixSums.get(requiredSum);
            }
            if (prefixSums.containsKey(currentSum)) {
                prefixSums.put(currentSum, prefixSums.get(currentSum) + 1);
            } else {
                prefixSums.put(currentSum, 1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        int result = subarraySum(nums, k);
        System.out.println("Number of Subarrays: " + result);
    }
}