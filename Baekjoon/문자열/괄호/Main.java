import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < num; i++) {
			String str = sc.nextLine();
			boolean flag = false;
			Stack<Character> stack = new Stack<>();

			for (int j = 0; j < str.length(); j++) {
				char temp = str.charAt(j);

				if (temp == '(')
					stack.push(temp);
				else {
					if (!stack.isEmpty())
						stack.pop();
					else {
						flag = true;
						System.out.println("NO");
						break;
					}
				}
			}
			if (flag)
				continue;

			if (!stack.isEmpty())
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}
}
