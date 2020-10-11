import java.util.Scanner;

class Main {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int site = sc.nextInt();
        long answer = 0;
		int[] exam = new int[site], supervision = new int[2];

		for (int i = 0; i < site; i++)
			exam[i] = sc.nextInt();

		supervision[0] = sc.nextInt();
		supervision[1] = sc.nextInt();

		for (int i = 0; i < site; i++) {
			exam[i] -= supervision[0];
			answer++;
			if (exam[i] > 0)
				answer += exam[i] % supervision[1] == 0 ? (exam[i] / supervision[1]) : (exam[i] / supervision[1]) + 1;
		}
		System.out.println(answer);
	}
}
