public class ReverseWordsInStringIII {
    public static String reverseWords(String s) {
        String[] splittedString = s.split(" ");

        for (int i = 0; i < splittedString.length; i++) {
            int left = 0;
            int right = splittedString[i].length() - 1;

            char[] curWord = splittedString[i].toCharArray();
            while (left < right) {
                char tmp = curWord[left];

                curWord[left] = curWord[right];
                curWord[right] = tmp;

                left++;
                right--;
            }

            splittedString[i] = new String(curWord);
        }

        return String.join(" ", splittedString);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("Mr Ding"));
    }
}
