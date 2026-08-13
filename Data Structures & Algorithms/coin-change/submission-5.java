class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[10000];
        if (amount == 0) {
            return 0;
        }
        Arrays.fill(cache, 0);
        minCoin(coins, amount, cache);
        if (cache[amount] == 0) {
            return -1;
        }
        return cache[amount];
    }

    private int minCoin(int[] coins, int amount, int[] cache) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }
        if (cache[amount] != 0) {
            return cache[amount];
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            int mincoin = minCoin(coins, amount - coins[i], cache);
            if (mincoin == -1) {
                continue;
            }
            if (cache[amount] == 0) {
                cache[amount] = 1 + mincoin;
            } else {
                cache[amount] = Math.min(1 + mincoin, cache[amount]);
            }
        }
        if(cache[amount]==0){
            cache[amount]=-1;
        }
        return cache[amount];
    }
}
