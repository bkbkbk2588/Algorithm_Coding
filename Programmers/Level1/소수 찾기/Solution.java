import java.util.Arrays;

class Solution {
	public int solution(int n) {
		int answer = 0;
		boolean[] bool = new boolean[n + 1];
		Arrays.fill(bool, true);
		bool[0] = false;
		bool[1] = false;

		for (int i = 2; i <= n; i++) {
			if (bool[i]) {
				for (int j = i * 2; j <= n; j += i)
					bool[j] = false;
			}
		}
		
		for(int i=2;i<=n;i++) {
			if(bool[i])
				answer++;
		}
		return answer;
	}
}
