package com.sopt.algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_17779 {
    static int n;
    static int map[][];
    static int mark[][];
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        mark = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int diffMin = INF;

        for (int x = 0; x <= n-3 ; x++) {
            for (int y = 1; y <= n-2 ; y++) {
                for (int d1 = 1; y-d1 >= 0 && x+d1 <= n-2 ; d1++) {
                    for (int d2 = 1; y+d2 <=n-1 && x+d1+d2 <= n-1 ; d2++) {

                        for (int i = 0; i < n; i++) {
                            Arrays.fill(mark[i], 0);
                        }

                        //마름모 5 구역 표시
                        for (int i = 0; i <= d1 ; i++) {
                            mark[x+i][y-i] = 5;
                            mark[x+d2+i][y+d2-i] = 5;
                        }
                        for (int i = 0; i <= d2; i++) {
                            mark[x+i][y+i] = 5;
                            mark[x+d1+i][y-d1+i] = 5;
                        }

                        //경계 표시
                        for (int r = 0; r < x ; r++) {
                            mark[r][y] = 1;
                        }
                        for (int c = y+d2+1; c < n ; c++) {
                            mark[x+d2][c] = 2;
                        }
                        for (int c = 0; c < y-d1 ; c++) {
                            mark[x+d1][c] = 3;
                        }
                        for (int r = x+d1+d2+1; r < n ; r++) {
                            mark[r][y-d1+d2] = 4;
                        }

                        //dfs로 구역 채움
                        fill(0,0, 1);
                        fill(0,n-1, 2);
                        fill(n-1,0, 3);
                        fill(n-1,n-1, 4);

                        //구분선 (5) 안에 0으로 채워져있는데도 합쳐줘야하므로 6
                        int people[] = new int[6];
                        for (int r = 0; r < n; r++) {
                            for (int c = 0; c < n; c++) {
                                people[mark[r][c]] += map[r][c];
                            }
                        }

                        people[5] += people[0];

                        int minP = INF, maxP = 0;

                        for (int i = 1; i <= 5; i++) {
                            minP = Math.min(minP, people[i]);
                            maxP = Math.max(maxP, people[i]);
                        }
                        diffMin = Math.min(diffMin, maxP - minP);
                    }
                }
            }
        } //for
        bw.write(String.valueOf(diffMin));
        bw.flush();
        bw.close();
    }

    static void fill(int r, int c, int val) {
        if (r < 0 || r > n-1 || c < 0 || c > n-1) {
            return;
        }
        if (mark[r][c] != 0 ) {
            return;
        }
        mark[r][c] = val;
        fill(r-1, c, val);
        fill(r+1, c, val);
        fill(r, c-1, val);
        fill(r, c+1, val);
    }
}
