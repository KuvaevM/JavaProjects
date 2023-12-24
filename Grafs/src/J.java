import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Kuvaev Maksim(2020a)
//10a(Parallel ribs oriented)
//121218
public class J {
	static int arr[][];

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input.txt"));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = 0;
		int y = 0;
		arr = new int[n][n];
		for (int i = 0; i < m; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			arr[x - 1][y - 1]++;

		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j]>1) {
					System.out.println("YES");
					System.exit(0);
				}
			}
		}
		System.out.println("NO");

	}

}

