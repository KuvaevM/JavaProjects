//Kuvaev Maksim(2020a)
//11a(solution for linear)
//140420
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class linear {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("Numbers.txt"));
		PrintWriter writer = new PrintWriter("answer.txt");
		int n = sc.nextInt();
		double arr[][] = new double[n][n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n + 1; j++) {
				arr[i][j] = sc.nextDouble();
			}
		}
		for (int i = 0; i < n; i++) {
			double divider = arr[i][i];
			if (arr[i][i] == 0) {
				int counter = i+1;
				while (arr[counter][i]==0) {
					counter++;
				}
				for (int j = i;j<n+1;j++) {
					double g = arr[i][j];
					arr[i][j] = arr[counter][j];
					arr[counter][j] = g;
				}
			}
			for (int j = i; j < n + 1; j++) {
				arr[i][j] = arr[i][j] / divider;
			}
			for (int j = 0; j < n; j++) {
				if (j != i) {
					double f = arr[j][i];
					for (int k = i; k < n + 1; k++) {
						arr[j][k] = arr[j][k] - f * arr[i][k];
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			writer.println(arr[i][n]);
		}
		writer.close();
	}

}
