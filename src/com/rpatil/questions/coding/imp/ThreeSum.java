package com.rpatil.questions.coding.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
    }

    /**
     * Brut-force solution: Time O(n^3) and Space O(n)
     *
     * @param nums   input array
     * @param target target sum to be achieved, is always 0 in this problem
     * @return List of Integer List, containing the triplets [nums[i], nums[j], nums[k]] in each list
     */
    public static List<List<Integer>> threeSumBrutForce(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == target) {
                        List<Integer> list = Stream.of(nums[i], nums[j], nums[k]).sorted().toList();
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
     * Brut-force solution: Time O(n^3) and Space O(n)
     *
     * @param nums   input array
     * @param target target sum to be achieved, is always 0 in this problem
     * @return List of Integer List, containing the triplets [nums[i], nums[j], nums[k]] in each list
     */
    public static List<List<Integer>> threeSumHashMap(int[] nums, int target) {
        return null;
    }
}
