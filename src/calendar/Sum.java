package calendar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		int a,b;
		String c;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 숫자를 입력하세요.");
		a = sc.nextInt();
		c = sc.next();
		b = Integer.parseInt(c);
		
		System.out.printf("%d와 %d의 합은 %d 입니다.",a,b, a+b);
		sc.close();
	}
}
