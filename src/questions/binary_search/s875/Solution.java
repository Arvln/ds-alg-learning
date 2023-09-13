package questions.binary_search.s875;

public class Solution {
    private static int f(int x, int[] piles) {
        int totalCost = 0;
        for (int pile : piles) {
            totalCost += pile / x;
            if (pile % x != 0) totalCost++;
        }
        return totalCost;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1; int right = 1000000000 + 1;
        int target = h;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (f(mid, piles) == target) {
                right = mid;
            } else if (f(mid, piles) < target) {
                right = mid;
            } else if (f(mid, piles) > target) {
                left = mid + 1;
            }
        }

        return left;
    }
}
