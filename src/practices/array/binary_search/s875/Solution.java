package practices.array.binary_search.s875;

public class Solution {
    private static int speedToHour(int[] piles, int speed) {
        int hour=0;
        for (int pile : piles) {
            hour+=pile%speed==0 ? pile/speed : pile/speed+1;
        }
        return hour;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left=1, right=1000000000+1;
        while (left<right) {
            int mid=left+(right-left)/2;

            if (speedToHour(piles, mid)==h) {
                right=mid;
            } else if (speedToHour(piles, mid)>h) {
                left=mid+1;
            } else if (speedToHour(piles, mid)<h) {
                right=mid;
            }
        }

        return left;
    }
}
