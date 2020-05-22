import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		String s = "";

		sc.nextLine();

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextLine();

		int size = arr[0].length();

		for (int i = 0; i < size; i++) {
			int cnt = 1;
			for (int j = 1; j < n; j++) {
				if (arr[j - 1].charAt(i) == arr[j].charAt(i))
					cnt++;
			}
			if (cnt == n)
				s += arr[0].charAt(i);
			else
				s += "?";
		}
		System.out.println(s);
	}
}