public class DecodeWays {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int prev = 1;
        int curr = 1;

        for (int i = 1; i < n; i++) {
            int temp = 0;

            if (s.charAt(i) != '0') {
                temp += curr;
            }

            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (10 <= twoDigit && twoDigit <= 26) {
                temp += prev;
            }

            prev = curr;
            curr = temp;

            if (curr == 0) {
                return 0;
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();

        System.out.println(dw.numDecodings("06"));
    }
}
