package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dx[] = {0, 0, 0, -1, 1}; //공 동 서 북 남
        int dy[] = {0, 1, -1, 0, 0}; //공 동 서 북 남
        Dice dice = new Dice(0,0,0,0,0,0);

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int x = Integer.valueOf(st.nextToken());
        int y = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        int map[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        //command
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.valueOf(st.nextToken());
            int nextX = x+dx[dir];
            int nextY = y+dy[dir];
            // 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다
            if (!isInRange(nextX, nextY, n, m)) {
                continue;
            }
            // 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
            if (map[nextX][nextY] == 0) {
                dice = roll(dice, dir);
                map[nextX][nextY] = dice.bottom;
            }
            // 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
            else {
                dice = roll(dice, dir);
                dice.bottom = map[nextX][nextY];
                map[nextX][nextY] = 0;
            }
            x = nextX;
            y = nextY;
            System.out.println(dice.top);
        }
    }


    static boolean isInRange(int x, int y, int n, int m) {
        if (0 <= x && x < n && 0 <= y && y < m) {
            return true;
        }
        return false;
    }

    static Dice roll(Dice dice, int direction) {
        int originTop = dice.top;
        int originBottom = dice.bottom;
        int originLeft = dice.left;
        int originRight = dice.right;
        int originFront = dice.front;
        int originBack = dice.back;

        //동 - front, back 은 안변함
        if (direction == 1) {
            dice.right = originTop;
            dice.top = originLeft;
            dice.left = originBottom;
            dice.bottom = originRight;
        }
        //서 - front, back 은 안변함
        else if (direction == 2) {
            dice.left = originTop;
            dice.top = originRight;
            dice.right = originBottom;
            dice.bottom = originLeft;
        }
        //북 - left, right 은 안변함
        else if (direction == 3) {
            dice.top = originFront;
            dice.front = originBottom;
            dice.bottom = originBack;
            dice.back = originTop;
        }
        //남 - left, right 은 안변함
        else {
            dice.top = originBack;
            dice.back = originBottom;
            dice.bottom = originFront;
            dice.front = originTop;
        }
        return dice;
    }

    static class Dice {
        int top;
        int bottom;
        int left;
        int right;
        int front;
        int back;

        Dice(int top,
             int bottom,
             int left,
             int right,
             int front,
             int back) {
            this.top = top;
            this.bottom = bottom;
            this.left = left;
            this.right = right;
            this.front = front;
            this.back = back;

        }
    }
}
