package practices.array.sliding_window.s658;

import java.util.*;

public class Solution {
    private static int findLeftMostIndex(int[] arr, int x) {
        int left=0, right=arr.length;
        while (left<right) {
            int mid = left + (right-left) / 2;

            if (arr[mid]==x) {
                right=mid;
            } else if (arr[mid]<x) {
                left=mid+1;
            } else if (arr[mid]>x) {
                right=mid;
            }
        }

        return left;
    }

    public static List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int i = findLeftMostIndex(arr, x);
        LinkedList<Integer> result = new LinkedList<>();

        int left=i-1, right=i;
        while (result.size()<k) {
            if (left==-1) {
                result.addLast(arr[right]);
                right++;
            } else if (right==arr.length) {
                result.addFirst(arr[left]);
                left--;
            } else if (x-arr[left]<=arr[right]-x) {
                result.addFirst(arr[left]);
                left--;
            } else {
                result.addLast(arr[right]);
                right++;
            }
        }

        return result;
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> result = new LinkedList<>();

        int left=0, right=0;
        while (right-left<k) {
            result.addLast(arr[right]);
            right++;

            if (right<arr.length && right-left==k && x-arr[left]>arr[right]-x) {
                result.removeFirst();
                left++;
            }
        }

        return result;
    }

    /**
     * 给定一个 排序好 的数组arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。
     * 返回的结果必须要是按升序排好的。
     * 整数 a 比整数 b 更接近 x 需要满足：
     *  - |a - x| < |b - x| 或者
     *  - |a - x| == |b - x| 且 a < b
     *
     * tips
     * 1, 子串問題可用滑窗
     * 2, 右界在right-left<k時右移，左界在right-left==k且x到右界小於x到左界時右移
     * 3, x到右界等於x到左界時，左界不可右移因為題目判定此情形下左界元素比右界元素更接近x
     *
     * */
}
