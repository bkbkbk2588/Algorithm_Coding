class Solution {
	public boolean solution(String s) {
		boolean answer = true;
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 48 && s.charAt(i) <= 57)
				cnt++;
		}

		if (s.length() != cnt)
			answer = false;
		if(s.length() != 4 && s.length() != 6)
			answer = false;

		return answer;
	}
}
