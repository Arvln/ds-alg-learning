package hash_table;

public class Practice {
    public static int[] twoSum(int[] sums, int target) {
        HashTable map = new HashTable();

        for (int i = 0; i < sums.length; i++) {
            int current = sums[i];
            int pair = target - current;

            if (map.get(pair) == null) {
                map.put(current, i);
            } else {
                return new int[]{(int) map.get(pair), i};
            }
        }
        return null;
    }

    public static int lengthOfLongestSubstring(String s) {
        int begin = 0;
        int maxLengthOfSubstring = 0;
        HashTable map = new HashTable();

        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);

            if (map.get(current) != null) {
                begin = Math.max(begin, (int) map.get(current) + 1);
            }

            map.put(current, end);
            maxLengthOfSubstring = Integer.max(maxLengthOfSubstring, end - begin + 1);
        }

        return maxLengthOfSubstring;
    }

    public static boolean hasRedundant(int[] nums) {
        HashTable map = new HashTable();

        for (int num: nums) {
            if (map.get(num) == null) {
                map.put(num, true);
            } else {
                return true;
            }
        }

        return false;
    }

    public static int findUnique(int[] nums) {
        HashTable map = new HashTable();
        int result = 0;

        for (int num: nums) {
            if (map.get(num) == null) {
                map.put(num, num);
                result = result + num;
            } else {
                result = result - num;
            }
        }

        return result;
    }
}
