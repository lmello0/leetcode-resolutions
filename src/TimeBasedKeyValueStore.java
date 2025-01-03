import java.util.*;

public class TimeBasedKeyValueStore {
    private static class Item {
        String value;
        int timestamp;

        public Item(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public static class TimeMap {

        private final Map<String, List<Item>> map;

        public TimeMap() {
            this.map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<Item> items = map.getOrDefault(key, new ArrayList<>());

            items.add(new Item(value, timestamp));

            map.put(key, items);
        }

        public String get(String key, int timestamp) {
            String res = "";
            List<Item> items = map.get(key);

            if (items == null) {
                return res;
            }

            int left = 0;
            int right = items.size() - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                Item i = items.get(mid);
                if (i.timestamp <= timestamp) {
                    res = i.value;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();

        timeMap.set("test", "one", 10);
        timeMap.set("test", "two", 20);
        timeMap.set("test", "three", 30);

        System.out.println(timeMap.get("test", 15));
        System.out.println(timeMap.get("test", 25));
        System.out.println(timeMap.get("test", 35));
    }
}
