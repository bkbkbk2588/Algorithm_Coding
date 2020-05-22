import java.util.HashMap;

class Solution {
	public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<Integer, String> com = new HashMap<Integer, String>();

		String answer = "";

		for (int i = 0; i < completion.length + 1; i++) {
			if (!map.containsKey(participant[i]))
				map.put(participant[i], 1);
			else
				map.put(participant[i], map.get(participant[i]) + 1);
		}

		for (int i = 0; i < completion.length; i++) {
			if (map.containsKey(completion[i]))
				map.put(completion[i], map.get(completion[i]) + 1);
		}
		for (String str : map.keySet()) {
			if (map.get(str) % 2 != 0) {
				answer=str;
				break;
			}
		}
		return answer;
	}
}
