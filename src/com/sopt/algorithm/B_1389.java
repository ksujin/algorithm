package com.sopt.algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1389 {

    static Queue<Integer> q;
    static boolean[] visit;
    static int userNum;
    static int pathLevel[][];
    static int relation[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        userNum = Integer.parseInt(st.nextToken());
        int relationNum = Integer.parseInt(st.nextToken());
        relation = new int[userNum+1][userNum+1];

        visit = new boolean[userNum+1];
        pathLevel = new int[userNum+1][userNum+1];

        for (int i = 0; i < relationNum; i++) {
            st = new StringTokenizer(br.readLine());
            int userA = Integer.parseInt(st.nextToken());
            int userB = Integer.parseInt(st.nextToken());
            relation[userA][userB] = 1;
            relation[userB][userA] = 1;
        }

        int min = 987654321;
        int ans = 0;
        for (int root = 1; root <= userNum ; root++) {
            int levelSum = bfs(root);
            if (levelSum < min) {
                min = levelSum;
                ans = root;
            }
        }
        System.out.println(ans);
    }

    static int bfs(int startPoint) {
        q = new LinkedList<>();
        visit = new boolean[userNum+1];

        q.add(startPoint);
        visit[startPoint] = true;
        int level = 0;

        while (!q.isEmpty()) {
            //System.out.println("========== level: " + level + " ==========");
            int qSize = q.size();
            //같은 level 탐색
            for (int i = 0; i < qSize; i++) {
                int root = q.poll();
                //System.out.println("현재 root는 "+root);

                //인접 영역 탐색
                for (int j = 1; j <= userNum ; j++) {
                    //System.out.println("relation["+root+"]"+"["+j+"] = "+relation[root][j]);
                    if (relation[root][j] == 1 && !visit[j]) {
                        q.add(j);
                        visit[j] = true;
                        pathLevel[startPoint][j] = level+1;
                        //System.out.println("이웃한 노드들이 들어감 "+j);
                        //System.out.println("해당 level: "+level);
                    }
                } //for j
            }//for i
            level++;
        } // while

        int sum = 0;
        for (int i = 1; i <= userNum ; i++) {
            //System.out.println(startPoint+"에서 "+i+"까지는 "+temp+" level");
            sum += pathLevel[startPoint][i];
        }
        return sum;
    }
}
