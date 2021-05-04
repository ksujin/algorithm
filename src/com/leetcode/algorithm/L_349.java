package com.leetcode.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L_349 {
    public static void main(String[] args) {
        int nums1[] = {1,2,2,1};
        int nums2[] = {2,2};
        intersection(nums1, nums2);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Integer[] nums1Int = Arrays.stream(nums1).boxed().toArray(Integer[]::new);
        Integer[] nums2Int = Arrays.stream(nums2).boxed().toArray(Integer[]::new);
        Set<Integer> nums1Set = new HashSet<Integer>(Arrays.asList(nums1Int));
        Set<Integer> nums2Set = new HashSet<Integer>(Arrays.asList(nums2Int));
        nums1Set.retainAll(nums2Set);
        int[] results = nums1Set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return results;
    }
}
