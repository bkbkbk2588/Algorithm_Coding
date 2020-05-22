class Solution {
	public String solution(String s) {
		StringBuilder builder = new StringBuilder(s);
		String answer = "";
		char temp = ' ';

		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i; j < s.length(); j++) {
				if (builder.charAt(i) < builder.charAt(j)) {
					temp = builder.charAt(i);
					builder.setCharAt(i, builder.charAt(j));
					builder.setCharAt(j, temp);
				}
			}
		}
		answer = builder.toString();
		return answer;
	}
}
