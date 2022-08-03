package com.rpatil.questions.coding.imp;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>1. <a href="https://leetcode.com/problems/two-sum/">Two Sum</a></h1>
 */
public class TwoSum {

    /**
     * Brut-force solution: Time O(n^2) and Space O(1)
     *
     * @param nums   input array
     * @param target target sum to be achieved
     * @return indices of the two numbers such that they add up to target, else return null
     */
    public static int[] twoSumBrutForce(int[] nums, int target) {
        // Since the nested loop will start from (i+1)th index,
        // the outer loop should end when index is nums.length - 1
        for (int i = 0; i < nums.length - 1; i++) {
            // Form a pair with each index of i, starting with (i + 1)
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
            // Get the complement, i.e. number to achieve the given target sum with current number nums[i].
            int complement = target - nums[i];
            // Check if we have already saved the complement number in our map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            // Add current number and its index to the map
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
        // Set the start index and end index values of the sorted array
        int start = 0;
        int end = nums.length - 1;
        // When start and end indices becomes equal, we know there is no pair found with target sum.
        while (start < end) {
            int sum = nums[start] + nums[end];
            // If sum is equal to target, i.e. if pair is found with target sum return it
            if (sum == target) {
                return new int[]{start, end};
            }
            // If sum is less than target, then we need to move forward in the array to try bigger element,
            // i.e. increment the start index else decrement the end index to try the smaller value in the sorted array.
            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return null;
    }
}
