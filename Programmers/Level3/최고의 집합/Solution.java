import java.util.Arrays;

class Solution {
  public int[] solution(int n, int s) {
		int[] answer;

		if (s < n) {
			answer = new int[1];
			answer[0] = -1;
			return answer;
		} else {
			answer = new int[n];
			int mok = s / n, na = s % n;
			for (int i = 0; i < n - na; i++)
				answer[i] = mok;
			for (int i = n - na; i < n; i++)
				answer[i] = mok + 1;
		}
		return answer;
	}
}