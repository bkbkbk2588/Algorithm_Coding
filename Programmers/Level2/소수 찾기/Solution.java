import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
	public static int solution(String numbers) {
		int answer = 0, num = 0;
		String[] str = numbers.split("");
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean bool = false, flag = false;
		Arrays.sort(str);
		String temp = "";
		int temp_num = 0;
		
		
		for (int i = str.length - 1; i >= 0; i--) {
			temp += str[i];
			stack.push(Integer.parseInt(str[i]));
		}
		
		for (int i = 2; i <= Integer.parseInt(temp); i++) {
			temp_num = i;

			for (int k = str.length - 1; k >= 0; k--)
				stack.push(Integer.parseInt(str[k]));
			
			while (temp_num > 0) {				
				num = temp_num % 10;
				temp_num = temp_num / 10;
				if (stack.contains(num)) {
					flag = true;
					stack.remove(stack.indexOf(num));
				}
				else {
					flag = false;
					break;
				}
			}
			if (flag) {
				queue.add(i);
			}
			stack.clear();
		}

		while(!queue.isEmpty()) {
			bool = false;
			num = queue.poll();
			
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					bool = true;
					break;
				}
			}
			if (!bool) {
				answer++;
			}
		}
		return answer;
	}
}