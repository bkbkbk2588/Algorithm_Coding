class Solution {
    public int solution(int[] budgets, int M) {
		int answer = 0, start = 0, last = M, max = 0;
		long sum = 0;

		for (int i : budgets)
			sum += (long) i;

		if (sum < (long) M) {
			for (int i : budgets) {
				if (i > max)
					max = i;
			}
			return max;
		}

		while (start <= last) {
			int mid = (start + last) / 2;
			long temp = 0;

			for (int value : budgets) {
				if (value <= mid)
					temp += (long) value;
				else
					temp += (long) mid;
			}

			if (temp > (long) M)
				last = mid - 1;
			else {
				start = mid + 1;

				if (answer < mid)
					answer = mid;
			}
		}
		return answer;
	}
}