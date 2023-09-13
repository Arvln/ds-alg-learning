package questions.array.s187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<String> slowFindRepeatedDnaSequences(String s) {
        HashSet<String> wordRecords = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        for (int i = 0; i < s.toCharArray().length - 9; i++) {
            String current = s.substring(i, i + 10);

            if (wordRecords.contains(current)) {
               result.add(current);
            } else {
                wordRecords.add(current);
            }
        }

        return new ArrayList<>(result);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        int[] nums = new int[s.length()];

        for (int i = 0; i < nums.length; i++) {
            switch (s.charAt(i)) {
                case 'A':
                    nums[i] = 0;
                    break;
                case 'C':
                    nums[i] = 1;
                    break;
                case 'G':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }

        HashSet<Integer> wordHash = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        int left=0, right=0, hash=0;
        while (right<s.length()) {
            hash = 4 * hash + nums[right];
            right++;

            if (right-left == 10) {
                if (wordHash.contains(hash)) {
                    result.add(s.substring(left, right));
                } else {
                    wordHash.add(hash);
                }

                hash = hash - nums[left] * (int) Math.pow(4, 9);
                left++;
            }
        }

        return new ArrayList<>(result);
    }

    private static int searchStartIndex(String text, String target) {
        long targetHash = 0;
        long Q = 1658598167;

        for (int i=0; i < target.length(); i++) {
            targetHash = ((targetHash * 256) % Q + target.charAt(i)) % Q;
        }

        int left=0, right=0;
        long hash=0;
        while (right<text.length()) {
            hash = ((256 * hash) % Q + text.charAt(right)) % Q;
            right++;

            if (right-left == target.length()) {
                if (hash == targetHash && target.equals(text.substring(left, right))) {
                    return left;
                }

                hash = (hash - (text.charAt(left) * (long) Math.pow(256, target.length()-1)) % Q + Q) % Q;
                left++;
            }
        }

        return -1;
    }
}
