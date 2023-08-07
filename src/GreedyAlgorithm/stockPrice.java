package GreedyAlgorithm;

public class stockPrice {
    // stock price problem using greedy algorithm

    static void stockPrice(int[] arr, int n) {
        int i = 0;
        while (i < n - 1) {
            while ((i < n - 1) && (arr[i + 1] <= arr[i])) {
                i++;
            }
            if (i == n - 1) {
                break;
            }
            int buy = i++;
            while ((i < n) && (arr[i] >= arr[i - 1])) {
                i++;
            }
            int sell = i - 1;
            System.out.println("Buy on day: " + buy + "\t" + "Sell on day: " + sell);
        }
    }

    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        int n = arr.length;
        stockPrice(arr, n);
    }
}
