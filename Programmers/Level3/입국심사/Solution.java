import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE, mid = times[times.length - 1] / 2;
		Arrays.sort(times);

		long start = 0, last = (long)times[times.length - 1] * (long)n;

		while (start <= last) {
			mid = (start + last) / 2;
			long temp = 0;

			for (int i = 0; i < times.length; i++)
				temp += mid / (long)times[i];

			if (n > temp)
				start = mid + 1;

			else {
				last = mid - 1;

				if (mid < answer)
					answer = mid;
			}
		}
		return answer;
	}
}