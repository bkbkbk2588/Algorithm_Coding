class Solution {
	public int solution(String s) {
		int answer = 0, cnt = 0;
		boolean bo = false;
		if(s.charAt(0)==43) {
			bo = true;
			cnt = 1;
		}
		else if(s.charAt(0)==45) {
			bo = true;
			cnt = -1;
		}
			
		
		if(!bo)
			answer=Integer.parseInt(s);
		else {
			String str = s.substring(1, s.length());
			answer=Integer.parseInt(str) * cnt;
		}
			
		return answer;
	}
}
