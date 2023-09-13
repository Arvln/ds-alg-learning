package practices.array.binary_search.s793;

public class Solution {
    public static long f(long x) {
        long res=0, divisor=5;
        while(divisor<=x) {
            res+=x/divisor;
            divisor*=5;
        }
        return res;
    }

    private static long leftBound(int k) {
        long left=0, right=Long.MAX_VALUE;
        while(left<right) {
            long mid=left+(right-left)/2;

            if (f(mid)==k) {
                right=mid;
            } else if (f(mid)<k) {
                left=mid+1;
            } else if (f(mid)>k) {
                right=mid;
            }
        }
        return left;
    }

    private static long rightBound(int k) {
        long left=0, right=Long.MAX_VALUE;
        while(left<right) {
            long mid=left+(right-left)/2;

            if (f(mid)==k) {
                left=mid+1;
            } else if (f(mid)<k) {
                left=mid+1;
            } else if (f(mid)>k) {
                right=mid;
            }
        }
        return left-1;
    }

    public int preimageSizeFZF(int k) {
        return (int)(rightBound(k)-leftBound(k)+1);
    }
}
