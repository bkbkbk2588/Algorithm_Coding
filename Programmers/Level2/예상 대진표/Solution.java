class Solution {
	public int solution(int n, int a, int b) {
		int answer = 0, player1 = a, player2 = b;
		boolean exit = false;
		int[] match = new int[n + 1];
		match[0] = 0;

		for (int i = 1; i <= n; i++)
			match[i] = i;

		int temp1 = 0, temp2 = 0;
		boolean first = true, second = false;

		while (!exit) {
			for (int i = 1; i <= n; i++) {
				if (first && match[i] != 0) {
					temp1 = i;
					first = false;
					second = true;
				}

				else if (second && match[i] != 0) {
					temp2 = i;
					first = true;
					second = false;
				}

				if (temp2 == 0)
					continue;

				if (((player1 == temp1) || (player1 == temp2)) && ((player2 == temp2) || (player2 == temp1))) {
					exit = true;
					break;
				} else if (((player1 == temp1) || (player2 == temp1)) && ((player1 != temp2) || (player2 != temp2)))
					match[temp2] = 0;
				else if (((player1 != temp1) || (player2 != temp1)) && ((player2 == temp2) || (player1 == temp2)))
					match[temp1] = 0;
				else
					match[temp2] = 0;

				temp1 = 0;
				temp2 = 0;
			}
			answer++;
		}
		return answer;
	}
}