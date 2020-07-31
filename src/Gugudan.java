import java.util.Scanner;

public class Gugudan {
	public static void gugudan() {	
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 단 까지?");
		int maxNum = sc.nextInt();
		System.out.println();
		int maxNum2 = sc.nextInt();
		
		if (maxNum < maxNum2) {
			System.out.println("틀린 입력입니다.");
			System.out.println();
			gugudan();
		}else {
			int num[] = new int[maxNum];
			for(int j = 0; j < num.length; j++) {
				for (int i = 0; i < maxNum2; i++) {
					num[i] = (i+1)*(j+1);
					System.out.println((j+1)+" * "+(i+1)+" = " + num[i]);
				}
				System.out.println();
			}
		}
	}	
}
