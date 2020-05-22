import java.util.Arrays;

class Solution {
	public int solution(String dartResult) {
		int answer = 0, index = 0, number = 0;
		int[] result = new int[3];
		int[] star = new int[3];
		int star_index = 2, temp_index = 2;
		String[] temp = dartResult.split("");
		String bonus = "", option = "";

		Arrays.fill(star, 0);
		
		for (int i = dartResult.length() - 1; i >= 0; i--) {
			if ((temp[i].charAt(0) >= 48) && (temp[i].charAt(0) <= 57)) {
				if ((temp[i].charAt(0) == 48) && (i != 0)) {
					if (temp[i - 1].charAt(0) == 49) {
						number = Integer.parseInt(temp[i - 1] + temp[i]);
						i--;
					}
					else
						number = 0;
				} else
					number = Integer.parseInt(temp[i]);

				if (bonus.equals("D"))
					number = (int) Math.pow(number, 2);
				else if (bonus.equals("T"))
					number = (int) Math.pow(number, 3);

				number *= (int) Math.pow(2, star[star_index]);
				
				if (option.equals("#"))
					number *= -1;

				result[index++] = number;
				option = "";
				bonus = "";
				star_index--;
                temp_index--;
			}

			else {
				if (temp[i].equals("*") || temp[i].equals("#")) {
					option = temp[i];
					if (temp[i].equals("*")) {
						if (temp_index > 0)
							star[temp_index - 1]++;
						star[temp_index]++;
					}
				} else
					bonus = temp[i];
			}
		}
		answer = result[0] + result[1] + result[2];
		return answer;
	}
}
