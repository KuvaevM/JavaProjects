//Kuvaev Maksim(2020a)
//10a(Line)
//180419
import java.util.Scanner;

public class A {
	static int xComponent[];
	static int yComponent[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int n = sc.nextInt();
		xComponent = new int[n];
		yComponent = new int[n];
		for (int i = 0;i<n;i++) {
			xComponent[i] = sc.nextInt();
			yComponent[i] = sc.nextInt();
		}
		int sign = (y1-y2)*xComponent[0]+(x2-x1)*yComponent[0]+(x1*y2-x2*y1);
		for (int i = 1;i<n;i++) {
			if (sign*((y1-y2)*xComponent[i]+(x2-x1)*yComponent[i]+(x1*y2-x2*y1))<0) {
				System.out.println("no");
				System.exit(0);
			}
		}
		System.out.println("yes");

	}

}
