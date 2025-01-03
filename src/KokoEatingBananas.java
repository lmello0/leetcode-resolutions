import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles)
                .max()
                .orElse(0);

        int res = right;

        while (left <= right) {
            int k = (left + right) / 2;
            int hours = 0;

            for (int p : piles) {
                hours += Math.ceil((double) p / k);
            }

            if (hours <= h) {
                res = Math.min(res, k);
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        KokoEatingBananas keb = new KokoEatingBananas();

        System.out.println(keb.minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
}
