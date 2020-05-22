import java.util.ArrayList;

class Solution {
	public int[] solution(int n) {
		String str = "", temp = "";

		for (int i = 0; i < n; i++) {
			temp = str.replace('0', '2');
			temp = temp.replace('1', '0');
			temp = temp.replace('2', '1');

			str = str + "0" + new StringBuffer(temp).reverse().toString();
		}

		int[] answer = new int[str.length()];

		for (int i = 0; i < answer.length; i++)
			answer[i] = str.charAt(i) - '0';
		
		return answer;
	}
}