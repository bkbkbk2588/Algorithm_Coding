class Solution {
	public long solution(int a, int b) {
		long answer = 0;
		int min = 0, max = 0;

		if (a < b) {
			min = a;
			max = b;
		} else if (a > b) {
			min = b;
			max = a;
		}
		else
			return a;
		
		for(int i=min;i<=max;i++)
			answer+=i;

		return answer;
	}
}
