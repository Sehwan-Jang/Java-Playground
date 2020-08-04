package calendar;

public class Calendar {
	private static final int[] DAY = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_DAY = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public void printCalendar(int year, int month) {
		System.out.printf("                <<%4d년%7d월>>%n", year, month);
		System.out.print("SU" + "\t" + "MO" + "\t" + "TU" + "\t" + "WE" + "\t" + "TH" + "\t" + "FR" + "\t" + "SA");
		System.out.println();
		System.out.println("--------------------------------------------------");

		if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
			for (int i = 1; i <= LEAP_DAY[month - 1]; i++) {
				if (i < 10) {
					System.out.print(" " + i + "\t");
				} else
					System.out.print(i + "\t");
				if (i % 7 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			System.out.println();
		} else {
			for (int i = 1; i <= DAY[month - 1]; i++) {
				if (i < 10) {
					System.out.print(" " + i + "\t");
				} else
					System.out.print(i + "\t");
				if (i % 7 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			System.out.println();
		}

	}
}
