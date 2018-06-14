package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class B_2331 {


    public static void main(String args[]){
        new B_2331().solve();
    }

    private void solve(){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int p = scn.nextInt();

        ArrayList<Integer> arr = new ArrayList();
        arr.add(a);
        foo: while(true){
           // System.out.println("input one is :" + a);
            double sum = 0;
            while (a != 0){
                int number = a%10;
                //System.out.println("number is" + number);
                sum += Math.pow((double)(number),(double)(p));
                a = a/10;
            }
            //System.out.println("sum is "+sum);
            int next = (int)sum;


            for (int i = 0; i < arr.size(); i++) {
                if (next == arr.get(i)){
                    System.out.println(arr.indexOf(next));
                    break foo; //while 빠져나가야함
                }
            }
            arr.add(next);
            a = (int)sum;
        }




    }
}
