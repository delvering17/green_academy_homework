package org.java.homework;

import java.util.Scanner;

public class MZBGame {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        String [] index = {"가위", "바위", "보"};

        String res [][] = {
                {"비김", "패", "승"},
                {"승", "비김", "패"},
                {"패", "승", "비김"},
        };
        while(true) {				// 처음 게임

            System.out.println("가위바위보 게임, 0:가위, 1:바위, 2:보, 9:종료");
            System.out.print("입력:");
            int user = sc.nextInt();

            if (user == 9) {									// 게임 종료
                break;
            }

            int com = (int)(Math.random()*index.length);
            String BeforeRes = res[user][com];					// 이전게임 결과 저장 변수
            System.out.println("게이머: " +index[user]);
            System.out.println("컴퓨터: " +index[com]);
            System.out.println("결과: " + res[user][com]);

            if(res[user][com] == "비김") {						// 처음게임 비김 => 재시작
                System.out.println("비겼습니다. 다시 내주세요");
            }

            while (BeforeRes == "패" || BeforeRes == "승") {  	// 두 번째 게임

                System.out.print("입력:");
                user = sc.nextInt();
                com = (int)(Math.random()*index.length);
                System.out.println("게이머: " +index[user]);
                System.out.println("컴퓨터: " +index[com]);

                if (res[user][com] == "비김") {							// 비김 => 승패 결정
                    System.out.println("최종 결과: " + BeforeRes);			// 이전 게임 이긴 사람이 이김
                    break;
                }

                System.out.println("결과: " + res[user][com]);
                BeforeRes = res[user][com];
            }
        }
        System.out.println("게임종료");
    }
}