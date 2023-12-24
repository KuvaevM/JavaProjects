//Kuvaev Maksim(2020a)
//10a(Sphere)
//250419
import java.util.Scanner;

public class G {
	static int xComponent[];
	static int yComponent[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double xb = sc.nextDouble();
		double yb = sc.nextDouble();
		double xk = sc.nextDouble();
		double yk = sc.nextDouble();
		double xr = sc.nextDouble();
		double yr = sc.nextDouble();
		double r = sc.nextDouble();
		double a = yk-yb;
		double b = xb-xk;
		double c= xb*yk-xk*yb;
		double d = (a*xr+b*yr+c)/Math.sqrt(a*a+b*b);
		d = Math.abs(d);
		if (d>=r) {
			System.out.println(Math.sqrt((xb-xk)*(xb-xk)+(yb-yk)*(yb-yk)));
			System.exit(0);
		}
		double a1 = (r*r-(yr-yb)*(yr-yb))/((xr-xb)*(xr-xb)-(yr-yb)*(yr-yb));
		double b1 = 1 - a1;
		a1 = Math.sqrt(a1);
		b1 = Math.sqrt(b1);
		double c1 = -a1*xb - b1*yb;
		
		double a2 = (r*r-(yr-yk)*(yr-yk))/((xr-xk)*(xr-xk)-(yr-yk)*(yr-yk));
		double b2 = 1 - a2;
		a2 = Math.sqrt(a2);
		b2 = Math.sqrt(b2);
		double c2 = -a2*xk - b2*yk;
		
		double x1 = (c2*b1-c1*b2)/(a1*b2-a2*b1);
		double y1 = (-a1*x1-c1)/b1;
		
		double s = Math.sqrt((x1-xb)*(x1-xb)+(y1-yb)*(y1-yb));
		s = s+Math.sqrt((x1-xk)*(x1-xk)+(y1-yk)*(y1-yk));
		System.out.println(s);
	}

}
