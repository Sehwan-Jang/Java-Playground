package calendar;

import java.util.Scanner;

public class Prompt {

	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();

		int year;
		int month;

		while (true) {
			System.out.println("년도를 입력해주세요. (종료하려면 -1을 입력하세요)");
			System.out.print("year=> ");
			year = sc.nextInt();
			if (year == -1)
				break;
			System.out.println("월을 입력해주세요.");
			System.out.print("month=> ");
			month = sc.nextInt();
			System.out.println();

			if (month < 1 || month > 12 || year < 0) {
				System.out.println("입력 오류입니다.");
				System.out.println();
				continue;
			}

			cal.printCalendar(year, month);
		}
		System.out.println();
		System.out.println("Bye~");

		sc.close();
	}

	public static void main(String[] args) {
		Prompt prompt = new Prompt();
		prompt.runPrompt();
	}
}
