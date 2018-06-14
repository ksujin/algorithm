package com.sopt.algorithm;

import java.util.Scanner;

public class A_1978 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int inputCountStr = scn.nextInt();
		int primeCount = 0;
		for (int i = 0; i < inputCountStr; i++) {
			int prime = scn.nextInt();
			int primeMinusOne = prime - 1;
			int primeMinusOneforK = primeMinusOne;
			int k = 0;
			int q = 0;
			int a = 2;
			if (primeMinusOne>2 && primeMinusOneforK % 2 == 0) {
				while (primeMinusOneforK % 2 == 0) {
					k++;
					primeMinusOneforK = primeMinusOneforK / 2;
				}
			} 

			q = primeMinusOne / (int) Math.pow(2, k);

			if ((int) Math.pow(2, q) % prime == 1) {
				primeCount++;

			} else {

				for (int j = 1; j <= k; j++) {
					int exp = (int) Math.pow(2, j - 1);
					if ((int) Math.pow(a, exp * q) % prime == prime - 1) {
						primeCount++;
					}
				}
			}
		}
		System.out.println(primeCount);
	}
}
