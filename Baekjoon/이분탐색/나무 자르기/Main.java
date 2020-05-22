import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		long len = sc.nextLong();
		long[] tree = new long[num];

		for (int i = 0; i < num; i++)
			tree[i] = sc.nextLong();

		Arrays.sort(tree);
		long start = 0, end = tree[num - 1];
		

		while (end - start >= 0) {
			long mid = (start + end) / 2, sum = 0;

			for (int i = 0; i < num; i++) {
				if (tree[i] - mid >= 0)
					sum = sum + (tree[i] - mid);
			}
            
            if (sum >= len)
				start = mid + 1;
			else if (sum < len)
				end = mid - 1;
		}
		System.out.println(end);
	}
}