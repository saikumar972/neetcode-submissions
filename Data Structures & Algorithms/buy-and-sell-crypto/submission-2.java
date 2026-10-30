class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int right = 1;
        int left = 0;
        while(right<prices.length) {
            int price = prices[right] - prices[left];
            max = Math.max(price, max);
            if(prices[left]>prices[right]) {
                left = right;
            }
            right++;
        }
        return max;
    }
}
