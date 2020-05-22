import java.util.Arrays;

class Solution {
	int mod = 1000000007;

	public int solution(int n, int[] money) {
		Arrays.sort(money);

		int[][] arr = new int[money.length][n];

		for (int i = 0; i < n; i++) {
			if ((i + 1) % money[0] == 0)
				arr[0][i] = 1;
		}

		for (int i = 1; i < money.length; i++) {
			for (int j = 0; j < n; j++) {
				if (j + 1 < money[i])
					arr[i][j] = arr[i - 1][j] % mod;
				else if (j + 1 == money[i])
					arr[i][j] = (arr[i - 1][j] + 1) % mod;
				else
					arr[i][j] = (arr[i - 1][j] + arr[i][j - money[i]]) % mod;
			}
		}

		return arr[money.length - 1][n - 1];
	}
}