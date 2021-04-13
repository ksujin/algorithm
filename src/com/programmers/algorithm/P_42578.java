package com.programmers.algorithm;

import java.util.HashMap;
import java.util.LinkedList;

public class P_42578 {
    public static void main(String[] args) {
        String[][] clothes = {
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        solution(clothes);
    }

    public static int solution(String[][] clothes) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();

        for (String[] cloth:
             clothes) {
            String clothName = cloth[0];
            String clothType = cloth[1];

            if (map.containsKey(clothType)) {
                map.get(clothType).add(clothName);
            } else {
                LinkedList<String> clothList = new LinkedList<>();
                clothList.add(clothName);
                map.put(clothType, clothList);
            }
        }

        //https://bubobubo003.tistory.com/44

        int answer = 1;

        for (String name: map.keySet()) {
            int value = map.get(name).size();
            //더하기 1을 해주는 이유는 의상을 입는 안 입는 경우를 고려해야 하기 때문
            answer = answer * (value + 1);
        }

        //아무 것도 안 입는 경우는 조건에 부합하지 않기 때문
        answer--;

        return answer;
    }

}
