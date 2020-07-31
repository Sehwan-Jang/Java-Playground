import java.util.Scanner;

public class Gugudan {
	public static void gugudan(int x) {	
		for (int i = 1; i < 10; i++) {
			System.out.println(x + " * "+ i + " = " + x*i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.println("출력할 단은?");
		num = sc.nextInt();
		
		gugudan(num);
	}

}
