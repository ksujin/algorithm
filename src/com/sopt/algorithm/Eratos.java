package com.sopt.algorithm;


/*import java.util.ArrayList;
import java.util.Scanner;

public class Eratos {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int inputCount = scn.nextInt();
        int primeCount = 0;
        ArrayList<Boolean> primeList = new ArrayList<>();
        primeList.add(false);
        primeList.add(false);

        for (int j = 2; j <= 1000; j++)
            primeList.add(j, true);

        for (int j = 2; (j * j) <= 1000; j++) {
            if (primeList.get(j)) {
                for (int k = j * j; k <= 1000; k += j) primeList.set(k, false);
            }
        }

        for (int i = 0; i < inputCount; i++) {
            int input = scn.nextInt();
            if (primeList.get(input)) {
                primeCount++;
            }

        }
        System.out.println(primeCount);


    }
}*/
