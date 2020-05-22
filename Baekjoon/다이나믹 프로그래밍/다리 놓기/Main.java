import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();

		for (int i = 0; i < test; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			int[][] dp = new int[x + 1][y + 1];
			for (int j = 1; j <= x; j++) {
				for (int k = 1; k <= y; k++) {
					if (j == k)
						dp[j][k] = 1;
					else if (j == 1)
						dp[j][k] = k;
					else if (j > k)
						dp[j][k] = 0;
					else
						dp[j][k] = dp[j - 1][k - 1] + dp[j][k - 1];
				}
			}
			System.out.println(dp[x][y]);
		}
	}
}