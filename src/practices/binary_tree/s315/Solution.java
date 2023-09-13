package practices.binary_tree.s315;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int[] index, tmpIndex, res;

    public List<Integer> countSmaller(int[] nums) {
        int len=nums.length;
        index=new int[len];
        tmpIndex=new int[len];
        res=new int[len];
        for (int i=0; i<len; i++) index[i]=i;

        sort(nums, 0, len-1);
        List<Integer> ans=new LinkedList<>();

        for (Integer count: res) ans.add(count);
        return ans;
    }

    private void sort(int[] nums, int low, int high) {
        if (low==high) return;

        int mid=low+(high-low)/2;
        sort(nums, low, mid);
        sort(nums, mid+1, high);

        merge(nums, low, mid, high);
    }
    private void merge(int[] nums, int low, int mid, int high) {
        for (int i=low; i<=high; i++) tmpIndex[i]=index[i];

        int i=low, j=mid+1;
        for (int p=low; p<=high; p++) {
            if (i>mid) {
                index[p]=tmpIndex[j++];
            } else if (j>high) {
                index[p]=tmpIndex[i++];
                res[index[p]]+=j-mid-1;
            } else if (nums[tmpIndex[i]]>nums[tmpIndex[j]]) {
                index[p]=tmpIndex[j++];
            } else {
                index[p]=tmpIndex[i++];
                res[index[p]]+=j-mid-1;
            }
        }
    }
}
