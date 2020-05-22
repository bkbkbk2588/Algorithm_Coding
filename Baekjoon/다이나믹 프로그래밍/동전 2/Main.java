import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if (i == 0) {
				Arrays.fill(dp, 100001);
				dp[0] = 0;
			}
			for (int j = arr[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
			}
		}

		if (dp[k] < 100001)
			System.out.println(dp[k]);
		else
			System.out.println(-1);
	}
}