package questions.backtrack.s698;

import java.util.Arrays;

public class Solution {
    public boolean canPartitionKSubsetsByBall(int[] nums, int k) {
        if (k>nums.length) return false;

        int sum=0;
        for (int num : nums) sum+=num;
        if (sum%k!=0) return false;

        Arrays.sort(nums);
        for (int i=0, j=nums.length-1; i<j; i++, j--) {
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
        return canPartitionKSubsets(nums, new int[k], 0, sum/k);
    }

    private boolean canPartitionKSubsets(int[] nums, int[] bucket, int index, int target) {
        if (index==nums.length) return true;

        for (int i=0; i<bucket.length; i++) {
            if (i>0&&bucket[i]==bucket[i-1]) continue;
            if (bucket[i]+nums[index]>target) continue;

            bucket[i]+=nums[index];
            if (canPartitionKSubsets(nums, bucket, index+1, target)) return true;
            bucket[i]-=nums[index];
        }
        return false;
    }

    public boolean canPartitionKSubsetsByBucket(int[] nums, int k) {
        if (k>nums.length) return false;

        int sum=0;
        for (int num : nums) sum+=num;
        if (sum%k!=0) return false;

        Arrays.sort(nums);
        for(int i=0, j=nums.length-1; i<j; i++, j--) {
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
        return canPartitionKSubsets(nums, new boolean[nums.length], k, 0, 0, sum/k);
    }

    private boolean canPartitionKSubsets(int[] nums, boolean[] used, int k, int start, int bucket, int target) {
        if (k==0) return true;
        if (bucket==target) {
            return canPartitionKSubsets(nums, used, k-1, 0, 0, target);
        }

        for (int i=start; i<nums.length; i++) {
            if (used[i]) continue;
            if (bucket+nums[i]>target) continue;

            bucket+=nums[i];
            used[i]=true;
            if (canPartitionKSubsets(nums, used, k, i+1, bucket, target)) return true;
            bucket-=nums[i];
            used[i]=false;
            while(i+1<nums.length&&nums[i+1]==nums[i]) i++;
        }
        return false;
    }
}
