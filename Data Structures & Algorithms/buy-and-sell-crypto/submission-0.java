class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++){
            if (buyPrice > prices[i]){
                buyPrice = prices[i];
            }

            maxprofit = Math.max(maxprofit, prices[i] - buyPrice);

        }
        return maxprofit;
    }
}
