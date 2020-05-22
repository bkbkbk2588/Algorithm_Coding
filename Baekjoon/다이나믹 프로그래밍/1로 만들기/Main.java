import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] dp = new int[num + 1];

		dp[0] = 0;
		dp[1] = 0;

		for (int i = 2; i <= num; i++) {
			dp[i] = dp[i - 1] + 1; // 1 빼기한것
			
			if ((i % 2 == 0) && dp[i] > dp[i / 2] + 1) // 2로 나눈횟수가 적을때
				dp[i] = dp[i / 2] + 1;
			
			if ((i % 3 == 0) && dp[i] > dp[i / 3] + 1)// 3으로 나눈횟수가 적을때
				dp[i] = dp[i / 3] + 1;
		}
		System.out.println(dp[num]);
	}
}