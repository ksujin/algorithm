package com.sopt.algorithm;
import java.util.Scanner;

public class B_14467 {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int inputCount  = scn.nextInt();
        int cowArray[] = new int[11];
        for (int i = 1; i <= 10 ; i++) {
            cowArray[i] = 2;
        }

        int movingCount = 0;
        for (int i = 1; i <= inputCount; i++) {
            int cowNum = scn.nextInt();
            int cowLocation = scn.nextInt();

            //처음 소 위치 입력된 경우
            if(cowArray[cowNum] == 2){
                cowArray[cowNum] = cowLocation;
            } else if (cowArray[cowNum] != cowLocation){
                cowArray[cowNum] = cowLocation;
             //   System.out.println(cowNum+"번째 소는 "+i+"번째에서 위치가 달라졌다");
                movingCount++;
            } else {
                //소의 위치가 같을 때
                cowArray[cowNum] = cowLocation;
            }
        }
        System.out.println(movingCount);

    }
}
