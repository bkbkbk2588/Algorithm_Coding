import java.util.Scanner;

public class Main {

	int hansoo(int num) {
		int cnt = 0;
		int temp, hun, ten, one;
		if (num >= 100) {
			cnt = 99;
			temp = 99;
			while (temp != num) {
				temp++;
				hun = temp / 100;
				ten = (temp % 100) / 10;
				one = temp % 10;
				if ((hun - ten) == (ten - one)) {
					cnt++;
				}
				
			}
		} else
			cnt = num;
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main ma = new Main();
		int num = sc.nextInt();
		while (num > 1000)
			num = sc.nextInt();
		int result = ma.hansoo(num);
		System.out.println(result);
	}
}
