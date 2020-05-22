import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), len = 0;
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			String temp = sc.nextLine(), str = "";
			for (int j = temp.length() - 1; j >= 0; j--)
				str += temp.charAt(j);
			if (map.containsKey(temp) || temp.equals(str)) {
				len = temp.length();
				answer = Character.toString(temp.charAt(len / 2));
				break;
			}
			map.put(temp, 1);
			map.put(str, 1);
		}
		System.out.println(len + " " + answer);
	}
}