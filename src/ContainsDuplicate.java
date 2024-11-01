import java.util.HashMap;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }

            map.put(num, 1 + map.getOrDefault(num, 0));
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] { 1, 2, 3, 1 }));
        System.out.println(containsDuplicate(new int[] { 1, 2, 3, 4 }));
        System.out.println(containsDuplicate(new int[] {}));
        System.out.println(containsDuplicate(new int[] { 1 }));
    }
}
