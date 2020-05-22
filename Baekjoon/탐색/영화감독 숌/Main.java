import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(), cnt = 666, count = 0;
		String str;

		while (true) {
			str = Integer.toString(cnt);
			
			if (str.contains("666"))
				count++;
			if (num == count) {
				System.out.println(cnt);
				break;
			}
			cnt++;
		}
	}
}