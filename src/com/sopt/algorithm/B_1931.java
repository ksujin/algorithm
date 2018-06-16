package com.sopt.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B_1931 {

    public static void main(String args[]){
        new B_1931().solve();
    }

    public void solve(){
        Scanner scn = new Scanner(System.in);
        int meetingCount = scn.nextInt();
        meeting meetings[] = new meeting[meetingCount];

        for (int i = 0; i < meetingCount; i++) {
            int start = scn.nextInt();
            int end = scn.nextInt();
            meetings[i] = new meeting(start, end);

        }

        Arrays.sort(meetings, new compare());

        int ans = 0;

        int last = 0;
        for(meeting current : meetings){

            int currentLast = current.end;
            int currentStart = current.start;
            if (currentStart >= last){
                ans++;
                last = currentLast;
            }
        }

        System.out.println(ans);
    }


    class meeting {
        int start;
        int end;
        meeting(int start_, int end_){
            this.start = start_;
            this.end = end_;
        }


    }

    public class compare implements Comparator<meeting>{
        @Override
        public int compare(meeting o1, meeting o2) {
            if(o1.end < o2.end){
                return -1;
            } else if(o1.end == o2.end){
                if(o1.start < o2.start) return -1;
                else return 0;

            } else {
                return 1;
            }

        }
    }

}
