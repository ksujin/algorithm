package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int map[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int tempMap[][] = deepCopy(map);
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        int x3 = 0;
        int y3 = 0;

        int max = -1;
        //1. 아무데나 3개 세움
        //1-1. for문 3개?
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] != 0) {
                    continue;
                }
                x1 = i;
                y1 = j;
                for (int k = i; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        if (tempMap[k][l] != 0 || (k == i && l <= j)) {
                            continue;
                        }
                        x2 = k;
                        y2 = l;
                        for (int o = k; o < n; o++) {
                            for (int p = 0; p < m; p++) {
                                if (tempMap[o][p] != 0 || (o == k && p <= l)) {
                                    continue;
                                }
                                x3 = o;
                                y3 = p;
                                tempMap[x1][y1] = 1;
                                tempMap[x2][y2] = 1;
                                tempMap[x3][y3] = 1;
                                int cleanCount = cleanCount(fungus(tempMap, n, m), n, m);
                                max = max > cleanCount ? max : cleanCount;
                                tempMap = deepCopy(map);

                                //System.out.println();
                                //printMap(tempMap, n, m);
                                //System.out.println("(" + i + "," + j + ")" + "(" + k + "," + l + ")" + "(" + o + "," + p + ")");

                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

    private static int[][] deepCopy(int[][] original2) {
        if(original2 == null) return null;
        int[][] result = new int[original2.length][original2[0].length];

        for(int i=0; i<original2.length; i++){
            System.arraycopy(original2[i], 0, result[i], 0, original2[0].length);
        }

        return result;
    }


    static int[][] fungus(int[][] map, int n, int m) {
        int dx[] = {-1,1,0,0}; //상하좌우
        int dy[] = {0,0,-1,1};
        Queue<Integer> xQ = new LinkedList<>();
        Queue<Integer> yQ = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 2) {
                    xQ.offer(i);
                    yQ.offer(j);
                }
            }
        } //for
        while (!xQ.isEmpty()) {
            int x = xQ.poll();
            int y = yQ.poll();
            //1 만날때까지 쭉 감염
            for (int k = 0; k < 4; k++) {
                int nextX = x+dx[k];
                int nextY = y+dy[k];
                while (isInRange(nextX, nextY, n, m) && map[nextX][nextY] == 0) {
                    xQ.offer(nextX);
                    yQ.offer(nextY);
                    map[nextX][nextY] = 2;
                    nextX += dx[k];
                    nextY += dy[k];
                }
            }

        }


        return map;

    }

    static boolean isInRange(int x, int y, int n, int m){
        if (0<= x && x < n && 0<= y && y < m) {
            return true;
        }
        return false;
    }

    static int cleanCount(int[][] map, int n, int m) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
