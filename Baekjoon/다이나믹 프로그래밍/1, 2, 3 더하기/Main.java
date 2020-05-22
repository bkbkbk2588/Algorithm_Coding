import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();

		for (int i = 0; i < test; i++) {
			int num = sc.nextInt();
			
			int[] arr = new int[num];
			if (num == 1)
				arr[0] = 1;
			else if (num == 2) {
				arr[0] = 1;
				arr[1] = 2;
			} else {
				arr[0] = 1;
				arr[1] = 2;
				arr[2] = 4;
			}
			for (int j = 3; j < num; j++)
				arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
			System.out.println(arr[num - 1]);
		}
	}
}