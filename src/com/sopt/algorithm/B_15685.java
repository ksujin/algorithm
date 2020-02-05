package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15685 {
    static int[] curveDirection = new int[1024];
    static boolean[][] map = new boolean[101][101];
    public static void main(String[] args) throws IOException {
        //1. 0 방향으로 시작하는 드래곤 커브를 10세대까지 방향 만듦. [0 1 2 1 2 3 2 1 2 3 0 3 2 3  ...]
        curveDirection[0] = 0;

        for (int i = 0; i < 10; i++) {
            int startPoint = (int)Math.pow(2,i);
            int endPoint = (int)Math.pow(2,i+1);
            for (int j = startPoint; j < endPoint; j++) {
                curveDirection[j] = (curveDirection[endPoint-j-1]+1) % 4;
            }
        }

        //2. dragon 개수 받아서 해당하는 점 찍음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dragonCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < dragonCount; i++) {
            String dragonInfo = br.readLine();
            StringTokenizer st = new StringTokenizer(dragonInfo);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int generation = Integer.parseInt(st.nextToken());
            dragonSpot(new Point(x, y), direction, generation);
        }


        //4. 정사각형 개수 구하기
        System.out.println(squareCount(map));

    }

    static int squareCount(boolean map[][]) {
        int ans = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100 ; j++) {
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]){
                    ans++;
                }
            }
        }
        return ans;
    }

    static void dragonSpot(Point standardPoint, int firstDirection, int generation) {
        //입력받은 direction이 0이 아니라면 해당 값에 맞게 기존 direction(초기 direction 0) 변형.

        int changedcurveDirection[] = curveDirection.clone();
        if (firstDirection != 0) {
            for (int i = 0; i < changedcurveDirection.length; i++) {
                changedcurveDirection[i] = (changedcurveDirection[i]+firstDirection) % 4;
            }
        }


        //System.out.println(standardPoint.x + ","+standardPoint.y+"에서 시작합니다");

        //초기 입력 point 찍음
        map[standardPoint.x][standardPoint.y] = true;

        //generation에 따른 개수에 맞게 point 찍음
        for (int i = 0; i < (int)Math.pow(2, generation); i++) {
            switch (changedcurveDirection[i]) {
                case 0:
                    standardPoint.toRight();
                    //System.out.println("오른쪽으로 갑니다. 현재 포인트는 "+standardPoint.x+","+standardPoint.y);
                    break;
                case 1 :
                    standardPoint.toUp();
                    //System.out.println("위로 갑니다. 현재 포인트는 "+standardPoint.x+","+standardPoint.y);
                    break;
                case 2:
                    standardPoint.toLeft();
                    //System.out.println("왼쪽으로 갑니다. 현재 포인트는 "+standardPoint.x+","+standardPoint.y);
                    break;
                case 3:
                    standardPoint.toDown();
                    //System.out.println("아래로 갑니다. 현재 포인트는 "+standardPoint.x+","+standardPoint.y);
                    break;

                    default:
                        break;
            }
            map[standardPoint.x][standardPoint.y] = true;
        }
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        void toRight() {
            this.x++;
        }
        void toLeft() {
            this.x--;
        }
        void toUp() {
            this.y--;
        }
        void toDown() {
            this.y++;
        }
    }
}
