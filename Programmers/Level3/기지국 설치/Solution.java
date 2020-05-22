class Solution {
   public int solution(int n, int[] stations, int w) {
		int answer = 0, index = 0, now = 1;

		while (now <= n) {
			if (index < stations.length && now >= stations[index] - w) {
				now = stations[index] + w + 1;
				index++;
			} else {
				answer++;
				now += w * 2 + 1;
			}
		}
		return answer;
	}
}