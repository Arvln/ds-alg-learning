package questions.binary_tree.s912;

import java.util.Random;

public class Solution2 {
    private static class Quick {
        static void sort(int[] nums) {
            sort(nums, 0, nums.length-1);
        }

        static void sort(int[] nums, int low, int high) {
            if (low>=high) return;

            int p=partition(nums, low, high);

            sort(nums, low, p-1);
            sort(nums, p+1, high);
        }

        int findKthLargest(int[] nums, int k) {
            int low=0, high=nums.length-1;
            k=nums.length-k;
            while (low>=high) {
                int p=partition(nums, low, high);

                if (p<k) {
                    low=p+1;
                } else if (p>k) {
                    high=p-1;
                } else {
                    return nums[p];
                }
            }
            return -1;
        }

        static int partition(int[] nums, int low, int high) {
            int random=new Random().nextInt(high-low+1)+low;
            swap(nums, low, random);

            int i=low, j=high, pivot=nums[low];
            while (i<j) {
                while (i<j && nums[j]>pivot) j--;
                while (i<j && nums[i]<=pivot) i++;

                swap(nums, i, j);
            }
            swap(nums, low, i);
            return i;
        }

        static void swap(int[] nums, int i, int j) {
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
    }

    public int[] sortArray(int[] nums) {
        Quick.sort(nums);
        return nums;
    }
}
