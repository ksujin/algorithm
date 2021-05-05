package com.leetcode.algorithm;

import java.util.HashMap;

public class L_1347 {
    public static void main(String[] args) {
        minSteps("leetcode", "practice");
    }

    public static int minSteps(String s, String t) {
        //알파벳당 숫자를 같게만들면 되는 것
        //1. map 에 s 의 character들을 key로 해서 몇개씩 있는지 담는다.
        //2. t 를 돌면서 map 의 key 값으로 찾은 value 에서 한개씩 뺀다. 만약 0이면 바꿔야하는 숫자를 늘린다.
        int ans = 0;
        HashMap<Character, Integer> alphabet = new HashMap<>();

        // map 초기화
        for(char ch ='a'; ch <='z'; ch++)
            alphabet.put(ch, 0);

        // s 에 있는 알파벳들로 map 세팅
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            int charCountInS = alphabet.get(sChar);
            alphabet.replace(sChar, charCountInS+1);
        }

        for (int i = 0; i < t.length(); i++) {
            char tChar = t.charAt(i);
            int charCountInS = alphabet.get(tChar);
            if (charCountInS == 0) {
                ans++;
            } else {
                alphabet.replace(tChar, charCountInS-1);
            }
        }

        return ans;
    }
}
