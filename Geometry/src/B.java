//Kuvaev Maksim(2020a)
//10a(polygon)
//180419
import java.util.Scanner;

public class B {
	static int xComponent[];
	static int yComponent[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		xComponent = new int[n];
		yComponent = new int[n];
		int sign;
		int sign2;
		for (int i = 0; i < n; i++) {
			xComponent[i] = sc.nextInt();
			yComponent[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			sign = (yComponent[i] - yComponent[(i + 1) % n]) * xComponent[(i + 2) % n]
					+ (xComponent[(i + 1) % n] - xComponent[i]) * yComponent[(i + 2) % n]
					+ (xComponent[i] * yComponent[(i + 1) % n] - xComponent[(i + 1) % n] * yComponent[i]);
			for (int j = 0; j < n; j++) {
				sign2 = (yComponent[i] - yComponent[(i + 1) % n]) * xComponent[j]
						+ (xComponent[(i + 1) % n] - xComponent[i]) * yComponent[j]
						+ (xComponent[i] * yComponent[(i + 1) % n] - xComponent[(i + 1) % n] * yComponent[i]);
				if (sign * sign2 < 0) {
					System.out.println("NO");
					System.exit(0);
				}
			}
		}
		System.out.println("YES");

	}
}