
//Kuvaev Maksim(2020a)
//10a(Sphere)
//180419
import java.util.Scanner;

public class F {
	static int xComponent[];
	static int yComponent[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double p = sc.nextDouble();
		double hp = sc.nextDouble();
		double s = sc.nextDouble();
		double hs = sc.nextDouble();
		if (p >= s) {
			p = p - s;
			double b = p / (hp - hs);
			double c = -b * hs;
			double x2 = c / -hs;
			double a = -hs * x2;
			c = c + p;
			x2 = -c/a;
			System.out.println(Math.abs(x2));
		}else {
			s = s - p;
//			double c = -b * hs;
//			double x2 = c / -hs;
//			double a = -hs * x2;
//			c = c + p * Math.sqrt(a * a + b * b);
//			x2 = -c/a;
		}

	}
}