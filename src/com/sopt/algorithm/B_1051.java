package com.sopt.algorithm;

import java.util.Scanner;

public class B_1051 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int column = scn.nextInt();
        int inputArray[][] = new int[row+2][column+2];

        //방 채우기
        for (int i = 1; i <= row; i++) {
            String temp = scn.next();
            for (int j = 1; j <= column ; j++) {
                inputArray[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j-1)));
            }
        }

        int maxSize = 1;
        for (int i = 1; i <= row ; i++) {
            for (int j = 1; j <= column ; j++) {
                //가로/세로 중 더 적게 남은 것 찾음. 정사각형 만들어야 하니까
                int min = Math.min(row-i, column-j); //min 2
                if(min == 0 ) break;  //사이즈가 1인것이므로 더 큰게 나올 수 없음.
                for (int k = 1; k <= min ; k++) {
                    int a = inputArray[i][j];
                    int b = inputArray[i][j+k];
                    int c = inputArray[i+k][j];
                    int d = inputArray[i+k][j+k];
                   // System.out.println("현재 기준 점은 i = " +i+", j = "+j+" 이고 크기는 " +(k+1)+"이며 각 꼭지점은 a = " +a+", b = "+b+", c ="+c+", d = "+d+"이다 ");
                    if(a == b && b == c && c == d){
                        int size = (k+1)*(k+1);
                        maxSize = Math.max(maxSize, size);
                        //System.out.println("현재 기준 점은 i = " +i+", j = "+j+" 이고 크기와 최대 크기는 각각 " +size+", "+ maxSize+"이며 각 꼭지점은 a = " +a+", b = "+b+", c ="+c+", d = "+d+"이다 ");
                    }

                }


            }
        }
        System.out.println(maxSize);




    }
}