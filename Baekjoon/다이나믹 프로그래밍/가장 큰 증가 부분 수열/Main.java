import java.util.Scanner;

public class Main {	
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(), max = Integer.MIN_VALUE;
		int[] arr = new int[num + 1];
		int[] dp = new int[num + 1];

		for (int i = 1; i <= num; i++) {
			arr[i] = sc.nextInt();
			dp[i] = arr[i];
		}

		for (int i = 1; i <= num; i++) {
			for (int j = i; j <= num; j++) {
				if (i == j)
					dp[j] = Math.max(arr[i], dp[j]);
				else {
					if (arr[i] < arr[j]) {
						dp[j] = Math.max(arr[j] + dp[i], dp[j]);
					}
				}
			}
		}
		for (int i = 1; i <= num; i++) {
			if (dp[i] > max)
				max = dp[i];
		}
		System.out.println(max);
	}
}