
//Kuvaev Maksim(2020a)
//10a(Jarvis)
//180519
import java.util.Scanner;

public class E {
	static double xComponent[];
	static double yComponent[];
	static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = -1;
		double sum = 0;
		double counter = 0;
		double S;
		xComponent = new double[n];
		yComponent = new double[n];
		arr = new int[n + 1];
		int number = 0;
		for (int i = 0; i < n; i++) {
			xComponent[i] = sc.nextInt();
			yComponent[i] = sc.nextInt();
			if (min == -1) {
				min = 0;
			}
			if (xComponent[i] < xComponent[min]) {
				min = i;
			}
			if ((xComponent[i] == xComponent[min]) && (yComponent[i] < yComponent[min])) {
				min = i;
			}
		}
		arr[0] = min;
		min = (arr[0] + 1) % n;
		for (int i = 0; i < n; i++) {
			S = xComponent[arr[number]] * yComponent[min] - xComponent[min] * yComponent[arr[number]]
					+ xComponent[min] * yComponent[i] - xComponent[i] * yComponent[min]
					+ xComponent[i] * yComponent[arr[number]] - xComponent[arr[number]] * yComponent[i];
			// System.out.println(S);
			if (S < 0) {
				min = i;
			}
		}
		arr[1] = min;
		number++;
//		System.out.println(arr[1]);
		while (arr[number] != arr[0]) {
			min = (arr[number] + 1) % n;
			// System.out.println(arr[number]);
			for (int i = 0; i < n; i++) {
				S = xComponent[arr[number]] * yComponent[min] - xComponent[min] * yComponent[arr[number]]
						+ xComponent[min] * yComponent[i] - xComponent[i] * yComponent[min]
						+ xComponent[i] * yComponent[arr[number]] - xComponent[arr[number]] * yComponent[i];
				if (S < 0) {
					min = i;
				}
			}
			// System.out.println(min);
			number++;
			arr[number] = min;

		}
		for (int i = 0; i < number; i++) {
			sum = sum + Math.sqrt((xComponent[arr[(i + 1) % n]] - xComponent[arr[i]])
					* (xComponent[arr[(i + 1) % n]] - xComponent[arr[i]])
					+ (yComponent[arr[(i + 1) % n]] - yComponent[arr[i]])
							* (yComponent[arr[(i + 1) % n]] - yComponent[arr[i]]));
		}
		System.out.println(sum);
		sum = 0;
		for (int i = 0; i < number; i++) {
			sum = sum + xComponent[arr[i]] * yComponent[arr[(i + 1) % n]]
					- xComponent[arr[(i + 1) % n]] * yComponent[arr[i]];
		}
		System.out.println(sum / 2);
		

	}

}
