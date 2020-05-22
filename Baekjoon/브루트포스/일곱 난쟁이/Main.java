import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int[] value = new int[7];
		boolean exit = false;
		int sum = 0, one = 0, two = 0;

		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		sum -= 100;
		Arrays.sort(arr);

		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				int temp = sum - arr[i];
				temp -= arr[j];
				if (temp == 0) {
					one = i;
					two = j;
					exit = true;
					break;
				}
			}
			if (exit)
				break;
		}
		int index = 0;

		for (int i = 0; i < arr.length; i++) {
			if (i == one || i == two)
				continue;
			else
				value[index++] = arr[i];
		}
		// Arrays.sort(arr);

		for (int i = 0; i < value.length; i++)
			System.out.println(value[i]);
	}
}