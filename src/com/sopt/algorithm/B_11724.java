package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class B_11724 {

    static boolean visit[];
    static ArrayList<ArrayList<Integer>> adj;

    public void solve(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        adj = new ArrayList<>();
        visit = new boolean[n + 1];

        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
            visit[i] = false;
        }

        for (int i = 0; i < m; i++) {
            int start = scn.nextInt();
            int end = scn.nextInt();

            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        int count = 0;

        for (int i = 1; i < n+1; i++) {
            if (!visit[i]){
                count++;
                //System.out.println("들어가는 것은 " + i);
                dfs(i);
            }
        }
        System.out.println(count);
    }

    public static void main(String args[]){
        new B_11724().solve();
    }

    public void dfs(int start){
        visit[start] = true;
        for (int i = 0; i < adj.get(start).size(); i++) {
            int next = adj.get(start).get(i);
            if (!visit[next]) dfs(next);
        }
    }
}
