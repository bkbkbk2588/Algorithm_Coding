import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(), answer = 0;
		int[] arr = new int[num];
		int[] dp = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
			if (i == 0) {
				dp[i] = arr[i];
				answer = arr[i];
			} else {
				dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
				answer = Math.max(dp[i], answer);
			}
		}
		System.out.println(answer);
	}
}