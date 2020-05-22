import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[] = in.readLine().split(" ");
		int n = Integer.parseInt(input[1]);
		int m = Integer.parseInt(input[0]);
		int cnt = 0, x = 0, y = 0, res = 2500, sw = 1;
		char[] standard1 = { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' };
		char[] standard2 = { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' };
		char[][] chess = new char[m][n];
		for (int i = 0; i < m; i++) {
			String temp = in.readLine();
			for (int j = 0; j < n; j++) {
				chess[i][j] = temp.charAt(j);
			}
		}
		int k = 0;
		while (x + 8 <= m) {
			for (int a = 0; a < 2; a++) {
				if (a == 0)
					sw = 1;
				else if (a == 1)
					sw = -1;
				cnt = 0;
				for (int i = x; i < x + 8; i++) {
					for (int j = y; j < y + 8; j++) {
						if (sw == 1) {
							if (chess[i][j] != standard1[k])
								cnt++;
						} else if (sw == -1) {
							if (chess[i][j] != standard2[k])
								cnt++;
						}
						k++;
					}
					sw *= -1;
					k = 0;
				}

				if (res > cnt)
					res = cnt;
			}
			y++;
			if (y + 8 == n + 1) {
				x++;
				y = 0;
			}
		}
		System.out.println(res);
	}
}