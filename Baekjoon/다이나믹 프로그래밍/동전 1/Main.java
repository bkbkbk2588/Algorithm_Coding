import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(), y = sc.nextInt();
		int[] arr = new int[x];
		int[] dp = new int[y + 1];
		dp[0] = 1;
		for (int i = 0; i < x; i++)
			arr[i] = sc.nextInt();
		for (int i = 0; i < x; i++) {
			for (int j = arr[i]; j <= y; j++)
				dp[j] += dp[j - arr[i]];
		}
		System.out.println(dp[y]);
	}
}