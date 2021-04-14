package com.programmers.algorithm;

public class P_43162 {
    public static void main(String[] args) {
        int n = 3;

        int[][] computers = {
                {1, 1, 0}, {1, 1, 1}, {0, 1, 1} //1
                //{1, 1, 0}, {1, 1, 0}, {0, 0, 1} //2
        };


        solution(n, computers);
    }


    public static int solution(int n, int[][] computers) {

        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(computers, visited, i);
            }
        }

        System.out.println(answer);
        return answer;
    }


    //https://syundev.tistory.com/158
    public static void dfs(int[][] computers, boolean visited[], int depth) {
        visited[depth] = true;
        int[] neighbors = computers[depth];

        for (int i = 0; i < neighbors.length; i++) {

            if (neighbors[i] == 1 && !visited[i]) {
                dfs(computers, visited,i);
            }
        }
    }
}
