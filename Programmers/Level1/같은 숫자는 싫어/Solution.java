import java.util.ArrayList;

class Solution {
	public int[] solution(int[] arr) {
		int temp = -1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (temp != arr[i]) {
				list.add(arr[i]);
				temp = arr[i];
			}
		}
		int[] answer = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			answer[i]=list.get(i);
		}
		return answer;
	}
}
