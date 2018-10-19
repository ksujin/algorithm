package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_12851 {

    static Queue<Integer> queue;
    static boolean[] visit;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine = br.readLine().split(" ");
        int startNode = Integer.valueOf(inputLine[0]);
        int endNode = Integer.valueOf(inputLine[1]);


        visit = new boolean[100001];
        //bfs 는 queue 로 풀어야
        queue = new LinkedList<>();
        queue.offer(startNode);
        int shortPath = -1;
        int shortPathCount = 0;
        boolean findAns = false;

        //(0 ≤ N ≤ 100,000)
        while (!queue.isEmpty()){
            shortPath++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                visit[current] = true;
                if (current == endNode) {
                    shortPathCount++;
                    findAns = true;
                } else {
                    //다음 노드 삽입
                    int[] nodeArr = {current-1, current+1, current*2};
                    putNode(nodeArr);
                }
            }
            if (findAns) {
                System.out.println(shortPath);
                System.out.println(shortPathCount);
                return;
            }

        }
    }

    static public void putNode(int[] selectedNodeArr){
        for (int selectedNode : selectedNodeArr) {
            if (0<=selectedNode && selectedNode <=100000 && !visit[selectedNode]){
                queue.offer(selectedNode);
            }
        }
    }
}
