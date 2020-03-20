package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_12100 {
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int map[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        //5번 움직여서 나올 수 있는 가장 큰 수
        //DFS
        dfs(map, 0);
        System.out.println(max);

    }

    static void dfs(int map[][], int depth) {
        if (depth == 5) {
            //최대값 찾기
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    max = max > map[i][j] ? max : map[i][j];
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            dfs(merge(i, map), depth+1);
        } //for
    }

    static int[][] merge(int direction, int map[][]) {
        int merged[][] = new int [map.length][map.length];
        Queue<Integer> q = new LinkedList<>();

        if (direction == 0) {
            for (int x = 0; x < map.length; x++) {
                for (int y = 0; y < map.length; y++) {
                    if (map[y][x] != 0) {
                        q.offer(map[y][x]);
                    }
                }

                int idx = 0;
                while (!q.isEmpty()) {
                    int val = q.poll();
                    if (merged[idx][x] == 0) {
                        merged[idx][x] = val;
                    }
                    else if (merged[idx][x] == val) {
                        merged[idx][x] += val;
                        idx++;
                    }
                    //다른 숫자로 막혀있을때
                    else {
                        idx++;
                        merged[idx][x] = val;
                    }
                }
            }
        } //if 상

        //하
        if (direction == 1) {
            for (int x = 0; x < map.length; x++) {
                for (int y = map.length -1; y >= 0; y--) {
                    if (map[y][x] != 0) {
                        q.offer(map[y][x]);
                    }
                }

                int idx = map.length-1;
                while (!q.isEmpty()) {
                    int val = q.poll();
                    if (merged[idx][x] == 0) {
                        merged[idx][x] = val;
                    }
                    else if (merged[idx][x] == val) {
                        merged[idx][x] += val;
                        idx--;
                    }
                    //다른 숫자로 막혀있을때
                    else {
                        idx--;
                        merged[idx][x] = val;
                    }
                }
            }
        } //if 하


        //좌
        if (direction == 2) {
            for (int x = 0; x < map.length; x++) {
                for (int y = 0; y < map.length; y++) {
                    if (map[x][y] != 0) {
                        q.offer(map[x][y]);
                    }
                }

                int idx = 0;
                while (!q.isEmpty()) {
                    int val = q.poll();
                    if (merged[x][idx] == 0) {
                        merged[x][idx] = val;
                    }
                    else if (merged[x][idx] == val) {
                        merged[x][idx] += val;
                        idx++;
                    }
                    //다른 숫자로 막혀있을때
                    else {
                        idx++;
                        merged[x][idx] = val;
                    }
                }
            }
        } //if 좌

        //우
        if (direction == 3) {
            for (int x = 0; x < map.length; x++) {
                for (int y = map.length - 1; y >= 0; y--) {
                    if (map[x][y] != 0) {
                        q.offer(map[x][y]);
                    }
                }

                int idx = map.length - 1;
                while (!q.isEmpty()) {
                    int val = q.poll();
                    if (merged[x][idx] == 0) {
                        merged[x][idx] = val;
                    }
                    else if (merged[x][idx] == val) {
                        merged[x][idx] += val;
                        idx--;
                    }
                    //다른 숫자로 막혀있을때
                    else {
                        idx--;
                        merged[x][idx] = val;
                    }
                }
            }
        } //if 우

        return merged;
    }
}
