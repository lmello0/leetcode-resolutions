public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0;
        int right = s.length() - 1;

        char[] sCharArray = s.toCharArray();

        while (left < right) {
            if (sCharArray[left] != sCharArray[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindrome2(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }

        String text = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0;
        int right = text.length() -1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome2("race a car"));
    }
}
