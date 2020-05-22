import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int number, num = sc.nextInt();
		long[] arr;
		for (int i = 0; i < num; i++) {
			number = sc.nextInt();
			arr = new long[number];
			if (number >= 5) {
				arr[0] = 1;
				arr[1] = 1;
				arr[2] = 1;
				arr[3] = 2;
				arr[4] = 2;
			}
			else if (number >= 4) {
				arr[0] = 1;
				arr[1] = 1;
				arr[2] = 1;
				arr[3] = 2;
			} else if (number >= 3) {
				arr[0] = 1;
				arr[1] = 1;
				arr[2] = 1;
			} else if (number >= 2) {
				arr[0] = 1;
				arr[1] = 1;

			} else {
				arr[0] = 1;
			}
			for (int j = 5; j < number; j++) {
				arr[j] = arr[j - 1] + arr[j - 5];
			}
			System.out.println(arr[number-1]);
		}
	}
}