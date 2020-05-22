import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		int[][] arr = new int[a + 1][b + 1];

		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++)
				arr[i][j] = sc.nextInt();
		}

		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++)
				arr[i][j] += Math.max(arr[i - 1][j], Math.max(arr[i][j - 1], arr[i - 1][j - 1]));
		}
		System.out.println(arr[a][b]);
	}
}