class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int [coins.length + 1][amount+1];
       
       for (int [] d : dp){
        Arrays.fill(d, -1);
       }
        Arrays.sort(coins);
        return dfs(amount, coins, 0, dp);

        
    }
    public int dfs(int amount, int [] coins, int index, int [][] dp){
        if (amount == 0){
            return 1;
        }
        if (dp[index][amount] != -1){
            return dp[index][amount];
        }

        if (index >= coins.length){
            return 0;
        }

        int res = 0;
        if (amount >= coins[index]){
            res = dfs(amount, coins, index+1, dp);
            res += dfs(amount-coins[index], coins, index, dp);
        }

        return dp[index][amount] = res;

    }
}
