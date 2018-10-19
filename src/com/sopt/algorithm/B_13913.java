package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_13913 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine = br.readLine().split(" ");
        int startNode = Integer.valueOf(inputLine[0]);
        int endNode = Integer.valueOf(inputLine[1]);

        boolean[] visit = new boolean[100001];
        int[] parent  = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visit[startNode] = true;
        int shortPath = 0;

        if (startNode == endNode){
            System.out.println("0 \n"+startNode);
            return;
        }

        outerloop:
        while (!queue.isEmpty()) {
            shortPath++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int current = queue.poll();
                //다음 노드 삽입
                int[] next = {current - 1, current + 1, current * 2};
                for (int i = 0; i < 3; i++) {
                    if (0 <= next[i] && next[i] <= 100000 && !visit[next[i]]) {
                        //들어가자마자 true 로 check
                        visit[next[i]] = true;
                        //이전 노드 가리키기 위함
                        parent[next[i]] = current;
                        queue.add(next[i]);
                        //만약 다음에 넣을게 endNode 라면 최단 경로 찾은것. 그냥 끝내버림
                        if (next[i] == endNode) {
                            break outerloop;
                        }
                    }
                }
            }
        }

        int depth = shortPath;
        StringBuilder sb = new StringBuilder();
        System.out.println(+depth);
        int temp = endNode;
        int[] ret = new int[100001];
        for (int i = depth-1; i >= 0 ; i--) {
            ret[i] = parent[temp];
            temp = parent[temp];
        }
        for (int i = 0; i < depth; i++) {
            sb.append(ret[i]).append(" ");
        }
        sb.append(endNode);
        System.out.println(sb);

    }

}
