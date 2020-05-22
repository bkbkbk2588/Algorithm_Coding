import java.util.Arrays;
import java.util.Collections;

class Solution {
	public long solution(long n) {
		String str = Long.toString(n);
		long result = 0;
		Long [] answer = new Long [str.length()];

		for (int i = 0; i < str.length(); i++) {
			answer[i] = n % 10;
			n = n / 10;
		}
		Arrays.sort(answer, Collections.reverseOrder());
		int mul = 1;

		for (int i = answer.length - 1; i >= 0; i--) {
			result += (answer[i] * mul);
			mul *= 10;
		}
		return result;
	}
}
