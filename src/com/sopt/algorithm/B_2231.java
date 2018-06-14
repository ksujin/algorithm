/*package com.sopt.algorithm;

import java.util.Scanner;

public class B_2231 {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int inputNum = scn.nextInt();
        int result = -1;
        if (1 <= inputNum && inputNum <= 10){
            System.out.println(0);
        } else if (10 < inputNum && inputNum <= 100) {
            loop:
            for (int i = 1; i < 10; i++) {
                //11a + 2b  = inputNum
                int temp = inputNum-(11*i);
                for (int j = 0; j < 10; j++) {
                    if(temp-(2*j) == 0){
                        result = 10*i+j;
                        System.out.println(result);
                        break loop;
                    }
                }
            }

            if (result == -1){
                System.out.println(0);
            }
        } else if (100 < inputNum && inputNum <= 1000) {
            loop:
            for (int i = 1; i < 10; i++) {
                //101a + 11b + 2c  = inputNum
                int temp = inputNum-(101*i); //115
                for (int j = 0; j < 10; j++) {
                    int temp2 = temp - 11*j;
                   // System.out.println("i가 " + i + "이고 j가 " + j + "일때 temp2는 " +  temp2);
                    for (int k = 0; k < 10 ; k++) {
                        if(temp2-(2*k) == 0){
                            result = 100*i+10*j+k;
                            System.out.println(result);
                            break loop;
                        }
                    }
                }
            }
            if (result == -1){
                System.out.println(0);
            }
        } else if (1000 < inputNum && inputNum <= 10000) {
            loop:
            for (int i = 1; i < 10; i++) {
                //1001a + 101b + 11c + 2d  = inputNum
                int temp = inputNum-(1001*i); //115
                for (int j = 0; j < 10; j++) {
                    int temp2 = temp - 101*j;
                    for (int k = 0; k < 10 ; k++) {
                        int temp3 = temp2 - 11*k;
                        for (int l = 0; l < 10; l++) {
                            if(temp3-(2*l) == 0){
                                result = 1000*i+100*j+10*k+l;
                                System.out.println(result);
                                break loop;
                            }
                        }
                    }
                }
            }
            if (result == -1){
                System.out.println(0);
            }

        } else if (10000 < inputNum && inputNum <= 100000) {
            loop:
            for (int i = 1; i < 10; i++) {
                //10001a + 1001b + 101c + 11d + 2e  = inputNum
                int temp = inputNum-(10001*i); //115
                for (int j = 0; j < 10; j++) {
                    int temp2 = temp - 1001*j;
                    for (int k = 0; k < 10 ; k++) {
                        int temp3 = temp2 - 101*k;
                        for (int l = 0; l < 10; l++) {
                            int temp4 = temp3 - 11*l;
                            for (int m = 0; m < 10 ; m++) {
                                if(temp4-(2*m) == 0){
                                    result = 10000*i+1000*j+100*k+10*l+m;
                                    System.out.println(result);
                                    break loop;
                                }
                            }
                        }
                    }
                }
            }
            if (result == -1){
                System.out.println(0);
            }

        } else if (100000 < inputNum && inputNum <= 1000000) {
            loop:
            for (int i = 1; i < 10; i++) {
                //100001a + 10001b + 1001c + 101d + 11e + 2f  = inputNum
                int temp = inputNum-(100001*i); //115
                for (int j = 0; j < 10; j++) {
                    int temp2 = temp - 10001*j;
                    for (int k = 0; k < 10 ; k++) {
                        int temp3 = temp2 - 1001*k;
                        for (int l = 0; l < 10; l++) {
                            int temp4 = temp3 - 101*l;
                            for (int m = 0; m < 10 ; m++) {
                                int temp5 = temp4 - 11*m;
                                for (int n = 0; n < 10 ; n++) {
                                    if(temp5-(2*n) == 0){
                                        result =100000*i+10000*j+1000*k+100*l+10*m+n;
                                        System.out.println(result);
                                        break loop;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (result == -1){
                System.out.println(0);
            }

        }

    }
}
*/