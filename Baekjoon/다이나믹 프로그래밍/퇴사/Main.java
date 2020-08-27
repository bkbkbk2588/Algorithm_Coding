import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][] arr = new int[num][2];
		int[] dp = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();

			if (arr[i][0] + i > num)
				continue;
			dp[i] = arr[i][1];
		}

		for (int i = 1; i < num; i++) {
			int max = 0;

			if (arr[i][0] + i > num)
				continue;

			for (int j = 0; j < i; j++) {
				if (arr[j][0] + j < i + 1)
					max = Math.max(max, dp[j]);
			}
			dp[i] += max;
		}

		int answer = 0;

		for (int i = 0; i < num; i++) {
			if (answer < dp[i])
				answer = dp[i];
		}
		System.out.println(answer);
	}
}
