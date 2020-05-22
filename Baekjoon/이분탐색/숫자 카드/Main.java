import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);

		int m = sc.nextInt();
		int[] card = new int[m];
		for (int i = 0; i < m; i++) {
			boolean flag = false;
			card[i] = sc.nextInt();
			int left = 0, right = n - 1;

			while (right - left >= 0) {
				int mid = (right + left) / 2;

				if (arr[mid] == card[i]) {
					flag = true;
					break;
				} else if (arr[mid] > card[i])
					right = mid - 1;
				else
					left = mid + 1;
			}

			if (flag)
				card[i] = 1;
			else
				card[i] = 0;
		}

		for (int i = 0; i < m; i++)
			System.out.print(card[i]+" ");
		System.out.println();

	}
}