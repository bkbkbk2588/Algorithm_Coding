class Solution {
	public String solution(String s) {
		String answer = "";
		int num = 2;

		for (int i = 0; i < s.length(); i++) {
			if (Character.toString(s.charAt(i)).equals(" ")) {
				answer += " ";
				num = 2;
			} else {
				if (num % 2 == 0)
					answer += Character.toString(s.charAt(i)).toUpperCase();
				else
					answer += Character.toString(s.charAt(i)).toLowerCase();
				num++;
			}
		}
		return answer;
	}
}
