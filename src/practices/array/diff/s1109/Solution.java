package practices.array.diff.s1109;

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
        int[] array = new int[diff.length];
        array[0]=diff[0];

        for (int i = 1; i < diff.length; i++) {
            array[i]=array[i-1]+diff[i];
        }

        return array;
    }
}

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        Difference difference = new Difference(new int[n]);

        for (int[] booking : bookings) {
            difference.increment(booking[0]-1, booking[1]-1, booking[2]);
        }

        return difference.useArray();
    }
}
