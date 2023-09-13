package practices.binary_tree.s912;

import java.util.Random;

class Merge {
    private static int[] tmp;

    public static int[] sortArray(int[] nums) {
        tmp=new int[nums.length];
        sort(nums, 0, nums.length-1);
        return nums;
    }

    private static void sort(int[] nums, int low, int high) {
        if (low==high) return;

        int mid = low+(high-low)/2;
        sort(nums, low, mid);
        sort(nums, mid+1, high);

        merge(nums, low, mid, high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        for (int i=low; i<=high; i++) {
            tmp[i]=nums[i];
        }

        int i=low, j=mid+1;
        for (int p=low; p<=high; p++) {
            if (i==mid+1) {
                nums[p]=tmp[j++];
            } else if (j==high+1) {
                nums[p]=tmp[i++];
            } else if (tmp[i]>tmp[j]) {
                nums[p]=tmp[j++];
            } else {
                nums[p]=tmp[i++];
            }
        }
    }
}

class Quick {
    public static int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }

    private static void sort(int[] nums, int low, int high) {
        if (low>=high) return;

        int p=partition(nums, low, high);

        sort(nums, low, p-1);
        sort(nums, p+1, high);
    }
    private static int partition(int[] nums, int low, int high) {
        int random=new Random().nextInt(high-low+1)+low;

        swap(nums, low, random);
        int i=low, j=high, root=nums[low];
        while(i<j) {
            while(i<j && nums[j]>root) j--;
            while(i<j && nums[i]<=root) i++;

            swap(nums, i, j);
        }
        swap(nums, low, i);
        return i;
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}

public class Solution {
    public int[] sortArray(int[] nums) {
        // return Merge.sortArray(nums);
        return Quick.sortArray(nums);
    }
}
