package com.rpatil.questions.coding.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * <h1>15. <a href="https://leetcode.com/problems/3sum/">Three Sum</a></h1>
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        System.out.println(threeSumBrutForce(nums, target));
        System.out.println();
        System.out.println(threeSumHashMap(nums, target));
        System.out.println();
        System.out.println(threeSum(nums, target));
        System.out.println("\n");

        nums = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        // Answer:  [[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
        System.out.println(threeSumBrutForce(nums, target));
        System.out.println();
        System.out.println(threeSumHashMap(nums, target));
        System.out.println();
        System.out.println(threeSum(nums, target));
        System.out.println("\n");
    }

    /**
     * Brut-force solution: Time O(n^3) and Space O(n)
     *
     * @param nums   input array
     * @param target target sum to be achieved, is always 0 in this problem
     * @return List of Integer List, containing the triplets [nums[i], nums[j],
     *         nums[k]] in each list
     */
    public static List<List<Integer>> threeSumBrutForce(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Corner case validation
        if (nums == null || nums.length < 3) {
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i == j || i == k || j == k) {
                        // To avoid duplicate indices
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == target) {
                        List<Integer> list = Stream.of(nums[i], nums[j], nums[k]).sorted().toList();
                        // To avoid duplicate numbers, sort and add only unique numbers
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * HashMap solution: Time O(n^2) and Space O(n^2)
     * Since we are saving all the pairs of [target - (nums[i] + nums[j])] space complexity is n^2
     *
     * @param nums   input array
     * @param target target sum to be achieved, is always 0 in this problem
     * @return List of Integer List, containing the triplets [nums[i], nums[j],
     *         nums[k]] in each list
     */
    public static List<List<Integer>> threeSumHashMap(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Corner case validation
        if (nums == null || nums.length < 3) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            map.put(i, complement);
        }
        for (int j = 0; j < nums.length - 1; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                int complement = nums[j] + nums[k];
                if (map.containsValue(complement)) {
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        Integer key = entry.getKey();
                        Integer value = entry.getValue();
                        if (value == complement && key != j && key != k && j != k) {
                            List<Integer> list = Stream.of(nums[key], nums[j], nums[k]).sorted().toList();
                            if (!result.contains(list)) {
                                result.add(list);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Two pointer solution: Time O(n^2) and Space O(n)
     * Note: This solution works only with Sorted arrays
     *
     * @param nums   input array
     * @param target target sum to be achieved
     * @return indices of the two numbers such that they add up to target, else return null
     */
    public static List<List<Integer>> threeSumTwoPointers(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Corner case validation
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int newTarget = target - nums[i];
            List<Integer[]> twoSum = twoSumTwoPointers(nums, i + 1, newTarget);
            if (!twoSum.isEmpty()) {
                for (Integer[] pair : twoSum) {
                    List<Integer> threeSum = Stream.of(nums[i], nums[pair[0]], nums[pair[1]]).toList();
                    if (!result.contains(threeSum)) {
                        result.add(threeSum);
                    }
                }
            }
        }
        return result;
    }

    private static List<Integer[]> twoSumTwoPointers(int[] nums, int start, int target) {
        List<Integer[]> result = new ArrayList<>();
        // Corner case validation
        if (nums == null || nums.length < 2) {
            return result;
        }
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                result.add(new Integer[]{start, end});
                start++;
                end--;
                continue;
            }
            if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            }
        }
        return result;
    }

    /**
     * Two pointer solution: Time O(n^2) and Space O(n)
     * Note: This solution works only with Sorted arrays
     *
     * @param nums   input array
     * @param target target sum to be achieved
     * @return indices of the two numbers such that they add up to target, else return null
     */
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        // Corner case validation
        if (nums == null || nums.length < 2) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {
                int start = i + 1;
                int end = nums.length - 1;
                int sum = target - nums[i];

                while (start < end) {
                    if (nums[start] + nums[end] == sum) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        start++;
                        end--;
                    } else if (nums[start] + nums[end] < sum) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return result;
    }
}
