import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Kuvaev Maksim(2020a)
//10a(Ribs of oriented graphs)
//091218
public class D {
	static int arr[][];

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input.txt"));
		int n = sc.nextInt();
		int counter = 0;
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j]== 1) {
					counter++;
				}
			}
		}

		
		System.out.println(counter);

	}

}