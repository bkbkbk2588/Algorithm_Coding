import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		long[][] dp = new long[num][11];
		Arrays.fill(dp[0], 1);
		dp[0][10] = 10;

		for (int i = 1; i < num; i++) {
			long sum = 0;
			for (int j = 0; j < dp[i].length; j++) {
				if (j == 0)
					dp[i][j] = dp[i - 1][10] % 10007;
				else if (j == 10)
					dp[i][j] = sum % 10007;
				else {
					if (dp[i][j - 1] - dp[i - 1][j - 1] < 0)
						dp[i][j] = (10007 + (dp[i][j - 1] - dp[i - 1][j - 1])) % 10007;
					else
						dp[i][j] = (dp[i][j - 1] - dp[i - 1][j - 1]) % 10007;
				}
				sum += dp[i][j] % 10007;
			}
		}

		System.out.println(dp[num - 1][10] % 10007);
	}
}
