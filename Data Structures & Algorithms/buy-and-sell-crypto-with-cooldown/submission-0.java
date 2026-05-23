class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
        
    }
    public int dfs(int index, boolean buying, int [] prices){
        if (index >= prices.length){
            return 0;
        }

        String key = index + "-" + buying;
        if (dp.containsKey(key)){
            return dp.get(key);
        }
        int cooldown = dfs(index+1, buying, prices);
        if (buying){
            int buy = dfs(index + 1, false, prices ) - prices[index];
            dp.put(key,Math.max(buy, cooldown));
        }else{
            int sell = dfs(index+2, true, prices) + prices[index];
            dp.put(key,Math.max(sell, cooldown));
        }

        return dp.get(key);
    }
}
