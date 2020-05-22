public class Solution {
	public int solution(int n) {
		int answer = 0, now = n;

		while (now != 0) {
			if (now == 1) {
				answer++;
				now--;
			} 
			
			else if (now % 2 == 0) {
				now/=2;
			} 
			
			else if (now % 2 == 1) {
				answer++;
				now--;
			}
		}
		return answer;
	}
}