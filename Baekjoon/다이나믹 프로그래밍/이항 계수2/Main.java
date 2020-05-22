import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		int[][] dp = new int[k + 1][n + 1];
		Arrays.fill(dp[0], 1);

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					dp[i][j] = 1;
				else
					dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 1]) % 10007;
			}
		}
		System.out.println(dp[k][n]);
	}
}