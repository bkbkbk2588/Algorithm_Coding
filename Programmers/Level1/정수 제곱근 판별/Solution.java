class Solution {
	public long solution(long n) {
		long answer = 0;
		boolean bool =false;

		for (long i = 1; i <= n; i++) {
			if(i*i == n) {
				bool = true;
				answer = i;
				break;
			}
		}
		
		if(bool)
			return (answer + 1) * (answer + 1);
		else
			return -1;
	}
}
