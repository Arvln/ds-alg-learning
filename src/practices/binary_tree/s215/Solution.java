package practices.binary_tree.s215;

import java.util.Random;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        k=nums.length-k;

        int low=0, high=nums.length-1;
        while(low<=high) {
            int p=partition(nums, low, high);

            if (p>k) {
                high=p-1;
            } else if (p<k) {
                low=p+1;
            } else {
                return nums[k];
            }
        }
        return -1;
    }

    private int partition(int[] nums, int low, int high) {
        int random=new Random().nextInt(high-low+1)+low;

        swap(nums, low, random);
        int i=low, j=high, root=nums[low];
        while (i<j) {
            while(i<j && nums[j]>root) j--;
            while(i<j && nums[i]<=root) i++;

            swap(nums, i, j);
        }
        swap(nums, low, i);
        return i;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
