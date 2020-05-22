import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public int[] solution(int[] arr, int divisor) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0)
				temp.add(arr[i]);
			else
				cnt++;
		}
		int[] answer;
		if (cnt != arr.length) {
			answer = new int[temp.size()];

			for (int i = 0; i < temp.size(); i++) {
				answer[i] = temp.get(i);
			}
			Arrays.sort(answer);
		} else {
			answer = new int[1];
			answer[0] = -1;
		}
		return answer;
	}
}
