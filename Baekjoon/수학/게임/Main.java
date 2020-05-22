import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long x = sc.nextInt(), y = sc.nextInt();
		int z = (int) ((y * 100) / x);

		long start = 0, end = 1000000000;
        int result = -1;
        if (z >= 99)
            start = 1000000001;
		while (end - start >= 0) {
			long mid = (start + end) / 2;
			long temp = ((y + mid) * 100) / (x + mid);

			if (temp > z)
				end = mid - 1;
			else{
				start = mid + 1;
                result = (int) (mid + 1);
            }
		}
		System.out.println(result);
	}
}