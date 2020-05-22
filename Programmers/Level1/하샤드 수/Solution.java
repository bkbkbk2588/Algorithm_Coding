class Solution {
	public boolean solution(int x) {
		boolean answer = true;
		int sum = 0, num = x;
		String str = Integer.toString(x);

		for (int i = 0; i < str.length(); i++) {
			sum += num % 10;
			num /= 10;
		}

		if (x % sum != 0)
			answer = false;

		return answer;
	}
}
