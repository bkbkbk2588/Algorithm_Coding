import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num+1];
		int[] dp = new int[num+1];
		int answer = 0;

		for (int i = 1; i <= num; i++) {
			arr[i] = sc.nextInt();
			if (i == 1) {
				dp[i] = arr[i];
				answer = dp[i];
			} else if (i == 2) {
				dp[i] = dp[1] + arr[i];
				answer = Math.max(dp[i], answer);
			}
		}
		for (int i = 3; i <= num; i++) {
			dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
			dp[i] = Math.max(dp[i], dp[i - 1]);
			answer = Math.max(dp[i], answer);
		}
		System.out.println(answer);
	}
}