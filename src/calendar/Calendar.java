package calendar;

import java.util.Scanner;

public class Calendar {
	private static int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return day[month - 1];
	}

	public void printSampleCalendar(int month) {
		System.out.print("  " + "일" + "\t" + "월" + "\t" + "화" + "\t" + "수" + "\t" + "목" + "\t" + "금" + "\t" + "토");
		System.out.println();
		System.out.println("--------------------------------------------------");

		for (int i = 1; i <= day[month - 1]; i++) {
			if (i < 10) {
				System.out.print(" " + i + "\t");
			} else
				System.out.print(i + "\t");
			if (i % 7 == 0) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {

		// 숫자 입력받아 해당 월 일수 출력
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		// 반복할 횟수 입력
		System.out.println("반복할 횟수를 입력하세요.");
		int num = sc.nextInt();
		
		// 강의에서 쓴 array version + loop
		for (int i = 0; i < num; i++) {
			System.out.println("월을 입력해주세요.");
			int month = sc.nextInt();
			
			System.out.printf("%d월은 %d일 까지 있습니다.", month, cal.getMaxDaysOfMonth(month));
			System.out.println();
			cal.printSampleCalendar(month);			
			System.out.println();
		}
		System.out.println("Bye~");

		// 조건문 활용한 코드
		/*
		 * int days = 0; if (month < 1 || month > 12) { System.out.println("오류입니다"); }
		 * else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
		 * || month == 10 || month == 12) { days = 31;
		 * System.out.printf("%d월은 %d까지 있습니다.", month, days); } else if (month == 2) {
		 * days = 28; System.out.printf("%d월은 %d까지 있습니다.", month, days); } else { days =
		 * 30; System.out.printf("%d월은 %d까지 있습니다.", month, days); }
		 */
		sc.close();

	}
}
