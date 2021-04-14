package com.programmers.algorithm;


import java.util.HashSet;


public class P_42839 {

    static HashSet<Integer> permuationSet = new HashSet<>();

    public static void main(String[] args) {
        solution("011");
    }

    public static int solution(String numbers) {
        int answer = 0;

        char[] numChars = numbers.toCharArray();
        int n = numChars.length;
        int r = n;
        char[] output = new char[r];
        boolean[] visitied = new boolean[n];

        //조합 set을 구한다.
        check(numChars, visitied, "", 0);
        //숫자마다 소수인지 구한다.
        for (int element:
                permuationSet) {
            answer += isPrime(element) ? 1 : 0;
        }

        return answer;
    }

    static boolean isPrime(int num) {
        if (num == 1 || num == 0) {
            return false;
        }
        //소수 판별 법 - 입력받은 숫자의 제곱근 까지의 숫자로 나누어본다.
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //조합 - https://bcp0109.tistory.com/entry/%EC%88%9C%EC%97%B4-Permutation-Java
    static void check(char[] arr, boolean[] visited, String current, int depth) {
        if (depth == arr.length) {
            return;
        }

        String temp = current;
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current += arr[i];
                permuationSet.add(Integer.parseInt(current));
                check(arr, visited, current,depth+1);
                visited[i] = false;
                current = temp;
            }
        }
    }
}
