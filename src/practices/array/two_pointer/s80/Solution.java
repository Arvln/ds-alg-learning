package practices.array.two_pointer.s80;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        int slow=0, fast=0, count=0;
        while (fast<nums.length) {
            if (slow<fast && count<2) {
                slow++;
                nums[slow]=nums[fast];
            }

            count++;
            fast++;
            if (fast<nums.length && nums[fast]!=nums[fast-1]) count=0;
        }

        return slow+1;
    }

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度
     *
     * tips
     * 1, 刪除重複項需要一個計數器，依照計數器當前數值來執行對應操作
     * 2, slow在元素出現次數小於2或fast發現不同元素時修改數組，當fast發現新元素時計數器歸零
     * 3, 總數大於1即為重複可右移左界
     * 4, 每次右移右界更新結果
     *
     * */
}
