import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

class Solution {
	public int solution(String[] user_id, String[] banned_id) {
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		ArrayList<ArrayList<Boolean>> visit = new ArrayList<>();
		ArrayList<HashSet<String>> set_list = new ArrayList<>();
		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < banned_id.length; i++) {
			list.add(new ArrayList<String>());
			visit.add(new ArrayList<Boolean>());
			for (int j = 0; j < user_id.length; j++) {
				int cnt = 0;

				if (banned_id[i].length() == user_id[j].length()) {
					for (int k = 0; k < user_id[j].length(); k++) {
						if (banned_id[i].charAt(k) == user_id[j].charAt(k) || banned_id[i].charAt(k) == '*')
							cnt++;
					}
					if (cnt == banned_id[i].length()) {
						list.get(i).add(user_id[j]);
						visit.get(i).add(false);
					}
				}
			}
		}

		if (list.size() == 1)
			return list.get(0).size();

		int size = banned_id.length, index = 0;
		set_list.add(new HashSet<String>());

		for (int i = 0; i < list.get(0).size(); i++) {
			Stack<Integer> stack = new Stack<>();
			Stack<String> user = new Stack<>();

			stack.push(0);
			set.add(list.get(0).get(i));
			user.push(list.get(0).get(i));

			for (int j = 0; j < size; j++)
				Collections.fill(visit.get(j), false);
			visit.get(0).set(i, true);

			while (!stack.isEmpty()) {
				int temp = stack.peek();
				boolean flag = false;

				if (temp + 1 < size) {
					for (int j = 0; j < list.get(temp + 1).size(); j++) {
						if (!visit.get(temp + 1).get(j) && !set.contains(list.get(temp + 1).get(j))) {
							set.add(list.get(temp + 1).get(j));
							user.push(list.get(temp + 1).get(j));
							stack.push(temp + 1);
							visit.get(temp + 1).set(j, true);

							if (set_list.contains(set))
								break;
							flag = true;
                            
							if (temp + 2 == size) {
								for (int k = 0; k < user.size(); k++)
									set_list.get(index).add(user.get(k));
							}
							break;
						}
					}
				}

				if (!flag) {
					int num = stack.pop();
					String str = user.pop();
					if (size == num + 1) {
						set_list.add(new HashSet<String>());
						index++;
					}
					set.remove(str);
					if (num + 1 < size) {
						for (int k = num + 1; k < size; k++)
							Collections.fill(visit.get(k), false);
					}
				}
			}
			set.clear();
			user.clear();
		}

		int answer = 0;
		for (int i = 0; i < set_list.size(); i++) {
			if (set_list.get(i).size() != 0)
				answer++;
		}
		return answer;
	}
}