package com.programmers.algorithm;

public class P_43165 {
    static int ans = 0;
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        solution(numbers, target);
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return ans;
    }

    public static void dfs(int[] numbers, int target, int result, int depth) {
        if (depth == numbers.length) {
            if (result == target) {
                ans++;
            }
            return;
        }

        dfs(numbers, target, result+numbers[depth], depth+1);
        dfs(numbers, target, result-numbers[depth], depth+1);

    }
}
