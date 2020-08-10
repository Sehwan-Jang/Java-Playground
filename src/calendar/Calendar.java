package calendar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Calendar {
	private static final int[] DAY = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_DAY = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private HashMap<Date, ArrayList<String>> schedule;
	private ArrayList<String> list = new ArrayList<String>();
	private static final String SAVE_FILE = "calendar.dat";

	public Calendar() {
		schedule = new HashMap<Date, ArrayList<String>>();
		File f = new File(SAVE_FILE);
		if (!f.exists()) {
			System.out.println("no save file");
			return;
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(SAVE_FILE));
			String strCurrentLine = null;
			while ((strCurrentLine = br.readLine()) != null) {
				String[] source = strCurrentLine.split("[.]");
				String sDate = source[0];
				String tmp_detail = source[1].replace("[", "").replace("]", "");
				String[] detail = tmp_detail.split(",");
				PlanItem p = new PlanItem(schedule,sDate);
				ArrayList<String> tmp_list = p.addPlanList(schedule, sDate, detail[detail.length-1]);
				schedule.put(p.getDate(), tmp_list);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void registerPlan(String strDate, String plan) {
		PlanItem p = new PlanItem(schedule, strDate);
		list = p.addPlanList(schedule, strDate, plan);
		schedule.put(p.getDate(), list);

		// 일정 파일로 저장
		File f = new File(SAVE_FILE);
		String item = p.saveString();
		try {
			FileWriter fw = new FileWriter(f, true); // true 넣아야 덮어쓰기 안됨
			fw.write(item);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void searchPlan(String strDate) {
		Date date = PlanItem.getDatefromString(strDate);

		if (schedule.containsKey(date)) {
			System.out.println(schedule.get(date).size() + "개의 일정이 있습니다.");
			for (int i = 0; i < schedule.get(date).size(); i++) {
				System.out.println((i + 1) + ". " + schedule.get(date).get(i));
			}
		} else
			System.out.println("일정이 없습니다.");
	}

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

	// calculate first day of month automatically
	public int getFirstDay(int year, int month) {
		int dayCount = 1; // 0001/Jan/1 = Monday
		for (int i = 1; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			dayCount += delta;
		}

		for (int i = 1; i < month; i++) {
			int delta = getMaxDayOfMonth(year, i);
			dayCount += delta;
		}

		int firstDay = dayCount % 7;
		return firstDay;
	}

	public void printCalendar(int year, int month) {
		System.out.printf("                <<%4d년%5d월>>%n", year, month);
		System.out.print("SU" + "\t" + "MO" + "\t" + "TU" + "\t" + "WE" + "\t" + "TH" + "\t" + "FR" + "\t" + "SA");
		System.out.println();
		System.out.println("--------------------------------------------------");

		int maxDay = getMaxDayOfMonth(year, month);
		int firstDay = getFirstDay(year, month);

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

	public static void main(String[] args) {
		
	}
}
