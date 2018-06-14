package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class B_10451 {
    static Scanner scn = new Scanner(System.in);
    static boolean visit[];
    static ArrayList<ArrayList<Integer>> adj;
    static int start, count ;
    public void solve(){
        adj = new ArrayList<>();
        int n = scn.nextInt();
        visit = new boolean[n+1];
        count = 0;
        for (int i = 0; i < n+1 ; i++) {
            adj.add(new ArrayList<>());
            visit[i] = false;
        }

        for (int i = 1; i < n+1; i++) {
            int start = i;
            int end = scn.nextInt();
            adj.get(start).add(end);
        }


        for (int i = 1; i < n+1 ; i++) {
            start = i;
            if (!visit[i] ){
                dfs(adj.get(i).get(0));
            }
        }

        System.out.println(count);
    }

    public static void main(String args[]){
        int testCount = scn.nextInt();
        for (int i = 0; i < testCount; i++) {
            new B_10451().solve();
        }

    }


    public void dfs(int here){

        visit[here] = true;
        int next = adj.get(here).get(0);
        if (start == next){
            count ++;
            return;
        }
        if(!visit[next]){
            dfs(next);
        }
    }
}
