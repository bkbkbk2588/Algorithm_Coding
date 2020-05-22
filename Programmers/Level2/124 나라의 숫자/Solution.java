class Solution {
	public String solution(int n) {
		String answer = "";
		int num = 0;
		while(n>0) {
			num=n%3;
			n/=3;
			if(num==0) {
				num=4;
				n-=1;
			}
			answer=num+answer;
		}
		return answer;
	}
}
