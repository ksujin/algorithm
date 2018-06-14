package com.sopt.algorithm;

/*import java.util.ArrayList;
import java.util.Scanner;

public class WhiteSnow {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        ArrayList<Integer> dwarfArray = new ArrayList<>();
        int total = 0;
        for (int j = 0; j < 9; j++) {
            int dwarfNumber = scn.nextInt();
            dwarfArray.add(j,dwarfNumber);
            total = total+dwarfNumber;
        }
        int notMember1 = 0;
        int notMember2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                int notMember = dwarfArray.get(i) + dwarfArray.get(j);
                if(total-notMember== 100){
                    notMember1 = dwarfArray.get(i);
                    notMember2 = dwarfArray.get(j);
                }
            }
        }

        for (int i = 0; i < 9 ; i++) {
            if(dwarfArray.get(i) != notMember1 && dwarfArray.get(i) != notMember2){
                System.out.println(dwarfArray.get(i));
            }
        }

    }
}*/
