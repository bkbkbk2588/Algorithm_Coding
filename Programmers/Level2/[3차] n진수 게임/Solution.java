class Solution {
	public String solution(int n, int t, int m, int p) {
		String answer = "", temp = "";
		StringBuffer str = new StringBuffer("0");
		int num = 0, turn = 0;
		while (true) {
			if (str.length() == 0) {
				num++;
				temp = conversion(n, num);
				str = new StringBuffer(temp);
			}
			
			if (turn == m)
				turn = 1;
			else
				turn++;
			
			if (turn == p)
				answer += str.charAt(0);
			str.deleteCharAt(0);

			if (answer.length() == t)
				break;
		}
		return answer;
	}

	public String conversion(int n, int number) {
		String conver = "";
		char temp;
		while (number != 0) {
			if((number%n)<10) {
				conver = (number%n) + conver;
			}
			else {
				temp = (char) ((number%n) + 55);
				conver = temp + conver;
			}
			number/=n;
		}
		return conver;
	}
}