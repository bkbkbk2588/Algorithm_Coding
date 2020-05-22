import java.util.Scanner;

public class Main {

	int fac(int num) {
		int temp = num, res=1;
		while(0<temp) {
			res*=temp;
			temp--;
		}
		return res;
	}

	public static void main(String[] args) {
		Main ma = new Main();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(ma.fac(num));
	}
}