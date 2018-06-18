package com.sopt.algorithm;


import java.util.*;

public class B_1744 {
    //1보다 낮은수 곱하면 항상 최대, 1보다 높은수 곱하면 항상 최대
    public static void main(String args[]){

        Scanner scn = new Scanner(System.in);

        int inputCount = scn.nextInt();

        ArrayList<Integer> minusArr = new ArrayList<>();
        ArrayList<Integer> plusArr = new ArrayList<>();
        for (int i = 0; i < inputCount; i++) {
            int temp = scn.nextInt();
            if(temp <= 0){
                minusArr.add(temp);
            } else {
                plusArr.add(temp);
            }
        }

        Collections.sort(minusArr, new ascending());
        Collections.sort(plusArr, new descending());

        addArr(minusArr);
        addArr(plusArr);



        int ans = addArr(minusArr) + addArr(plusArr);

        System.out.println(ans);

    }

    public static int addArr(ArrayList<Integer> arrayList){

        int ans2 = 0;

        if(arrayList.size() % 2 == 0){
            //even
            for (int i = 0; i < arrayList.size()-1 ; i += 2) {
                ans2 += arrayList.get(i)*arrayList.get(i+1);
                if (arrayList.get(i+1) == 1){
                    ans2 += 1;
                }
            }
        } else {
            //odd
            for (int i = 0; i < arrayList.size()-2; i += 2) {
                ans2 += arrayList.get(i)*arrayList.get(i+1);
                if (arrayList.get(i+1) == 1){
                    ans2 += 1;
                }
            }
            ans2 += arrayList.get(arrayList.size()-1);
        }

        return ans2;
    }

}
 class ascending implements Comparator<Integer> {


    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 < o2) return -1; else return 1;
    }
}

class descending implements Comparator<Integer> {


    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) return -1; else return 1;
    }
}

