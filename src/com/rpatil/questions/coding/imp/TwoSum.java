package com.rpatil.questions.coding.imp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>1. <a href="https://leetcode.com/problems/two-sum/">Two Sum</a></h1>
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSumBrutForce(nums, target)));
        System.out.println(Arrays.toString(twoSumHashMap(nums, target)));
        System.out.println(Arrays.toString(twoSumTwoPointers(nums, target)));
        System.out.println();

        nums = new int[]{3, 2, 4};
        target = 6;
        System.out.println(Arrays.toString(twoSumBrutForce(nums, target)));
        System.out.println(Arrays.toString(twoSumHashMap(nums, target)));
        nums = new int[]{2, 3, 4}; // to make it sorted
        System.out.println(Arrays.toString(twoSumTwoPointers(nums, target)));
        System.out.println();

        nums = new int[]{3, 3};
        System.out.println(Arrays.toString(twoSumBrutForce(nums, target)));
        System.out.println(Arrays.toString(twoSumHashMap(nums, target)));
        System.out.println(Arrays.toString(twoSumTwoPointers(nums, target)));
        System.out.println();
    }

    /**
     * Brut-force solution: Time O(n^2) and Space O(1)
     *
     * @param nums   input array
     * @param target target sum to be achieved
     * @return indices of the two numbers such that they add up to target, else return null
     */
    public static int[] twoSumBrutForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * HashMap solution: Time O(n) and Space O(n)
     *
     * @param nums   input array
     * @param target target sum to be achieved
     * @return indices of the two numbers such that they add up to target, else return null
     */

    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * Two pointer solution: Time O(n) and Space O(1)
     * Note: This solution works only with Sorted arrays
     *
     * @param nums   input array
     * @param target target sum to be achieved
     * @return indices of the two numbers such that they add up to target, else return null
     */
    public static int[] twoSumTwoPointers(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return new int[]{start, end};
            }
            if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            }
        }
        return null;
    }
}
