import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int[] lan = new int[k];
		int n = sc.nextInt();

		for (int i = 0; i < k; i++)
			lan[i] = sc.nextInt();
		Arrays.sort(lan);

		long start = 1, end = lan[k - 1];

		while (end - start >= 0) {
			long mid = (end + start) / 2, sum = 0;

			for (int i = 0; i < k; i++)
				sum = sum + (lan[i] / mid);
			if (sum < n)
				end = mid - 1;
			else
				start = mid + 1;
		}
		System.out.println(end);
	}
}