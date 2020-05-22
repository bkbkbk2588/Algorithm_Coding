class Solution {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		int index = 0;

		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < i; j++) {
				if (heights[i] < heights[j])
					index = j + 1;
			}
			answer[i] = index;
			index = 0;
		}
		return answer;
	}
}
