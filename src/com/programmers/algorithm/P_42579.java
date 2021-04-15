package com.programmers.algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class P_42579 {

    public static void main(String[] args) {
        String genres[] = {"classic", "pop", "classic", "classic", "pop"};
        int plays[] = {500, 600, 150, 800, 2500};
        solution(genres, plays);
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreCountMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreCountMap.put(genre, genreCountMap.getOrDefault(genre, 0) + play);
        }

        int[] answer = new int[genres.length];
        for (int i = 0; i < genres.length; i++) {
            answer[i] = i;
        }

        HashMap<String, Integer> playListCountMap = new HashMap<>();

        answer = Arrays
                .stream(answer)
                .boxed()
                .sorted((a, b) -> {
                    int res = -genreCountMap.get(genres[a]) + genreCountMap.get(genres[b]);
                    if (res == 0) {
                        res = -plays[a] + plays[b];
                    }
                    return res;
                })
                .filter(index -> {
                    String genre = genres[index];
                    playListCountMap
                            .put(genre, playListCountMap.getOrDefault(genre, 0) + 1);
                    int genreCountInPlayList = playListCountMap.get(genre);
                    return genreCountInPlayList <= 2;
                })
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }
}
