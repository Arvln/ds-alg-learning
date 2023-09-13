package practices.array.diff.s1094;

class Difference {
    private int[] diff;

    public Difference(int[] nums) {
        diff=new int[nums.length];
        diff[0]=nums[0];

        for (int i = 1; i < diff.length; i++) {
            diff[i]=nums[i]-nums[i-1];
        }
    }

    public void increment(int i,int j, int val) {
        diff[i]+=val;

        if (j+1<diff.length) diff[j+1]-=val;
    }

    public int[] useArray() {
        int[] array = new int[diff.length];
        array[0]=diff[0];

        for (int i = 1; i < diff.length; i++) {
            array[i]=array[i-1]+diff[i];
        }

        return array;
    }
}

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Difference difference = new Difference(new int[1000 + 1]);

        for (int[] trip : trips) {
            difference.increment(trip[1], trip[2]-1, trip[0]);
        }

        int[] numPassengers = difference.useArray();
        for (int numPassenger : numPassengers) {
            if (numPassenger>capacity) return false;
        }
        return true;
    }
}
