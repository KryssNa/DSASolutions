package Tree.HW;

public class MaximumSumSubarray {

    public static int findMaximumSumSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array is empty.");
        }

        int maxSum = nums[0]; // Initialize maxSum with the first element
        int currentSum = nums[0]; // Initialize currentSum with the first element

        for (int i = 1; i < nums.length; i++) {
            // Choose the maximum between the current element and the sum so far plus the current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update the maximum sum if the current sum is larger
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 7,2,-5,-10,5,15 };
        int maxSum = findMaximumSumSubarray(nums);
        System.out.println("Maximum Sum Subarray: " + maxSum);
    }
}
