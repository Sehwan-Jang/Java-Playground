package calendar;

public class Calendar {
	private static final int[] DAY = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_DAY = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String[] FIRST_DAY = { "SU", "MO", "TU", "WE", "TH", "FR", "SA" };

	public boolean isLeapYear(int year) {
		if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
			return true;
		else
			return false;
	}

	public int getMaxDayOfMonth(int year, int month) {
		if (isLeapYear(year))
			return LEAP_DAY[month - 1];
		else
			return DAY[month - 1];
	}

	public int getFirstDay(String fday) {
		int firstDay = 0;
		String day = fday.toUpperCase();
		for (int i = 0; i < FIRST_DAY.length; i++) {
			if (day.equals(FIRST_DAY[i])) {
				firstDay = i;
				break;
			}
		}
		return firstDay;
	}

	public void printCalendar(int year, int month, String day) {
		System.out.printf("                <<%4d년%7d월>>%n", year, month);
		System.out.print("SU" + "\t" + "MO" + "\t" + "TU" + "\t" + "WE" + "\t" + "TH" + "\t" + "FR" + "\t" + "SA");
		System.out.println();
		System.out.println("--------------------------------------------------");

		int maxDay = getMaxDayOfMonth(year, month);
		int firstDay = getFirstDay(day);

		for (int i = 0; i < firstDay; i++) {
			System.out.print("  " + "\t");
		}

		for (int i = 1; i <= maxDay; i++) {
			if (i < 10) {
				System.out.print(" " + i + "\t");
			} else
				System.out.print(i + "\t");
			if ((firstDay + i) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();

	}
}
