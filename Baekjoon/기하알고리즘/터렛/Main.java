import java.util.Scanner;

public class Main {
	public int count(int x1, int y1, int r1, int x2, int y2, int r2) {
		int res = 100;
		double temp1, temp2;
		temp1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		temp2 = r1 + r2;
		if ((x1 == x2) && (y1 == y2) && (r1 == r2))
			return -1;
		else if (((x1 == x2) && (y1 == y2) && (r1 != r2)) || (temp1 > temp2) || (temp1 < Math.abs(r1 - r2)))
			return 0;
		else if ((temp1 == temp2) || (Math.abs(r1 - r2) == temp1))
			return 1;
		return 2;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main mm = new Main();
		int test = sc.nextInt();
		int x1, x2, y1, y2, r1, r2, a;
		for (int i = 0; i < test; i++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			r1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			r2 = sc.nextInt();
			a = mm.count(x1, y1, r1, x2, y2, r2);
			System.out.println(a);
		}
	}
}