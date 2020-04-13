package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14503 {
    static boolean cleaned[][];
    static int ans;
    //북(0) 왼 : 서(3)
    //동(1) 왼 : 북(0)
    //남(2) 왼 : 동(1)
    //서(3) 왼 : 남(2)
    static int dirs[] = {0,1,2,3};
    //북동남서
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static int map[][];
    static int n, m;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = dirs[Integer.parseInt(st.nextToken())];

        map = new int[n][m];
        cleaned = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    cleaned[i][j] = true;
            }
        }

        ans = 0;
        //1. 현재 위치를 청소한다.
        clean(x,y, dir);
        System.out.println(ans);
    }

    static void clean(int x, int y, int dir) {
        if(!cleaned[x][y]) {
            ans++;
            cleaned[x][y] = true;
        }
        searchLeft(x, y, dir);
    }

    static void searchLeft(int x, int y, int dir) {
        //네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
        if (isFourSideClean(x, y)) {
            //0이면 2, 1이면 3, 2면 0, 3이면 1 dir-2
            if (map[x+dx[(dir+2)%4]][y+dy[(dir+2)%4]] == 1) {
                //뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                return;
            }
            //바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
            searchLeft(x+dx[(dir+2)%4],y+dy[(dir+2)%4],dir);
            return;
        }

        //왼쪽 방향
        //1이면 0, 2면 1, 3이면 2 , 0이면 3 //dirs[dir-1];
        int leftDir = dirs[(dir+3)%4];

        //2-a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
        if (cleaned[x+dx[leftDir]][y+dy[leftDir]] == false) {
            clean(x+dx[leftDir], y+dy[leftDir], leftDir);
        } else {
            //2-b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
            searchLeft(x,y,leftDir);
        }

    }

    static boolean isFourSideClean(int x, int y) {
        boolean ans = true;
        for (int i = 0; i < 4; i++) {
            ans = ans && cleaned[x+dx[i]][y+dy[i]];
        }
        return ans;
    }

}
