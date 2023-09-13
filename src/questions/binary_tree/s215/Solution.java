package questions.binary_tree.s215;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low=0, high=nums.length-1;
        k=nums.length-k;
        while (low<=high) {
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

    int partition(int[] nums, int low, int high) {
        int random= ThreadLocalRandom.current().nextInt(high-low+1)+low;

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

    void swap(int[] nums, int i, int j) {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
