public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 0;

        int maxProfit = 0;

        while (right < prices.length) {
            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);

            if (prices[right] < prices[left]) {
                left = right;
            }

            right++;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

        System.out.println(bestTimeToBuyAndSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2}));
    }
}
