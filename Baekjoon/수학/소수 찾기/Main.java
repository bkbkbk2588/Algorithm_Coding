import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0, test = sc.nextInt(), num, temp = 2, idx = 0;

		for (int i = 0; i < test; i++) {
			num = sc.nextInt();
			if (num == 1)
				idx = 1;
			else if (num == 2)
				idx = 0;
			else {
				while (temp < num) {
					if (num % temp == 0) {
						idx = 1;
						break;
					}
					temp++;
				}
			}
			if (idx == 0)
				cnt++;
			idx = 0;
			temp = 2;
		}
		System.out.println(cnt);
	}
}