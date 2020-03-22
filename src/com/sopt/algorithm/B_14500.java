package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14500 {

    static int shapeXMove[][] = {{0,0,0,0}, {0,0,1,1}, {0,1,2,2}, {0,1,1,2}, {0,0,0,1}};
    static int shapeYMove[][] = {{0,1,2,3}, {0,1,0,1}, {0,0,0,1}, {0,0,1,1}, {0,1,2,1}};
    static int n;
    static int m;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 5; k++) {
                    //원래
                    Node node = new Node(i,j,0,0);

                    Node[] originalShape = node.makeOriginalShape(k);
                    max = calculateMax(max, originalShape);
                    //원래 -> 90도
                    Node[] origin_nine = makeTurn90Shape_(originalShape);
                    max = calculateMax(max, origin_nine);
                    //원래 -> 90도 -> x
                    Node[] origin_nine_x = makeTurnXShape(origin_nine);
                    max = calculateMax(max, origin_nine_x);
                    //원래 -> 90도 -> x -> y
                    Node[] origin_nine_x_y = makeTurnYShape(origin_nine_x);
                    max = calculateMax(max, origin_nine_x_y);
                    //원래 -> 90도 -> y
                    Node[] origin_nine_y = makeTurnYShape(origin_nine);
                    max = calculateMax(max, origin_nine_y);
                    //원래 -> x
                    Node[] origin_x = makeTurnXShape(originalShape);
                    max = calculateMax(max, origin_x);
                    //원래 -> x -> y
                    Node[] origin_x_y = makeTurnYShape(origin_x);
                    max = calculateMax(max, origin_x_y);
                    //원래 -> y
                    Node[] origin_y = makeTurnYShape(originalShape);
                    max = calculateMax(max, origin_y);
                }

            }
        } //for
        System.out.println(max);
    }

    static int calculateMax(int max, Node[] nodes) {
        int total = calculateSum(nodes);
        max = max > total ? max : total;
        return max;
    }

    static int calculateSum(Node[] nodes) {
        int ans = 0;
        if (isShapeInRange(nodes)) {
            for (int l = 0; l < nodes.length; l++) {
                ans += map[nodes[l].xPosition][nodes[l].yPosition];
            }
            return ans;
        }
        return -1;
    }

    static Node[] makeTurn90Shape_(Node[] nodes) {
        Node transfored[] = new Node[4];
        for (int i = 0; i < 4; i++) {
            int newMoveFromStandardX = nodes[i].moveFromStandardY;
            int newMoveFromStandardY = -nodes[i].moveFromStandardX;
            transfored[i] = new Node(nodes[i].originX, nodes[i].originY, newMoveFromStandardX, newMoveFromStandardY);
        }
        return transfored;
    }

    static Node[] makeTurnXShape(Node[] nodes) {
        Node transfored[] = new Node[4];
        for (int i = 0; i < 4; i++) {
            int newMoveFromStandardX = -nodes[i].moveFromStandardX;
            int newMoveFromStandardY = nodes[i].moveFromStandardY;
            transfored[i] = new Node(nodes[i].originX, nodes[i].originY, newMoveFromStandardX, newMoveFromStandardY);
        }
        return transfored;
    }

    static Node[] makeTurnYShape(Node[] nodes) {
        Node transfored[] = new Node[4];
        for (int i = 0; i < 4; i++) {
            int newMoveFromStandardX = nodes[i].moveFromStandardX;
            int newMoveFromStandardY = -nodes[i].moveFromStandardY;
            transfored[i] = new Node(nodes[i].originX, nodes[i].originY, newMoveFromStandardX, newMoveFromStandardY);
        }
        return transfored;
    }


    static class Node {
        int originX;
        int originY;
        int moveFromStandardX;
        int moveFromStandardY;
        int xPosition;
        int yPosition;

        Node(int originX, int originY, int moveFromStandardX, int moveFromStandardY) {
            this.originX = originX;
            this.originY = originY;
            this.moveFromStandardX = moveFromStandardX;
            this.moveFromStandardY = moveFromStandardY;
            this.xPosition = originX + moveFromStandardX;
            this.yPosition = originY + moveFromStandardY;
        }

        Node[] makeOriginalShape(int shape) {
            Node nodes[] = new Node[4];
            for (int i = 0; i < 4; i++) {
                nodes[i] = new Node(
                        originX,
                        originY,
                        shapeXMove[shape][i],
                        shapeYMove[shape][i]);
            }
            return nodes;
        }
    }


    static boolean isShapeInRange (Node[] nodes) {
        boolean ans = true;
        for (int i = 0; i < nodes.length; i++) {
            int x = nodes[i].originX + nodes[i].moveFromStandardX;
            int y = nodes[i].originY + nodes[i].moveFromStandardY;
            ans = ans && isInRange(x,y);
        }
        return ans;
    }
    
    static boolean isInRange (int x, int y) {
        if ( 0<= x && x < n &&0<= y && y < m)
            return true;
        return false;
    }
}
