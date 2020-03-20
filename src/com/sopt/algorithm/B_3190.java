package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_3190 {
    static int dx[] = {-1,1,0,0}; //상하좌우
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int appleCount = Integer.valueOf(br.readLine());
        int map[][] = new int[n+1][n+1]; //-1 뱀 0 빈공간 1 사과

        //뱀
        map[1][1] = -1;
        Queue<SnakeNode> snakeQ = new LinkedList<>();
        snakeQ.offer(new SnakeNode(1,1));

        //사과
        for (int i = 0; i < appleCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());
            map[x][y] = 1;
        }

        Queue<TimeNode> timeQ = new LinkedList<>();
        int curveCount = Integer.valueOf(br.readLine());
        for (int i = 0; i < curveCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.valueOf(st.nextToken());
            String direction = st.nextToken();
            timeQ.offer(new TimeNode(time, direction));
        }

        int ans = 0;
        int dir = 3; //우측

        while (true) {
            ans++;
            int nextX = ((LinkedList<SnakeNode>) snakeQ).getLast().x + dx[dir];
            int nextY = ((LinkedList<SnakeNode>) snakeQ).getLast().y + dy[dir];
            if(!isInRange(nextX, nextY, n) || map[nextX][nextY] == -1) {
                break;
            }



            //빈공간일때는 꼬리 자름
            if(map[nextX][nextY] == 0) {
               SnakeNode snakeTail = snakeQ.poll();
               map[snakeTail.x][snakeTail.y] = 0;
            }

            //늘림
            map[nextX][nextY] = -1;
            snakeQ.offer(new SnakeNode(nextX,nextY));


            if (!timeQ.isEmpty() && timeQ.peek().time == ans) {
                if (timeQ.poll().dir.equals("L")) {
                    //현재 방향에서 왼쪽으로 틀어야함
                    if (dir == 0) {
                        //상 -> 좌
                        dir = 2;
                    }
                    else if (dir == 1) {
                        //하 -> 우
                        dir = 3;
                    }
                    else if (dir == 2) {
                        // 좌 -> 하
                        dir = 1;
                    }
                    else if (dir == 3) {
                        //우 -> 상
                        dir = 0;
                    }
                } else {
                    //현재 방향에서 오른쪽으로 틀어야함
                    if (dir == 0) {
                        //상 -> 우
                        dir = 3;
                    }
                    else if (dir == 1) {
                        //하 -> 좌
                        dir = 2;
                    }
                    else if (dir == 2) {
                        // 좌 -> 상
                        dir = 0;
                    }
                    else if (dir == 3) {
                        //우 -> 하
                        dir = 1;
                    }
                }
            }

        } // while



        System.out.println(ans);
    }

    static boolean isInRange(int x, int y, int mapSize) {
        if (0 < x && x <= mapSize && 0 < y && y <= mapSize) {
            return true;
        }
        return false;
    }

    static class TimeNode {
        int time;
        String dir;

        TimeNode(int time, String dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    static class SnakeNode {
        int x;
        int y;

        SnakeNode(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
