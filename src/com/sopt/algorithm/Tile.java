package com.sopt.algorithm;/*package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Tile {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String inputCountStr = scn.nextLine();
		Integer inputCount = Integer.parseInt(inputCountStr);
		
		ArrayList<Integer> tile = new ArrayList<>();
		tile.add(1);
		tile.add(2);
		for (int i = 0; i < 1000; i++) {
			tile.add((tile.get(i) + tile.get(i+1))%10007);
		}
		
		Integer result = tile.get(inputCount-1);
		System.out.println(result);
	}

}*/
