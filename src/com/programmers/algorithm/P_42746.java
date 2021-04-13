package com.programmers.algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;

public class P_42746 {
    public static void main(String[] args) {
        int[] numbers = {0, 0, 0};
        solution(numbers);
    }

    public static String solution(int[] numbers) {

        String answer = "";

        String[] stringNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);


        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });


        for (String string :
                stringNumbers) {
            answer += string;
        }


        if (answer.equals("0".repeat(stringNumbers.length))) {
            answer = "0";
        }

        return answer;
    }
}
