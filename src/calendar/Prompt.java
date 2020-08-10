package calendar;

import java.util.Scanner;

public class Prompt {
	private static String PROMPT = "> ";

	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();

		int year = 0;
		int month = 0;

		printMenu();

		String cmd;

		boolean isLoop = true;
		while (isLoop) {
			System.out.println();
			System.out.println("명령(1, 2, 3, h, q)");
			System.out.print(PROMPT);
			cmd = sc.next();
			switch (cmd) {
			case "1": 
				cmdRegister(sc, cal);
				break;
			case "2": 
				searchSchedule(sc, cal);
				break;
			case "3":
				cmdCal(sc, cal, year, month);
				break;
			case "h": 
				printMenu();
				break;
			case "q": 
				isLoop = false;
				break;
			}
		}
		System.out.println();
		System.out.println("Bye!");
		sc.close();
	}

	public void printMenu() {
		System.out.println("+--------------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말      q. 종료");
		System.out.println("+--------------------------+");
	}

	private void cmdCal(Scanner sc, Calendar cal, int year, int month) {
		System.out.println("년도를 입력해주세요.");
		System.out.print("year=> ");
		year = sc.nextInt();
		System.out.println("월을 입력해주세요.");
		System.out.print("month=> ");
		month = sc.nextInt();
		System.out.println();

		if (month < 1 || month > 12 || year < 0) {
			System.out.println("입력 오류입니다.");
			System.out.println();
			return;
		}

		cal.printCalendar(year, month);
	}

	private void searchSchedule(Scanner sc, Calendar cal){
		System.out.println("[일정 검색] 날짜를 입력하세요  (yyyy-MM-dd).");
		System.out.print(PROMPT);
		sc.nextLine();
		String date = sc.next();
		cal.searchPlan(date);
	}

	private void cmdRegister(Scanner sc, Calendar cal) {
		System.out.println("[새 일정 등록] 날짜를 입력하세요 (yyyy-MM-dd).");
		System.out.print(PROMPT);
		String date = sc.next();
		System.out.println("일정을 입력하세요.");
		System.out.print(PROMPT);
		sc.nextLine();
		String plan = sc.nextLine();
		cal.registerPlan(date, plan);
		System.out.println(plan + " 일정이 등록되었습니다.");
	}

	public static void main(String[] args) {
		Prompt prompt = new Prompt();
		prompt.runPrompt();
	}
	
	
}
