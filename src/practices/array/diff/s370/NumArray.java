package practices.array.diff.s370;

import java.util.Arrays;

class Difference {
    private int[] diff;

    public Difference(int[] nums) {
        diff=new int[nums.length];
        diff[0]=nums[0];

        for (int i = 1; i < diff.length; i++) {
            diff[i]=nums[i]-nums[i-1];
        }
    }

    public void increment(int i, int j, int val) {
        diff[i]+=val;

        if (j+1<diff.length) diff[j+1]-=val;
    }

    public int[] useArray() {
        int [] array = new int[diff.length];
        array[0]=diff[0];

        for (int i = 1; i < diff.length; i++) {
            array[i]=array[i-1]+diff[i];
        }

        return array;
    }
}

public class NumArray {
    static int[] getModifiedArray(int length, int[][] updates) {
        Difference difference = new Difference(new int[length]);

        for (int[] update : updates) {
            difference.increment(update[0], update[1], update[2]);
        }

        return difference.useArray();
    }

    public static void main(String[] args) {
        int[][] test = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};

        System.out.println(Arrays.toString(getModifiedArray(5, test)));
    }
}
