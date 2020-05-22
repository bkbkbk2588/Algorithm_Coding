class Solution{
    public int solution(String s) {
		int answer = -1, front = 0, back = 0;
		boolean flag = false;

		for (int pivot = 1; pivot < s.length() - 1; pivot++) {
			flag = true;
			int cnt1 = 1, cnt2 = 0;

			for (int i = 1; i <= s.length() / 2; i++) {
				front = pivot - i;
				back = pivot + i;
				if (front >= 0 && back < s.length()) {
					if (s.charAt(front) == s.charAt(back))
						cnt1 += 2;
					else
						break;
				} else
					break;
			}

			for (int i = 1; i <= s.length() / 2; i++) {
				front = pivot - i + 1;
				back = pivot + i;
				if (front >= 0 && back < s.length()) {
					if (s.charAt(front) == s.charAt(back))
						cnt2 += 2;
					else
						break;
				} else
					break;
			}

			if (Math.max(cnt1, cnt2) > answer)
				answer = Math.max(cnt1, cnt2);
		}
		if (!flag)
			answer = 1;

		return answer;
	}
}