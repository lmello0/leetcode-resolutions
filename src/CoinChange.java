import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? (int) dp[amount] : -1;
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();

        System.out.println(cc.coinChange(new int[]{2}, 3));
    }
}
