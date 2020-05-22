class Solution {
	public int solution(String dirs) {
		int answer = 0;
		boolean[][][][] visit = new boolean[11][11][11][11];
		int startX = 5, startY = 5, endX = 0, endY = 0;

		for (int i = 0; i < dirs.length(); i++) {
			if ((dirs.charAt(i) == 'U') && (startY - 1 >= 0)) {
				if (!visit[startX][startY][startX][startY - 1]) {
					visit[startX][startY][startX][startY - 1] = true;
					visit[startX][startY - 1][startX][startY] = true;
					answer++;
				}
				startY--;
			} else if ((dirs.charAt(i) == 'D') && (startY + 1 < 11)) {
				if (!visit[startX][startY][startX][startY + 1]) {
					visit[startX][startY][startX][startY + 1] = true;
					visit[startX][startY + 1][startX][startY] = true;
					answer++;
				}
				startY++;
			} else if ((dirs.charAt(i) == 'R') && (startX + 1 < 11)) {
				if (!visit[startX][startY][startX + 1][startY]) {
					visit[startX][startY][startX + 1][startY] = true;
					visit[startX + 1][startY][startX][startY] = true;
					answer++;
				}
				startX++;
			} else if ((dirs.charAt(i) == 'L') && (startX - 1 >= 0)) {
				if (!visit[startX][startY][startX - 1][startY]) {
					visit[startX][startY][startX - 1][startY] = true;
					visit[startX - 1][startY][startX][startY] = true;
					answer++;
				}
				startX--;
			}
		}
		return answer;
	}
}