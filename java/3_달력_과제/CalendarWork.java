package org.java.homework;

import java.util.Calendar;


class CalendarWork {
    Calendar cld = Calendar.getInstance();

    String [][] cal = new String [12][42] ;		// 달력 틀 [월][일]

    public CalendarWork () {	// 달력 일자 입력 생성자

        for (int i = 0 ; i < cal.length ; i ++) { 			// 달력 배열 초기

            for (int j = 0 ; j < cal[i].length ; j ++) {
                this.cal[i][j] = "";
            }
        }

        cld.set(2022,0,1);		//달력 기준 1월 설정

        for (int a = 0 ; a < cld.getActualMaximum(Calendar.MONTH)+1 ; a++ ) {		// 월 배열 (행)
            for (int b = 0 ; b < 42 ; b++) {										// 일 배열 (열)
                if( ((cld.get(Calendar.DAY_OF_WEEK) != 1) && (b < cld.get(Calendar.DAY_OF_WEEK)-1)) ) { 	// 1일 이전 공백 찍기
                    this.cal[a][b] = "\t";
                } else if (b > (cld.get(Calendar.DAY_OF_WEEK)+ cld.getActualMaximum(Calendar.DATE))-2) {	// 최대 일 이후 공백 찍기
                    this.cal[a][b] = "\t";
                } else {
                    this.cal[a][b] = "" + (b + 2  - cld.get(Calendar.DAY_OF_WEEK) + "\t"); 					// 일자 찍기
                }
            }

            cld.set(Calendar.MONTH, a+1);	// 기준 월+1 설
        }
    }





    void type1 () {
        for (int i = 0 ; i < cal.length ; i ++) {			// 월 찍기

            System.out.println("\t\t\t" + (i + 1) + "월");
            System.out.println();

            for (int j = 0 ; j < cal[i].length ; j ++) {	// 일 찍기
                System.out.print(cal[i][j]);
                if(j % 7 == 6) {							// (모양)7일 째에 줄바꿈
                    System.out.println();
                }

            }

            System.out.println();
        }
    }

    void type2 () {

        for (int i = 0 ; i < 12 ; i ++) {							// 월 표시
            System.out.print("\t\t\t" + ( i + 1 ) + "월" + "\t\t\t\t\t");
        }

        System.out.println();
        System.out.println();

        for (int a = 0 ; a < 42 ; a += 7  ) {						// 일 배열 다음 주차 배수

            for (int i = 0 ; i < cal.length ; i ++) {				// 월 배열

                for ( int j = 0 ; j < 7 ; j ++) { 					// 일 배열
                    System.out.print(cal[i][j+a]);
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }

}


public class CalendarQ1 {

    public static void main(String[] args) {

        CalendarWork cw = new CalendarWork () ;

        cw.type1();
        cw.type2();

    }

}