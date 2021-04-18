package com.programmers.algorithm;

public class P_43163 {
    static int initialValue = 51;
    static int min = initialValue;
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words =
        //{"hot", "dot", "dog", "lot", "log"};
        {"hot", "dot", "dog", "lot", "log", "cog"};
        solution(begin, target, words);
    }

    public static int solution(String begin, String target, String[] words) {
        dfs(begin, target, words, 0);
        int answer = min == initialValue ? 0 : min;
        System.out.println(answer);
        return answer;
    }

    static void dfs(String begin, String target, String[] words, int depth) {
        if (begin == target) {
            min = depth < min ? depth : min;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            int diffCount = 0;
            String word = words[i];

            for (int j = 0; j < word.length(); j++) {
                if (begin.charAt(j) != word.charAt(j)) {
                    diffCount++;
                }
            }

            if (diffCount == 1) {
                words[i] = "";
                dfs(word, target, words, depth+1);
                words[i] = word;
            }
        }
    }
}