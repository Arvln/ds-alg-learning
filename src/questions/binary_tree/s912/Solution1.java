package questions.binary_tree.s912;


public class Solution1 {
    private static class Merge {
        private static int[] tmp;
        static void sort(int[] nums) {
            tmp=new int[nums.length];
            sort(nums, 0, nums.length-1);
        }

        static void sort(int[] nums, int low, int high) {
            if (low==high) return;

            int mid=low+(high-low)/2;
            sort(nums, low, mid);
            sort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }

        static void merge(int[] nums, int low, int mid, int high) {
            for (int i = low; i <= high; i++) {
                tmp[i]=nums[i];
            }

            int i=low, j=mid+1;
            for (int p = low; p <= high; p++) {
                if (i==mid+1) {
                    nums[p]=tmp[j++];
                } else if (j==high+1) {
                    nums[p]=tmp[i++];
                } else if (tmp[j]<tmp[i]) {
                    nums[p]=tmp[j++];
                } else if (tmp[i]<=tmp[j]) {
                    nums[p]=tmp[i++];
                }
            }
        }
    }

    public int[] sortArray(int[] nums) {
        Merge.sort(nums);
        return nums;
    }
}
