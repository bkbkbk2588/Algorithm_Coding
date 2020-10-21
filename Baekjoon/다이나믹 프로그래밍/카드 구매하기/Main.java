import java.util.Scanner;

class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] price = new int[num + 1];
		int[] dp = new int[num + 1];

		for (int i = 1; i <= num; i++)
			price[i] = sc.nextInt();

		dp[1] = price[1];

		for (int i = 2; i <= num; i++) {
			int start = 1, end = i - 1;
			while (end - start >= 0) {
				int number = dp[start] + dp[end];
				start++;
				end--;
				dp[i] = Math.max(dp[i], number);
			}
			dp[i] = Math.max(dp[i], price[i]);
		}
		System.out.println(dp[num]);
	}
}
