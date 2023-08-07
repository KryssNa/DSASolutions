package Exam;

public class max_profit {
    // you are given an array prices where prices[i] is the price of a given stock on the ith day.
    // you want to maximize your profit by choosing a single day to buy one stock and choosing a
    // different day in the future to sell that stock.
    // return the maximum profit you can achieve from this transaction. if you cannot achieve any profit, return 0.
    // time complexity: O(n)
    // space complexity: O(1)
    public static int maxProfit(int[] prices) {
        int maxProfit = 0; //max profit is 0 initially
        int minPrice = Integer.MAX_VALUE; //min price is the max value of integer initially
        for(int i=0; i<prices.length; i++){
            if(prices[i]<minPrice){
                minPrice = prices[i]; //min price is the price of the stock on the ith day
            }
            else if((prices[i]-minPrice)>maxProfit){
                maxProfit = prices[i]-minPrice; //max profit is the difference between the price of the stock on the ith day and the min price
            }
        }
        return maxProfit; //return the max profit
    }

    public static void main(String[] args) {
        int[] prices = {7,6,2,3,1};
        System.out.print(maxProfit(prices));
    }

}
