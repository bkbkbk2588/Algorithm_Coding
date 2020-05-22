class Solution {
	public int[] solution(int brown, int red) {
		int[] answer = new int[2];
		int row = 0, col = 0, temp = brown + red;

		for (int i = 2; i < temp; i++) {
			if (temp % i != 0)
				continue;
			row = i;
			col = temp / i;

			if (row < col)
				continue;

			if (((red / (col - 2)) * 2) + ((col - 2) * 2) + 4 == brown) {
				answer[0] = row;
				answer[1] = col;
				break;
			}
		}
		return answer;
	}
}