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

		int k = sc.nextInt();

		for (int cnt = 0; cnt < k; cnt++) {
			int i = sc.nextInt(), j = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
			int sum = 0;
			
			for (int q = i; q <= x; q++) {
				for (int w = j; w <= y; w++)
					sum+=arr[q][w];
			}
			System.out.println(sum);
		}
	}
}