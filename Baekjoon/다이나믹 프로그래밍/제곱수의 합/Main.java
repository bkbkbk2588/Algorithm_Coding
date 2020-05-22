import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(), temp = 2, number = 2;
		int[] dp = new int[num + 1];
		Arrays.fill(dp, 100);
		for (int i = 1; i <= num; i++) {
			if (i <= 3)
				dp[i] = i;
			else if (i == (number * number)) {
				dp[i] = 1;
				temp = number;
				number++;
			} else {
				for (int j = 1; j <= temp; j++)
					dp[i] = Math.min(dp[i], dp[(temp - j) * (temp - j)] + dp[i - ((temp - j) * (temp - j))]);
			}
		}
		System.out.println(dp[num]);
	}
}