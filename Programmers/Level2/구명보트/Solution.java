import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0, index = 0, sum = 0;
		Arrays.sort(people);

		for (int i = people.length - 1; i >= 0; i--) {
			if (index > i)
				break;
			sum = people[i];
			
			while (sum + people[index] <= limit) {
				sum += people[index];
				index++;
			}
			answer++;
		}
		return answer;
	}
}