package calendar;

public class Calendar {
	public static void main(String[] args) {
		System.out.println("Hello, Calendar");
		System.out.print("일"+"\t"+"월"+"\t"+"화"+"\t"+"수"+"\t"
				+"목"+"\t"+"금"+"\t"+"토");
		System.out.println();
		System.out.println("--------------------------------------------------");
		for (int i = 1; i < 32; i++) {
			int j = i;
			System.out.print(j+ "\t");
			if (j%7 ==0) {
				System.out.println();
			}
		}
	}
}
