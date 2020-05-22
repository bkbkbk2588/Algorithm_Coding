class Solution {
	public static String solution(String s) {
		String answer = "";
		char ch;
		boolean flag = true;

		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);

			if (i > 0) {
				if (s.charAt(i-1) == ' ')
					flag = true;
				else
					flag = false;
			}

			if (flag) {
				if (ch >= 97 && ch <= 122)
					ch -= 32;
			} else {
				if (ch >= 65 && ch <= 90)
					ch += 32;
			}

			answer += ch;
		}
		return answer;
	}
}
