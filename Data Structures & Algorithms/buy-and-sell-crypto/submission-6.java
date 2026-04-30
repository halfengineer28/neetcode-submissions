class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0; int l = 0;
        int r = 1;
        while( r < prices.length){
            if (prices[l] < prices[r]){
                int  profit = prices[r]- prices[l];
                maxprofit = Math.max(maxprofit , profit);
            }else{
                l = r;
            }
            r++;
        }
        return maxprofit;
    }
}
