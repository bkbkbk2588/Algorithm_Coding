class Solution {
	public int solution(int[][] baseball) {
		int answer = 0, strike = 0, ball = 0, cnt = 0, size = baseball.length;
		int[] num = new int[3];
		int[] input = new int[3];

		for (int number = 100; number < 1000; number++) {
			cnt = 0;
			num[0] = number / 100;
			num[1] = (number / 10) % 10;
			num[2] = number % 10;

			if (num[0] == 0 || num[1] == 0 || num[2] == 0 || (num[0] == num[1]) || (num[0] == num[2])
					|| (num[2] == num[1]))
				continue;

			for (int i = 0; i < size; i++) {
				strike = baseball[i][1];
				ball = baseball[i][2];

				input[0] = baseball[i][0] / 100;
				input[1] = (baseball[i][0] / 10) % 10;
				input[2] = baseball[i][0] % 10;

				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (num[j] == input[k]) {
							if (j == k)
								strike--;
							else
								ball--;
						}
					}
				}

				if (strike == 0 && ball == 0)
					cnt++;
			}

			if (cnt == size)
				answer++;
		}
		return answer;
	}
}