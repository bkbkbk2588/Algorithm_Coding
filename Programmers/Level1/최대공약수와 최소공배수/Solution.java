class Solution {
	public int[] solution(int n, int m) {
		int[] answer = new int[2];
		int max = 0, min = 0;

		for (int i = 1; i <= Math.min(n, m); i++) {
			if (n % i == 0 && m % i == 0)
				max = i;
		}

	   for (int i = 1; i <= Math.max(n, m); i++) {
			if ((i * n) % m == 0) {
				min = i * n;
				break;
			}
		}
		answer[0] = max;
		answer[1] = min;
		return answer;
	}
}
