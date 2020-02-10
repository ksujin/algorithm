package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2252 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inputCnt = new int[n+1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            inputCnt[to]++;
        }

        System.out.println(topologicalSort(graph, inputCnt, n));
    }

    static String topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] inputCnt, int n) {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        //선행 정점 갖고있지 않은 초기 정점 삽입
        for (int i = 1; i <= n ; i++) {
            if (inputCnt[i] == 0) {
                q.add(i);
            }
        }

        //정점의 수만큼 반복
        for (int i = 1; i <= n ; i++) {
            int node = q.poll();
            sb.append(node + " ");
            for (int adj : graph.get(node)) {
                inputCnt[adj]--;

                if (inputCnt[adj] == 0) {
                    ((LinkedList<Integer>) q).add(adj);
                }
            }

        }
        return sb.toString();
    }
}
