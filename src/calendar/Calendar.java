package calendar;

import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) {
		System.out.println("Hello, Calendar");
		System.out.println();
		System.out.print("  "+"일" + "\t" + "월" + "\t" + "화" + "\t" + "수" + "\t" + "목" + "\t" + "금" + "\t" + "토");
		System.out.println();
		System.out.println("--------------------------------------------------");

		for (int i = 1; i < 32; i++) {
			if (i<10) {
				System.out.print(" "+i + "\t");
			}else 
				System.out.print(i + "\t");
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		// 숫자 입력받아 해당 월 일수 출력 
		Scanner sc = new Scanner(System.in);
		int day=0;
		
		System.out.println();
		System.out.println();
		
		System.out.println("월을 입력해주세요");
		int month = sc.nextInt();
		
		if (month <1 || month>12) {
			System.out.println("오류입니다");			
		} else if(month == 1|| month ==3|| month ==5|| month ==7|| month ==8
				|| month ==10|| month ==12) {
			day=31;
			System.out.printf("%d월은 %d까지 있습니다." ,month, day);
		} else if(month ==2) {
			day=28;
			System.out.printf("%d월은 %d까지 있습니다." ,month, day);
		} else {
			day=30;
			System.out.printf("%d월은 %d까지 있습니다." ,month, day);
		}
		sc.close();
		
	}
}
