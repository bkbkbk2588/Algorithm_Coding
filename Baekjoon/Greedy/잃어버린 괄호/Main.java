import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String expression = sc.nextLine(), temp = "";
		int sum = 0, sub = 0, num = 0;

		for (int i = expression.length() - 1; i >= 0; i--) {

			if (expression.charAt(i) == '+') {
				num += Integer.parseInt(temp);
				temp = "";
			} else if (expression.charAt(i) == '-') {
				num += Integer.parseInt(temp);
				sub += num;
				num = 0;
				temp = "";
			} else {
				temp = Character.toString(expression.charAt(i)).concat(temp);

				if (i == 0) {
					num += Integer.parseInt(temp);
					sum = num;
				}
			}
		}
		System.out.println(sum - sub);
	}
}
