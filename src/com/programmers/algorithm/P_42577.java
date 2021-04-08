package com.programmers.algorithm;

import java.util.Arrays;

public class P_42577 {
    public static void main(String[] args) {
        String input[] = {"12","123","1235","567","88"};
        solution(input);
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length-1; i++) {
            String prefix = phone_book[i];
            String nextString = phone_book[i+1];
            if (nextString.startsWith(prefix)) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
