package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class line3 {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> userData = new HashMap<>();

        int inputCount = scn.nextInt();
        scn.nextLine();
        for (int i = 0; i < inputCount; i++) {
            String a = scn.nextLine();
            String[] line = a.split("/");
            if(i == inputCount-1){
                System.out.println(a);
            }
            if (line.length == 3) {
                //사용자 id post
                if (line[0].equals("POST ")){
                    String userName = line[2];
                    if (userData.containsKey(userName)){
                        System.out.println("403 FORBIDDEN");
                        continue;
                    } else {
                        userData.put(userName, "");
                        System.out.println("201 CREATED");
                        continue;
                    }
                } else {
                    //get 으로 요청
                    System.out.println("405 METHOD_NOT_ALLOWED");
                    continue;
                }
            } else if (line.length == 4){
               // System.out.println(line);
                if (line[3].contains("value")){
                    //POST /users/CONY/data value=TEST_DATA
                    if (line[0].equals("GET ")){
                        System.out.println("405 METHOD_NOT_ALLOWED");
                        continue;
                    } else {
                        String userName = line[2];
                        if (userData.containsKey(userName)){
                            String[] userData1 = line[3].split("value=");
                            userData.put(userName, userData1[1]);
                            System.out.println("200 OK");
                            continue;
                        } else {
                            System.out.println("403 FORBIDDEN");
                            continue;
                        }
                    }

                } else {
                    //value 를 안포함 함
                    //GET /users/CONY/data
                    if(line[0].equals("POST ")){
                        System.out.println("405 METHOD_NOT_ALLOWED");
                        continue;
                    } else {
                        String userName = line[2];
                        if (userData.containsKey(userName)){

                            if(userData.get(userName).equals("")){
                                //저장된 데이터 없음
                                System.out.println("404 NOT_FOUND");
                                continue;
                            } else {
                                String userData1 = userData.get(userName);
                                System.out.println("200 OK "+userData1);
                                continue;
                            }
                        } else {
                            System.out.println("403 FORBIDDEN");
                            continue;
                        }
                    }
                }
            } else {
                System.out.println("404 NOT_FOUND");
                continue;
            }

        } //for



    }
}
