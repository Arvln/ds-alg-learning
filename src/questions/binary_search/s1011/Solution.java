package questions.binary_search.s1011;

public class Solution {
    private static int loadingToDays(int[] weights, int loadings) {
        int dayLoading=0;
        int days=0;
        for (int weight : weights) {
            if (weight>loadings) return weights.length+1;
            if (dayLoading-weight<0) {
                dayLoading=loadings;
                days++;
            }
            dayLoading-=weight;
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int left=1, right=5*(int)Math.pow(10, 4)*500+1;
        while (left<right) {
            int mid = left+(right-left)/2;

            if (loadingToDays(weights, mid)==days) {
                right=mid;
            } else if (loadingToDays(weights, mid)<days) {
                right=mid;
            } else if (loadingToDays(weights, mid)>days) {
                left=mid+1;
            }
        }

        return left;
    }
}
