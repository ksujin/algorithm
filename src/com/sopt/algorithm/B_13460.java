package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_13460 {
    static char map[][];
    static boolean visited[][][][];
    static int dx[] = {0,0,1,-1}; //동 서 남 북
    static int dy[] = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[10][10][10][10]; //안되면 여기 체크
        Node ball = new Node(0,0,0,0,0);

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char word = line.charAt(j);
                map[i][j] = word;
                if (word == 'R') {
                    ball.redX = i;
                    ball.redY = j;
                }
                else if (word == 'B') {
                    ball.blueX = i;
                    ball.blueY = j;
                }
            }
        }

        bfs(ball);
    }
    static void bfs(Node ball) {
        Queue<Node> q = new LinkedList<>();
        q.offer(ball);

        while (!q.isEmpty()) {
            Node current = q.poll();
            visited[current.redX][current.redY][current.blueX][current.blueY] = true;
            int count = current.cnt +1;

            if (count > 10) {
                System.out.println("-1");
                return;
            }

            //4면으로 굴림
            for (int i = 0; i < 4; i++) {
                //파랑 먼저 벽 마주칠때까지
                int currentBX = current.blueX;
                int currentBY = current.blueY;
                while (map[currentBX+dx[i]][currentBY+dy[i]] != '#') {
                    currentBX += dx[i];
                    currentBY += dy[i];
                    if (map[currentBX][currentBY] == 'O') {
                        break;
                    }
                }

                //빨강 벽 마주칠때까지
                int currentRX = current.redX;
                int currentRY = current.redY;
                while (map[currentRX+dx[i]][currentRY+dy[i]] != '#') {
                    currentRX += dx[i];
                    currentRY += dy[i];
                    if (map[currentRX][currentRY] == 'O') {
                        break;
                    }
                }

                //파랑 빠졌으면 재개
                if (map[currentBX][currentBY] == 'O') {
                    continue;
                }
                //빨강만 빠졌으면 성공
                if (map[currentRX][currentRY] == 'O') {
                    System.out.println(count);
                    return;
                }

                //둘다 같은 곳에 있으면 위치 조정
                if (currentRX == currentBX && currentRY == currentBY) {
                    switch (i) {
                        case 0: //동
                            //빨간 구슬이 원래 더 오른쪽에 있었으면
                            if (current.redY > current.blueY) {
                                currentBY--;
                            } else {
                                currentRY--;
                            }
                            break;
                        case 1: //서
                            //빨간 구슬이 원래 더 오른쪽에 있었으면
                            if (current.redY > current.blueY) {
                                currentRY++;
                            } else {
                                currentBY++;
                            }
                            break;
                        case 2: //남
                            //빨간 구슬이 원래 더 밑에 있었으면
                            if (current.redX > current.blueX) {
                                currentBX--;
                            } else {
                                currentRX--;
                            }
                            break;
                        case 3: //북
                            //빨간 구슬이 원래 더 밑에 있었으면
                            if (current.redX > current.blueX) {
                                currentRX++;
                            } else {
                                currentBX++;
                            }
                            break;
                            default:
                                break;
                    }
                } //위치 조정

                //위치 조정 다 하고나서 만약 안가본 곳이라면 node에 추가
                if (!visited[currentRX][currentRY][currentBX][currentBY]) {
                    q.offer(new Node(currentRX, currentRY, currentBX, currentBY, count));
                }

            } //for
        } //while

        System.out.println("-1");
    }

    static class Node {
        int blueY;
        int redY;
        int blueX;
        int redX;
        int cnt;

        Node(int redX, int redY, int blueX, int blueY, int cnt) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.cnt = cnt;
        }
    }
}
