package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1504 {
    int n, m;
    Scanner scn = new Scanner(System.in);

    ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    int via[];
    long dist[];
    final long INF = Long.MAX_VALUE;


    void solve() {
        //n = 정점의 개수이자 목적지
        n = scn.nextInt();
        //m = 간선의 개수
        m = scn.nextInt();

        dist = new long[n];
        via = new int[n];

        //정점의 개수만큼 일단 edge array 를 담고있는 adj 어레이 리스트를 만든다
        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<Edge>());
        }

        for (int i = 0; i < m; i++) {
            int from = scn.nextInt();
            int to = scn.nextInt();
            //from 에서 to 로 가는 edge 의  weight
            int weight = scn.nextInt();
            from--; to--;
            //양방향이니까 추가
            adj.get(from).add(new Edge(to, weight));
            adj.get(to).add(new Edge(from, weight));
        }

        int node1 = scn.nextInt();
        int node2 = scn.nextInt();

        node1--;
        node2--;
        //1에서 출발 할때
        diik(0);
        //1에서 첫번째 노드까지
        long firstToNode1 = dist[node1];
        //1에서 두번째 노드까지
        long firstToNode2 = dist[node2];

        if (firstToNode1 == INF || firstToNode2 == INF){
            System.out.println("-1");
            return;
        }

        diik(node1);
        long node1ToNode2 = dist[node2];

        if (node1ToNode2 == INF){
            System.out.println("-1");
            return;
        }

        //목적지에서 두번째노드 혹은 첫번째 노드 까지
        diik(n-1);
        long destToNode1 = dist[node1];
        long destToNode2 = dist[node2];

        if (destToNode1 == INF || destToNode2==INF){
            System.out.println("-1");
            return;
        }

        //0-1-2-3
        //0-2-1-3
        long node1First = firstToNode1+node1ToNode2+destToNode2;
        long node2First = firstToNode2+node1ToNode2+destToNode1;
        long minValue = Math.min(node1First, node2First);

        System.out.println(minValue);



    }

    void diik(int first) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        Arrays.fill(dist, INF);

        //처음노드에서 처음 노드까지 걸리는 비용
        dist[first] = 0;
        pq.add(new Edge(first, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int standardNode = now.u;
            //현재 뽑아온 노드의 인접 행렬 사이즈 만큼
            for (int i = 0; i < adj.get(standardNode).size(); i++) {
                //standard node 와 이어져있는 노드 t
                int t = adj.get(standardNode).get(i).u;
                if (dist[t] > adj.get(standardNode).get(i).cost + dist[standardNode]) {
                    dist[t] = adj.get(standardNode).get(i).cost + dist[standardNode];
                    via[t] = standardNode;
                    pq.add(new Edge(t, dist[t]));
                }

            }
        }

    }

    public static void main(String[] args) {
        new B_1504().solve();
    }

    class Edge implements Comparable<Edge>{
        //노드
        int u;
        //어떤 노드에서 u 까지 오는데 edge 의 weight 혹은 시작점에서 u까지 오는데 최단 비용 저장
        long cost;

        Edge(int u, long cost){
            this.u = u;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if (cost > o.cost) return -1;
            if (cost < o.cost) return 1;
            return 0;
        }
    }
}


