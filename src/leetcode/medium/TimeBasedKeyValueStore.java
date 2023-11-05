package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class TimeBasedKeyValueStore {

    static class TimeMap {

        static class Value {
            String val;
            int time;

            public Value(String val, int time) {
                this.val = val;
                this.time = time;
            }
        }

        final HashMap<String, List<Value>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<Value> list = new ArrayList();
            if (map.containsKey(key)) {
                list = map.get(key);
                if (Objects.equals(list.get(list.size() - 1).val, value)) {
                    Value val = list.remove(list.size() - 1);
                    val.time = timestamp;
                    list.add(val);
                } else {
                    list.add(new Value(value, timestamp));
                }
            } else {
                list.add(new Value(value, timestamp));
            }
            map.put(key, list);
        }

        public String get(String key, int timestamp) {
            if (map.containsKey(key)) {
                List<Value> list = map.get(key);
                int left = 0;
                int right = list.size() - 1;
                if (list.get(left).time > timestamp) {
                    return "";
                }
                if (list.get(right).time < timestamp) {
                    return list.get(right).val;
                }
                String ans = "";
                while (left <= right) {
                    int mid = (left + right) >>> 1;
                    if (list.get(mid).time == timestamp) {
                        return list.get(mid).val;
                    } else if (list.get(mid).time < timestamp) {
                        ans =  list.get(left).val;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                return ans;
            } else {
                return "";
            }
        }
    }

    public static void main(String[] args) {
        TimeMap time = new TimeMap();
        time.set("love", "high", 10);
        time.set("love", "low", 20);
        System.out.println(time.get("love", 5));
        System.out.println(time.get("love", 10));
        System.out.println(time.get("love", 15));
        System.out.println(time.get("love", 20));
        System.out.println(time.get("love", 25));
    }
}
