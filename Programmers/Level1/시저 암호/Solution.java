class Solution {
	public String solution(String s, int n) {
		String answer = "";
		char temp;

		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) >= 65) && (s.charAt(i) <= 90)) {
				temp = (char) (s.charAt(i) + n);

				if (temp > 90) {
					temp = (char) (64 + (temp - 90));
				}
				answer += temp;

			} else if ((s.charAt(i) >= 97) && (s.charAt(i) <= 122)) {
				temp = (char) (s.charAt(i) + n);

				if (temp > 122) {
					temp = (char) (96 + (temp - 122));
				}
				answer += temp;
			} else
				answer += ' ';
		}
		System.out.println(answer);
		return answer;
	}
}
