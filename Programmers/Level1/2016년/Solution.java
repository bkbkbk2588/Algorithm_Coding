class Solution {
	public String solution(int a, int b) {
		int temp = 0, index = -1;
		String answer = "";
		String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };

		for (int i = 1; i <= a; i++) {
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
				temp = 31;
			else if (i == 4 || i == 6 || i == 9 || i == 11)
				temp = 30;
			else if(i == 2)
				temp = 29;

			if (i == a)
				temp = b;
			for (int j = 1; j <= temp; j++) {
				if (index == 6)
					index = 0;
				else
					index++;
			}
			if (i == a)
				answer = day[index];
			
		}
		
		return answer;
	}
}
