//Kuvaev Maksim(2020a)
//11a(solution for harmonic)
//140420
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class harmonic {
	static final double dt = 0.002;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("Numbers.txt"));
		PrintWriter writer = new PrintWriter("answer.txt");
		int n = sc.nextInt();
		double w = sc.nextDouble();
		double p0 = sc.nextDouble();
		double v0 = sc.nextDouble();
		double arr[][] = new double[n][n + 1];
		arr[0][0] = 1;
		arr[0][n] = p0;
		arr[1][n] = v0 * dt;
		arr[1][0] = -1;
		arr[1][1] = 1;
		for (int i = 2; i < n; i++) {
			arr[i][i - 2] = 1;
			arr[i][i - 1] = -2 + w * w * dt * dt;
			arr[i][i] = 1;
		}
//		for (int i = 0; i < n; i++) {
//			double divider = arr[i][i];
//			if (arr[i][i] == 0) {
//				int counter = i + 1;
//				while (arr[counter][i] == 0) {
//					counter++;
//				}
//				for (int j = i; j < n + 1; j++) {
//					double g = arr[i][j];
//					arr[i][j] = arr[counter][j];
//					arr[counter][j] = g;
//				}
//			}
//
//			arr[i][i] = arr[i][i] / divider;
//			arr[i][n] = arr[i][n] / divider;
//			int counter = 0;
//			for (int j = i; j < n; j++) {
//				if (j != i) {
//					double f = arr[j][i];
//					for (int k = i; k < n; k++) {
//						arr[j][k] = arr[j][k] - f * arr[i][k];
//						if (k == i + 2) {
//							break;
//						}
//					}
//					System.out.println(arr[i][n]);
//					arr[j][n] = arr[j][n] - f * arr[i][n];
//					System.out.println(f);
//				}
//				counter++;
//				if (counter == 2) {
//					break;
//				}
//			}
//		}
//		for (int i = 0; i < n; i++) {
//			System.out.println(arr[i][n]);
//		}
		for (int i = 0; i < n; i++) {
			double divider = arr[i][i];
			if (arr[i][i] == 0) {
				int counter = i+1;
				while (arr[counter][i]==0) {
					counter++;
					if (counter == i+3) {
						writer.print("Решений нет");
						System.exit(0);
					}
				}
				for (int j = i;j<n+1;j++) {
					double g = arr[i][j];
					arr[i][j] = arr[counter][j];
					arr[counter][j] = g;
				}
			}
			arr[i][i] = arr[i][i] / divider;
			arr[i][n] = arr[i][n] / divider;
			int counter = 0;
			for (int j = i; j < n; j++) {
				if (j != i) {
					double f = arr[j][i];
					for (int k = i; k < n; k++) {
						arr[j][k] = arr[j][k] - f * arr[i][k];
						if (k == i + 2) {
							break;
						}
					}
					arr[j][n] = arr[j][n] - f * arr[i][n];
				}
				counter++;
				if (counter == 3) {
					break;
				}
				
			}
		}
		for (int i = 0; i < n; i++) {
			writer.println(arr[i][n]);
		}
		writer.flush();
		writer.close();
		System.out.println(arr[9999][10000]);
	}

}
