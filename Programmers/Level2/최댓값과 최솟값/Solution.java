import java.util.ArrayList;
import java.util.Collections;

class Solution {
	public String solution(String s) {
		String answer = "";
		String[] temp = s.split(" ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < temp.length; i++)
			list.add(Integer.parseInt(temp[i]));

		Collections.sort(list);

		answer = Integer.toString(list.get(0));
		answer += " ";
		answer += Integer.toString(list.get(list.size() - 1));

		return answer;
	}
}
