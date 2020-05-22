import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt(), num2 = sc.nextInt();
		int[][] arr = new int[num1 + 1][num2 + 1];

		int cnt = 0;
		for (int i = 2; i <= num1; i++) {
			cnt++;
			arr[i][1] = cnt;
		}

		for (int i = 1; i <= num1; i++) {
			for (int j = 2; j <= num2; j++)
				arr[i][j] = arr[i][j - 1] + i;
		}
		System.out.println(arr[num1][num2]);
	}
}