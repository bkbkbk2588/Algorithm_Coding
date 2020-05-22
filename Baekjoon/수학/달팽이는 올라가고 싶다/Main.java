import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A,B,V,day=0;
		A=sc.nextInt();
		B=sc.nextInt();
		V=sc.nextInt();
		day=(V+A-2*B-1)/(A-B);
		System.out.println(day);
	}
}