import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int m, int n, String[] board) {
		int answer = 0;
		boolean exit = true;
		String[][] game = new String[m][n];

		for (int i = 0; i < m; i++)
			Arrays.fill(game[i], "");

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				game[i][j] += board[i].charAt(j);
		}

		while(true) {
			exit = true;
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (check(game, game[i][j], i, j)) 
						exit = false;
				}
			}
			

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (game[i][j] != "") {
						if (game[i][j].toCharArray()[0] >= 97 && game[i][j].toCharArray()[0] <= 122)
							game[i][j] = "";
					}
				}
			}
			adjust(game);
			
			if (exit)
				break;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(game[i][j].equals(""))
					answer++;
			}
		}
		return answer;
	}

	boolean check(String[][] game, String str, int xpos, int ypos) {
		int x = xpos, y = ypos;
		String upper = str.toUpperCase(), lower = str.toLowerCase();
		
		if(game[x][y].equals(""))
			return false;
		
		if ((game[x][y].equals(upper) || game[x][y].equals(lower))
				&& (game[x][y + 1].equals(upper) || game[x][y + 1].equals(lower))
				&& (game[x + 1][y].equals(upper) || game[x + 1][y].equals(lower))
				&& (game[x + 1][y + 1].equals(upper) || game[x + 1][y + 1].equals(lower))) {

			game[x][y] = game[x][y].toLowerCase();
			game[x][y + 1] = game[x][y + 1].toLowerCase();
			game[x + 1][y] = game[x + 1][y].toLowerCase();
			game[x + 1][y + 1] = game[x + 1][y + 1].toLowerCase();
			return true;
		}
		return false;
	}

	void adjust(String[][] game) {
		int rowsize = game.length, colsize = game[0].length;
		Queue<Integer> freeList = new LinkedList<Integer>();
		
		for (int i = colsize - 1; i >= 0; i--) {
			for (int j = rowsize - 1; j >= 0; j--) {
				if(game[j][i].equals(""))
					freeList.add(j);
				else {
					if(!freeList.isEmpty()) {
						game[freeList.peek()][i] = game[j][i];
						game[j][i]="";
						freeList.add(j);
						freeList.poll();
					}
				}
			}
			freeList.clear();
		}
	}
}