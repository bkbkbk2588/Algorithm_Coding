import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int[] charge = new int[num];

		for (int i = 0; i < num; i++)
			charge[i] = sc.nextInt();
		int len = sc.nextInt();
		Arrays.sort(charge);

		int start = 0, end = charge[num - 1];

		while (end - start >= 0) {
			int mid = (start + end) / 2, sum = 0;

			for (int i = 0; i < num; i++)
				sum += Math.min(mid, charge[i]);
			if (sum <= len)
				start = mid + 1;
			else
				end = mid - 1;
		}
		System.out.println(end);
	}
}
