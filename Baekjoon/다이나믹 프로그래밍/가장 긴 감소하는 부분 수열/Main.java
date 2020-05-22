import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), max = Integer.MIN_VALUE;
		int[] arr = new int[n];
		int[] dp = new int[n];
		dp[n - 1] = 1;

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
				else
					dp[i] = Math.max(dp[i], 1);
			}
			if (dp[i] > max)
				max = dp[i];
		}

		System.out.println(max);
	}
}