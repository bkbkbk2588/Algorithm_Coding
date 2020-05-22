import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		HashMap<Integer, String> index = new HashMap<>();
		HashMap<String, Integer> po = new HashMap<>();

		int n = sc.nextInt();
		int m = sc.nextInt();
		String[] answer = new String[m];
		sc.nextLine();

		for (int i = 1; i <= n; i++) {
			String temp = sc.nextLine();
			index.put(i, temp);
			po.put(temp, i);
		}

		for (int i = 0; i < m; i++) {
			String temp = sc.nextLine();
			if (temp.charAt(0) >= 48 && temp.charAt(0) <= 57)
				answer[i] = index.get(Integer.parseInt(temp));
			else
				answer[i]=Integer.toString(po.get(temp));
		}
		
		for (int i = 0; i < m; i++)
			System.out.println(answer[i]);
	}
}
