import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Kuvaev Maksim(2020a)
//10a(quantity of ribs of notoriented)
//091218
public class A {
	static int arr[][];

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input.txt"));
		int n = sc.nextInt();
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i][j] != arr[j][i]) {
					System.out.println("NO");
					System.exit(0);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[i][i]== 1) {
				System.out.println("NO");
				System.exit(0);
			}
		}

		
		System.out.println("YES");

	}

}
