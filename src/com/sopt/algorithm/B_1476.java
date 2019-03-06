package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1476 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        int correctE = Integer.valueOf(line[0]);
        int correctS = Integer.valueOf(line[1]);
        int correctM = Integer.valueOf(line[2]);

        //1. Bruteforce
       /* int e = 1;
        int s = 1;
        int m = 1;

        //1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19
        for (int i = 1; i <12000 ; i++) {
            if(e == correctE && s == correctS && m == correctM) {
                System.out.println(i);
                break;
            }

            e++;
            s++;
            m++;

            if(e > 15){
                e = 1;
            }
            if(s > 28) {
                s = 1;
            }
            if(m > 19){
                m = 1;
            }
        }
*/

        //중국인의 나머지 정리 - CRT : chinese remainder theorem
        //-1씩 해서, 0 ≤ E < 15, 0 ≤ S < 28, 0 ≤ M < 19
        //x % 15 = e, x % 28 = s, x % 19 = m 을 만족하는 x를 구함

        int[] mod = {15, 28, 19};

        //1. a[i] = A % mod[i]를 만족하는 a[i]를 구한다
        int[] a = {correctE, correctS, correctM};

        //2. c[i]를 구한다. c[i] = Mod[i]*(inverseof.Mod[i] % mod[i])(Mod[i] = M/mod[i])
        int M = 15*28*19;
        int Mod[] = new int[3];
        for (int i = 0; i < 3; i++) {
            Mod[i] = M/mod[i];
        }

        int c[] = new int[3];
        for (int i = 0; i < 3; i++) {
            c[i] = Mod[i]*modInverse(Mod[i],mod[i]);
        }

        //3. Σ a[i]c[i]
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans += a[i]*c[i];
        }
        ans = ans % M;
        System.out.println(ans == 0 ? M : ans);

    }

    static int modInverse(int a, int m)
    {
        int m0 = m;
        int y = 0, x = 1;

        if (m == 1)
            return 0;

        while (a > 1)
        {
            // q is quotient
            int q = a / m;

            int t = m;

            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;

            // Update x and y
            y = x - q * y;
            x = t;
        }

        // Make x positive
        if (x < 0)
            x += m0;

        return x;
    }

}
