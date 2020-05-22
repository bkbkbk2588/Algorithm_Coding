import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public int[] solution(String[] genres, int[] plays) {
		int index = 0;
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		Map<String, Integer> check = new HashMap<String, Integer>();

		for (int i = 0; i < plays.length; i++) {
			if (!check.containsKey(genres[i]))
				check.put(genres[i], plays[i]);
			else
				check.replace(genres[i], check.get(genres[i]) + plays[i]);
		}

		List<String> keySetList = new ArrayList<>(check.keySet());
		Collections.sort(keySetList, (o2, o1) -> (check.get(o1).compareTo(check.get(o2))));

		for (String key : keySetList) {
			list.add(new ArrayList<Integer>());

			for (int i = 0; i < plays.length; i++) {
				if (genres[i].equals(key))
					list.get(index).add(plays[i]);
			}
			index++;
		}

		for (int i = 0; i < list.size(); i++) {
			Collections.sort(list.get(i));
			Collections.reverse(list.get(i));
		}

		ArrayList<Integer> result = new ArrayList<>();
		index = 0;

		for (String key : keySetList) {
			int first = -1, second = -1, count = 0;
			boolean flag = false, cnt = false, re= false;

			if (list.get(index).size() >= 2) {
				first = list.get(index).get(0);
				second = list.get(index).get(1);
				flag = true;
			}

			else
				first = list.get(index).get(0);

			for (int i = 0; i < plays.length; i++) {
				if (!cnt) {
					if (genres[i].equals(key) && plays[i] == first) {
						result.add(i);
						cnt = true;
						count++;
					}
				}

				else {
					if (genres[i].equals(key) && plays[i] == second) {
						if(re)
							break;
						
						result.add(i);
						count++;
						re = true;
					}
				}

				if (flag && count == 1 && i == plays.length - 1)
					i = -1;
			}
			index++;
		}
		int[] answer = new int[result.size()];

		for (int i = 0; i < answer.length; i++) {
			System.out.println(result.get(i));
			answer[i] = result.get(i);
		}
		return answer;
	}
}