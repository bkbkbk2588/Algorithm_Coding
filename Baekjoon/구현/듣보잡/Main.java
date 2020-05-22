import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		HashMap<String,Integer> map = new HashMap<>();
		ArrayList<String> answer = new ArrayList<>();

		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String temp = sc.nextLine();
			map.put(temp, 1);
		}
		
		for(int i=0;i<m;i++) {
			String temp = sc.nextLine();
			if(map.containsKey(temp))
				answer.add(temp);
		}
		Collections.sort(answer);
		System.out.println(answer.size());

		for (int i = 0; i < answer.size(); i++)
			System.out.println(answer.get(i));
	}
}