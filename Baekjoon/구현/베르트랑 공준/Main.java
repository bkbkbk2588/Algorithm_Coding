import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0, num;

		while (true) {
			num = sc.nextInt();

			if (num == 0)
				break;

			boolean[] arr = new boolean[2 * num + 1];
			for (int i = 0; i < arr.length; i++)
				arr[i] = true;
			arr[0] = false;
			arr[1] = false;
			for (int i = 2; i < arr.length; i++) {
				if (arr[i]) {
					for (int j = 2 * i; j < arr.length; j += i)
						arr[j] = false;
				}
			}

			for (int i = num + 1; i < arr.length; i++) {
				if (arr[i])
					cnt++;
			}
			System.out.println(cnt);
			cnt = 0;
		}
	}
}