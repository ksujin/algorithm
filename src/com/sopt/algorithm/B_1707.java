package com.sopt.algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/*간선으로 이어진 노드는 각자 다른 영역에 속해있어야 이분그래프 성립*/
public class B_1707 {

    static Scanner scn = new Scanner(System.in);
    static int RED = 1;
    static boolean bi;
    public void solve(){
        int v = scn.nextInt();
        int e = scn.nextInt();
        boolean visit[] = new boolean[v+1];
        int color[] = new int[v+1];


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v+1; i++) {
            adj.add(new ArrayList<>());
            visit[i] = false;
        }

        bi = true;

        //그래프 만들어줌
        for (int i = 0; i < e; i++) {
            int start = scn.nextInt();
            int end = scn.nextInt();
            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        for (int i = 1; i < v+1; i++) {
            if (!bi) break;
            if(!visit[i] ){
                dfs(i, visit, adj, color, RED);
            }
        }

        System.out.println(bi ? "YES" : "NO");





    }

    public void dfs(int start , boolean[] visit, ArrayList<ArrayList<Integer>> adj, int[] color, int nodeColor){
        visit[start] = true;
        color[start] = nodeColor;
        for (int i = 0; i < adj.get(start).size(); i++) {

            int next = adj.get(start).get(i);
            if (color[start] == color[next]) {
                bi = false;
                return;
            }
            if (!visit[next]) {
                dfs(next, visit, adj, color, -nodeColor);
            }

        }

    }

    public static void main(String args[]){
        int testCase = scn.nextInt();
        for (int i = 0; i < testCase; i++) {
            new B_1707().solve();
        }

    }
}
