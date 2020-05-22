import java.util.ArrayList;

class Solution {
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		int[] player = new int[n + 1];
		int index = 1, flag = 1;
		player[1] = 1;

		ArrayList<String> list = new ArrayList<String>();
		list.add(words[0]);

		for (int i = 1; i < words.length; i++) {
			flag++;
			index++;
			player[index]++;
			if (list.contains(words[i])) {
				flag--;
				break;
			} else
				list.add(words[i]);

			if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
				flag--;
				break;
			}
			if (index == n)
				index = 0;
		}
		if (flag == words.length) {
			answer[0] = 0;
			answer[1] = 0;
		} else {
			answer[0] = index;
			answer[1] = player[index];
		}
		return answer;
	}
}