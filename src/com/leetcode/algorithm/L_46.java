package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class L_46 {
    public static void main(String[] args) {
        int[] nums = {0,1};
        permute(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {
        boolean visited[] = new boolean[nums.length];
        int permuted[] = new int[nums.length];
        List<List<Integer>> permutedList = new ArrayList<>();
        dfs(nums, visited, permuted, 0, permutedList);
        return permutedList;
    }

    public static void dfs(int[] nums, boolean[] visited, int permuted[], int depth, List<List<Integer>> permutedList) {
        if (depth == nums.length) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < permuted.length; i++) {
                list.add(permuted[i]);
            }
            permutedList.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permuted[depth] = nums[i];
                dfs(nums, visited, permuted, depth+1, permutedList);
                visited[i] = false;
            }
        }
    }
}
