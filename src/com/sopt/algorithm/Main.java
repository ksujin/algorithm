package com.sopt.algorithm;/*package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String inputCountStr = scn.nextLine();
		Integer inputCount = Integer.parseInt(inputCountStr);
		for (int k = 0; k < inputCount; k++) {
			String str = scn.next();
			Integer input = Integer.parseInt(str);

			ArrayList<Integer> zero = new ArrayList<>();
			ArrayList<Integer> one = new ArrayList<>();

			zero.add(1);
			zero.add(0);
			one.add(0);
			one.add(1);

			for (int i = 0; i < 41; i++) {
				zero.add(zero.get(i) + zero.get(i + 1));
				one.add(one.get(i) + one.get(i + 1));
			}

			System.out.println(zero.get(input) + " " + one.get(input));

		}
	}

}*/
