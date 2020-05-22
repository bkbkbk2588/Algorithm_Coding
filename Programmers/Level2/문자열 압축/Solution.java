class Solution {
    public int solution(String s) {
		int answer = s.length(), count = 1;
		String temp = "", str;

		for (int i = 1; i <= s.length() / 2; i++) {
			str = "";
			temp = "";
			count = 1;
			for (int j = 1; j <= s.length() / i; j++) {
				if (temp.equals(s.substring((j - 1) * i, i * j)))
					count++;
				else {
					if (count <= 1)
						str += temp;
					else
						str += (Integer.toString(count) + temp);
					temp = s.substring((j - 1) * i, i * j);
					count = 1;
				}
			}
			if (count <= 1)
				str += temp;
			else
				str += (Integer.toString(count) + temp);
			answer = Math.min(answer, str.length() + s.length() % i);
		}
		return answer;
	}
}