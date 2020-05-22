import java.util.Stack;

public class Solution {
	public int solution(String s) {
		Stack<String> stack = new Stack<String>();
		String[] arr = s.split("");
		int size = s.length();

		for (int i = 0; i < size; i++) {
			if (stack.isEmpty())
				stack.add(arr[i]);
			else {
				if (stack.peek().equals(arr[i]))
					stack.pop();
				else
					stack.push(arr[i]);
			}
		}
		return stack.size() > 0 ? 0 : 1;
	}
}