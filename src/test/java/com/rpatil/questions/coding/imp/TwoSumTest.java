package com.rpatil.questions.coding.imp;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;

public class TwoSumTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test(dataProvider = "twoSumData")
    public void testTwoSumBrutForce(int[] nums, int target, int[] expected) {
        ArrayAsserts.assertArrayEquals(TwoSum.twoSumBrutForce(nums, target), expected);
    }

    @Test(dataProvider = "twoSumData")
    public void testTwoSumHashMap(int[] nums, int target, int[] expected) {
        ArrayAsserts.assertArrayEquals(TwoSum.twoSumHashMap(nums, target), expected);
    }

    @Test(dataProvider = "twoSumDataSorted")
    public void testTwoSumTwoPointers(int[] nums, int target, int[] expected) {
        ArrayAsserts.assertArrayEquals(TwoSum.twoSumTwoPointers(nums, target), expected);
    }

    @DataProvider(name = "twoSumData")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10, new int[]{4, 6}},
                {new int[]{2, 7, 11, 15, 6}, 9, new int[]{0, 1}},
                {new int[]{3, 2, 4, 5}, 6, new int[]{1, 2}},
                {new int[]{3, 3}, 6, new int[]{0, 1}},
                {new int[]{3, 3}, 5, null},
                {new int[]{3}, 0, null},
                {new int[]{}, 0, null},

        };
    }

    @DataProvider(name = "twoSumDataSorted")
    public Object[][] getDataFromSortedDataProvider() {
        return new Object[][]{
                {new int[]{-4, -1, 1, 3, 5, 6, 8, 11}, 10, new int[]{1, 7}},
                {new int[]{2, 7, 11, 15, 16}, 9, new int[]{0, 1}},
                {new int[]{2, 3, 4, 5}, 6, new int[]{0, 2}},
                {new int[]{3, 3}, 6, new int[]{0, 1}},
                {new int[]{3, 3}, 5, null},
                {new int[]{3}, 0, null},
                {new int[]{}, 0, null}
        };
    }
}
