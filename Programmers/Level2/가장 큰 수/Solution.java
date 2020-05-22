import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public static String solution(int[] numbers) {
		String answer = "";
		String[] num = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++)
			num[i] = Integer.toString(numbers[i]);

		Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });

		for (int i = 0; i < num.length; i++)
			answer += num[i];

		return answer.charAt(0) == '0' ? "0" : answer;
	}
}