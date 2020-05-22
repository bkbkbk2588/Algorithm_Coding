import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int number;
		long[] zero;
		long[] one;
		for (int i = 0; i < num; i++) {
			number = sc.nextInt();
			zero = new long[number + 1];
			one = new long[number + 1];
			if (number == 0) {
				zero[0] = 1;
				one[0] = 0;
			} else {
				zero[0] = 1;
				zero[1] = 0;
				one[0] = 0;
				one[1] = 1;
			}
			for (int j = 2; j <= number; j++) {
				zero[j] = zero[j - 2] + zero[j - 1];
				one[j] = one[j - 2] + one[j - 1];
			}
			System.out.println(zero[number] + " " + one[number]);
		}
	}
}