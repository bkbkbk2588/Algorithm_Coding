class Solution {
    public int solution(int[][] triangle) {
		int answer = 0;
        
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if (j == 0)
					triangle[i][j] += triangle[i - 1][j];
                else if (i == j)
					triangle[i][j] += triangle[i - 1][j - 1];
				else {
					triangle[i][j] = Math.max(triangle[i][j] + triangle[i - 1][j],
							triangle[i][j] + triangle[i - 1][j - 1]);
				}
			}
		}
        
        int size = triangle.length - 1;
        
		for (int i = 0; i < triangle[size].length; i++) {
			if (answer < triangle[size][i])
				answer = triangle[size][i];
		}
		return answer;
	}
}