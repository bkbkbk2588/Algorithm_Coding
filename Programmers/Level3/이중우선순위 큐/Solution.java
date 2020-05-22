import java.util.ArrayList;
import java.util.Collections;

class Solution {
	public int[] solution(String[] operations) {
		int[] answer = new int[2];
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < operations.length; i++) {
			if (operations[i].charAt(0) == 'I')
				list.add(Integer.parseInt(operations[i].substring(2)));
			else {
				if (list.size() == 0)
					continue;
				Collections.sort(list);

				if (operations[i].length() == 3)
					list.remove(list.size() - 1);
				else
					list.remove(0);
			}
		}
        
        Collections.sort(list);
		if (list.size() == 0) {
			answer[0] = 0;
			answer[1] = 0;
		}
		else {
			answer[0] = list.get(list.size() - 1);
			answer[1] = list.get(0);
		}
		return answer;
	}
}