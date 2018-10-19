package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_13549 {
    static boolean[] visit;
    static Queue<Node> queue;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int startNode = Integer.valueOf(line[0]);
        int endNode = Integer.valueOf(line[1]);
        visit = new boolean[100001];
        queue = new LinkedList<>();
        //int shortestTime = -1;
        boolean findAns = false;
        queue.offer(new Node(startNode, 0));
        int min = 100002;
        while (!queue.isEmpty()){
            //shortestTime++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                visit[current.node] = true;
                if (current.node == endNode){
                    findAns = true;
                    min = Math.min(min, current.depth);
                } else {
                    Node[] nodeArr = {new Node(current.node+1, current.depth+1), new Node(current.node-1, current.depth+1), new Node(current.node*2, current.depth)};
                    putNode(nodeArr);
                }
            }

            if (findAns){
                System.out.println(min);
                return;
            }
        }

    }
    static public void putNode(Node[] selectedNodeArr){
        for (Node selectedNode : selectedNodeArr) {
            if (0<=selectedNode.node && selectedNode.node <=100000 && !visit[selectedNode.node]){
                queue.offer(new Node(selectedNode.node, selectedNode.depth));
            }
        }
    }



}

class Node{
    int node;
    int depth;
    Node(int node, int depth){
        this.node = node;
        this.depth = depth;
    }
}


