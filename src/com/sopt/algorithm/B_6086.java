package com.sopt.algorithm;

import java.util.*;

public class B_6086 {
    public static void solve(){
        int MAX_V = 52;
        int INF = Integer.MAX_VALUE;

        Scanner scn = new Scanner(System.in);

        int e = scn.nextInt();

        int[][] f = new int[MAX_V][MAX_V];
        int[][] c = new int[MAX_V][MAX_V];

        int[] prev = new int[MAX_V];
        ArrayList[] adj = new ArrayList[52];

        int S = CtoI('S');
        int E = CtoI('T');



        int total = 0;

        for (int i = 0; i < MAX_V; i++) {
            adj[i] = new ArrayList<>();
        }

        //용량 추가
        for (int i = 0; i < e; i++) {
            int first = CtoI(scn.next().charAt(0));
            int second =  CtoI(scn.next().charAt(0));
            int w = scn.nextInt();

            c[first][second] += w;
            adj[first].add(second);
            adj[second].add(first);
        }





        //bfs 돔
        while (true){

            Arrays.fill(prev,-1);
            Queue<Integer> q =  new LinkedList<>();
            q.add(S);

            while(!q.isEmpty()){
                int cur = q.poll();
                 //System.out.println("current is "+cur);
                for (int i = 0; i < adj[cur].size() ; i++) {
                    int next = (int) adj[cur].get(i);
                     //  System.out.println(cur+"'s next is "+next);

                    if(c[cur][next] - f[cur][next] > 0 && prev[next] == -1){
                        q.add(next);
                        prev[next] = cur;
                        if (next == E) break;
                    }
                }
            }

            if (prev[E] == -1) break;

            int flow = INF;

           // System.out.println("path is");
            for (int i = E; i != S ; i = prev[i]) {
                //augumenting path
                //  System.out.println(i+"-"+prev[i]);
                flow = Math.min(flow,c[prev[i]][i]-f[prev[i]][i]);
            }
            //System.out.println("flow is "+flow);

            for (int i = E; i != S ; i = prev[i]) {
                f[prev[i]][i] += flow;
                f[i][prev[i]] -= flow;


                   // System.out.println(prev[i]+"-"+i+" = "+f[prev[i]][i]+"/"+c[prev[i]][i]);
            }

            total += flow;


        }

        System.out.println(total);


    }

    public static int CtoI(char c){
        if(c <= 'Z')return c-'A';
        return c-'a'+26;
    }

    public static void main(String[] args){
        new B_6086().solve();
    }


}

