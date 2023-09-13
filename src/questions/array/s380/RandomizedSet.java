package questions.array.s380;

import java.util.*;

public class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> valueToIndex;

    public RandomizedSet() {
        nums = new ArrayList<>();
        valueToIndex = new HashMap<>();
    }

    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) return false;

        nums.add(val);
        valueToIndex.put(val, nums.size()-1);
        return true;
    }

    private void swap(int a, int b) {
        Integer tmp = nums.get(a);

        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }

    public boolean remove(int val) {
        if (!valueToIndex.containsKey(val)) return false;

        int index = valueToIndex.get(val);
        valueToIndex.put(nums.get(nums.size()-1), index);
        valueToIndex.remove(val);
        swap(index, nums.size()-1);
        nums.remove(nums.size()-1);
        return true;
    }

    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
