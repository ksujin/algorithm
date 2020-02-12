package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int indegree[] = new int[n+1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //초기화 필요
        for(int i=0; i<= n; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            indegree[to]++;
            graph.get(from).add(to);
            //graph[from].add(to);
        }


        topologicalSort(n, indegree, graph);

    }

    static void topologicalSort(int n, int[] indegree, ArrayList<ArrayList<Integer>> graph) {
        //1. priority queue 만듦
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //2. indegree 0 인것 삽입
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }
        //3. pq가 빌때까지 반복
        while (!pq.isEmpty()) {
            //4. 하나 꺼냄
            int node = pq.poll();
            System.out.print(node + " ");
            for (int neighbor: graph.get(node)) {
                //5. 연결된 간선 지움
                indegree[neighbor]--;
                //6. 지워서 indegree 0된거 있으면 pq에 추가
                if (indegree[neighbor] == 0) {
                    pq.add(neighbor);
                }
            }
        }
    }
}
