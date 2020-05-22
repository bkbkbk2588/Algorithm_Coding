class Solution {
	public int solution(int[][] board) {
		int min = 0, max = -1, temp = 0;

		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[0].length; j++) {
				min = Math.min(board[i][j - 1], Math.min(board[i - 1][j - 1], board[i - 1][j]));
				if (board[i][j] == 1) {
					board[i][j] = min + 1;
				}
				
                temp = Math.max(board[i][j], Math.max(board[i][j - 1], Math.max(board[i - 1][j - 1], board[i - 1][j])));
						
				if (temp > max)
					max = temp;
			}
		}
		return max*max;
	}
}
