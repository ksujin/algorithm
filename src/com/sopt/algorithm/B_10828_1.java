package com.sopt.algorithm;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_10828_1 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int lineCount = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < lineCount; i++) {
            String command = br.readLine();
            switch (command) {
                case "pop":
                    bw.write(stack.empty() ? "-1": String.valueOf(stack.pop()));
                    bw.newLine();
                    break;
                case "size":
                    bw.write(String.valueOf(stack.size()));
                    bw.newLine();
                    break;
                case "empty":
                    bw.write(stack.empty() ? "1": "0");
                    bw.newLine();
                    break;
                case "top":
                    bw.write(stack.empty() ? "-1": String.valueOf(stack.peek()));
                    bw.newLine();
                    break;
                default:
                    StringTokenizer st = new StringTokenizer(command);
                    st.nextToken();
                    int value = Integer.parseInt(st.nextToken());
                    stack.push(value);
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
