import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, X;
		int []A;
		N = sc.nextInt();
		X = sc.nextInt();
		A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		for(int i=0; i<N; i++) {
			if(A[i]<X) {
				System.out.print(A[i]);
				System.out.print(" ");
			}
		}
		
	}
}