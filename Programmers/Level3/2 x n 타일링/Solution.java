class Solution {
 public int solution(int n) {
		int[] temp = new int[n + 1];

		temp[1] = 1;
		temp[2] = 2;

		for (int i = 3; i <= n; i++)
			temp[i] = (temp[i - 1] + temp[i - 2]) % 1000000007;

		return temp[n];
	}
}