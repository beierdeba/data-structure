package com.beierdaba.algorithm;

/**
 * @author Administrator
 * @since 2020/9/12 11:51
 */
public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 5, -6, -8, 20};
        System.out.println(getMaxByKadane(a));
        System.out.println(getMaxByDp(a));
    }

    // Kadane算法
    public static int getMaxByKadane(int[] arr) {
        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < arr.length; i++) {
            thisSum += arr[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }

    //Dp
    public static int getMaxByDp(int[] nums) {
        int maxLocal = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxLocal = Math.max(nums[i], nums[i] + maxLocal);
            global = Math.max(global, maxLocal);
        }
        return global;
    }
}
