package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_11779 {
    int n, m;
    Scanner scn = new Scanner(System.in);

    ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    int via[];
    long dist[];
    final long INF = Long.MAX_VALUE;


    void solve() {
        //n = 도시의 개수
        n = scn.nextInt();
        //m = 버스의 개수
        m = scn.nextInt();

        dist = new long[n];
        via = new int[n];

        //도시의 개수만큼 일단 edge array 를 담고있는 adj 어레이 리스트를 만든다
        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<Edge>());
        }

        for (int i = 0; i < m; i++) {
            int from = scn.nextInt();
            int to = scn.nextInt();
            //from 에서 to 로 가는 edge 의  weight
            int weight = scn.nextInt();
            from--; to--;
            adj.get(from).add(new Edge(to, weight));
        }

        int start = scn.nextInt();
        int end = scn.nextInt();

        start--;
        end--;
        diik(start);

        System.out.println(dist[end]);

        ArrayList<Integer> ret = new ArrayList<>();

        while (end != start){
            ret.add(end);
            end = via[end];
        }
        ret.add(start);
        System.out.println(ret.size());

        Collections.reverse(ret);
        for (int i = 0; i < ret.size(); i++) {
            System.out.print(ret.get(i)+1+" ");
        }






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
        new B_11779().solve();
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



