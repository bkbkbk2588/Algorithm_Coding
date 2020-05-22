import java.util.Stack;

class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < moves.length; i++) {
			int temp = moves[i] - 1, num = 0;
			for (int j = 0; j < board.length; j++) {
				if (board[j][temp] != 0) {
					num = board[j][temp];
					board[j][temp] = 0;
					break;
				}
			}
			if (!stack.isEmpty()) {
				if (stack.peek() == num) {
					answer++;
					stack.pop();
				} else
					stack.push(num);
			} else if(num != 0)
				stack.push(num);
		}
		return answer * 2;
	}
}
