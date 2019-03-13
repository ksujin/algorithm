package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_14226 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        boolean visited[][] = new boolean[1001][1001]; //visited[monitor][clipboard]

        Queue<Node_14226> queue = new LinkedList<>();
        queue.add(new Node_14226(1,0,0));

        while (!queue.isEmpty()){
            Node_14226 current = queue.poll();
            int monitor = current.monitor;
            int clipboard = current.clipboard;
            int time = current.time;

            if(monitor == num){
                System.out.println(time);
                return;
            }

            //copy
            if(monitor <= 1000 && !visited[monitor][monitor]){
                queue.add(new Node_14226(monitor, monitor, time+1));
                visited[monitor][monitor] = true;
            }

            //paste
            if(clipboard > 0 && monitor+clipboard <= 1000 && clipboard <= 1000 && !visited[monitor+clipboard][clipboard]  ){
                queue.add(new Node_14226(monitor+clipboard, clipboard, time+1));
                visited[monitor+clipboard][clipboard] = true;
            }

            //delete
            if(monitor > 0  && monitor-1<=1000 && clipboard <= 1000 && !visited[monitor-1][clipboard]){
                queue.add(new Node_14226(monitor-1, clipboard, time+1));
                visited[monitor-1][clipboard] = true;
            }

        }

    }
}

class Node_14226 {
    int monitor;
    int clipboard;
    int time;

    Node_14226( int monitor, int clipboard, int time) {
        this.monitor = monitor;
        this.clipboard = clipboard;
        this.time = time;
    }

}
