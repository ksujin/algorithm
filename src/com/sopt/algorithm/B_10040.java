package com.sopt.algorithm;/*package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_10040 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int gameCount = scn.nextInt();
		int judgeCount = scn.nextInt();
		ArrayList<Integer> gameList = new ArrayList<>();
		ArrayList<Integer> judgeList = new ArrayList<>();
		ArrayList<Integer> voteList = new ArrayList<>();

		for (int i = 0; i < gameCount; i++) {
			String str = scn.next();
			gameList.add(Integer.parseInt(str));
		}
		for (int i = 0; i < judgeCount; i++) {
			String str = scn.next();
			judgeList.add(Integer.parseInt(str));
		}
		for (int i = 0; i < gameCount; i++) {
			voteList.add(0);
		}
		
		for (int i = 0; i < judgeCount ; i++) {
			for (int j = 0; j < gameCount; j++) {
				if(gameList.get(j) <= judgeList.get(i)){
					voteList.set(j, voteList.get(j)+1);
					break;
				}
			}
		}
		int max = Collections.max(voteList);
		int maxIndex = voteList.indexOf(max)+1;
		System.out.println(maxIndex);
		
	}

}*/
