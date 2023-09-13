package questions.binary_tree.s315;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static class Pair {
        int id, val;

        public Pair(int id, int val) {
            this.id=id;
            this.val=val;
        }
    }
    private static Pair[] tmp;
    private static int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        tmp=new Pair[n];
        count=new int[n];
        Pair[] arr=new Pair[n];
        for (int i = 0; i < nums.length; i++) {
            arr[i]=new Pair(i, nums[i]);
        }
        sort(arr, 0, n-1);
        List<Integer> res = new LinkedList<>();
        for (int c : count) res.add(c);
        return res;
    }

    static void sort(Pair[] nums, int low, int high) {
        if (low==high) return;

        int mid=low+(high-low)/2;
        sort(nums, low, mid);
        sort(nums, mid+1, high);
        merge(nums, low, mid, high);
    }

    static void merge(Pair[] nums, int low, int mid, int high) {
        for (int i = low; i<=high; i++) {
            tmp[i]=nums[i];
        }

        int i=low, j=mid+1;
        for (int p = low; p <= high; p++) {
            if (i==mid+1) {
                nums[p]=tmp[j++];
            } else if (j==high+1) {
                nums[p]=tmp[i++];
                count[nums[p].id]+=j-mid-1;
            } else if (tmp[i].val<=tmp[j].val) {
                nums[p]=tmp[i++];
                count[nums[p].id]+=j-mid-1;
            } else if (tmp[j].val<tmp[i].val) {
                nums[p]=tmp[j++];
            }
        }
    }
}
