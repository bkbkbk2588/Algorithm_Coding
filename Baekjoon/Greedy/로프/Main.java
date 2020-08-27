import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(), max = -1;
		int[] arr = new int[num];
		int[] answer = new int[num];

		for (int i = 0; i < num; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);

		for (int i = 0; i < num; i++) {
			answer[i] = arr[i] * (num - i);
			if (max < answer[i])
				max = answer[i];
		}

		System.out.println(max);
	}
}
