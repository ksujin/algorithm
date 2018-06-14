/*package com.sopt.algorithm;

import java.util.Scanner;

public class B_2231_2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int inputNum = scn.nextInt();
        //들어오는 숫자 = 생성자 + 생성자의 1번째 자릿수 + 생성자의 2번째 자릿수 ....
        //생성자 = 들어오는 숫자 - ( 생성자의 1번째 자릿수 + 생성자의 2번째 자릿수... )
        //각 자릿수의 최대는 9를 초과할 수 없으므로 들어오는 숫자 - (9*들어오는 숫자의 자릿수)부터 체크해가면서 생성자를 찾아나가면 됨
        int coi = 0;
        int con = inputNum;
        while (con != 0){
            //100의 자리면 10의자리, 1의자리 순으로 줄 것이고, 1의자리를 돌때는 con == 0 이 될 것
            con = con / 10;
            coi++; //들어온 숫자의 자릿수
        }
        //그리고 생성자는 무조건 들어온 숫자보다는 작을 것이기 때문에 inputNum 보다 작음으로 설정해주면 됨
        for (int i = (inputNum-coi*9); i < inputNum ; i++) {
            int generator = i;
            int temp = i;
            while (temp != 0){
                generator += temp % 10; //작은 자리 부터 나오게 됨
                temp = temp / 10;
            }
            if(generator == inputNum){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);


    }
}*/
