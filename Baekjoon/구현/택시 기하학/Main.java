import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int radius = sc.nextInt();
		double x = 0;
		
		x = (radius*radius)*2;
		System.out.format("%.6f%n", Math.PI * radius * radius);
		System.out.format("%.6f%n", x);
	}
}