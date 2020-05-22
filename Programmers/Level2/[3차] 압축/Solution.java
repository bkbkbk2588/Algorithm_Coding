import java.util.ArrayList;
import java.util.HashMap;

class Solution {
	public static int[] solution(String msg) {
		HashMap<String, Integer> diction = new HashMap<String, Integer>();
		ArrayList<Integer> output = new ArrayList<Integer>();
		String[] list = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z" };
		int max = 27;
		String word = "", temp = "";

		for (int i = 1; i <= 26; i++)
			diction.put(list[i - 1], i);

		for (int index = 0; index < msg.length(); index++) {
			word += msg.charAt(index);
			temp = "";
			if (index + 1 < msg.length()) {
				temp = word + msg.charAt(index + 1);
			}
			if (!diction.containsKey(temp)) {
				if (temp == "") {
					output.add(diction.get(word));
					break;
				}
				diction.put(temp, max);
				max++;
				output.add(diction.get(word));
			} else
				continue;
			word = "";
		}

		int[] answer = new int[output.size()];

		for (int i = 0; i < output.size(); i++)
			answer[i] = output.get(i);

		return answer;
	}
}