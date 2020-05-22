import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(), sw = 1;
		int[] dp = new int[num];

		dp[0] = 1;

		for (int i = 1; i < num; i++) {
			if (i % 2 == 0)
				sw = -1;
			else
				sw = 1;
			dp[i] = (dp[i - 1] * 2 + sw) % 10007;
		}
		System.out.println(dp[num - 1]);
	}
}