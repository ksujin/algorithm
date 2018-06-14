package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_2667 {

    static int map[][];
    static boolean visit[][];
    static int ax[] = {-1,0,1,0};
    static int ay[] = {0,-1,0,1};
    static int mapWidth, mapVillageCount;
    private void solve(){
        Scanner scn = new Scanner(System.in);
        mapWidth = scn.nextInt();
        map = new int[mapWidth][mapWidth];
        visit = new boolean[mapWidth][mapWidth];

        for (int i = 0; i < mapWidth; i++) {
         String oneLine = scn.next();
            for (int j = 0; j < mapWidth; j++) {
                String tempArray[] = oneLine.split("");
                map[i][j] = Integer.parseInt(tempArray[j]);
            }
        }


        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapWidth; j++) {
                if(!visit[i][j] && map[i][j] == 1){
                   // System.out.println("(" + i + "," + j+")");
                    mapVillageCount = 0;
                    bfs(i, j);
                    arr.add(mapVillageCount);

                }
            }
        }

        System.out.println(arr.size());
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }

    }

    public static void bfs(int x, int y){
        mapVillageCount++;
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = ax[i] + x;
            int nextY = ay[i] + y;

            if(inInRange(nextX, nextY) && !visit[nextX][nextY] && map[nextX][nextY] == 1){
               // System.out.println("current is ("+x+","+y+") and next is ("+nextX+","+nextY+")");
                bfs(nextX, nextY);
            }

        }
    }

    public static boolean inInRange(int x, int y){
        if ((0<=x && x < mapWidth) && (0<=y && y < mapWidth)){
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        new B_2667().solve();
    }


}
