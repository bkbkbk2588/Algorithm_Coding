import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		num = sc.nextInt();
		int[][] arr = new int[num][2];
		for (int i = 0; i < num; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int a[], int b[]) {
				if (a[1] == b[1])
					return Integer.compare(a[0], b[0]);
				else
					return Integer.compare(a[1], b[1]);
			}
		});

		for (int i = 0; i < num; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}

	}
}