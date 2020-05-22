import java.util.Scanner;

public class Main {
	private static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = partition(arr, low, high);
			sort(arr, low, mid - 1);
			sort(arr, mid, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[(low + high) / 2];
		while (low <= high) {
			while (arr[low] > pivot)
				low++;
			while (arr[high] < pivot)
				high--;
			if (low <= high) {
				swap(arr, low, high);
				low++;
				high--;
			}
		}
		return low;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num, index = 0,temp;
		num = sc.nextInt();
		temp=num;
		while (num!=0) {
			num /= 10;
			index++;
		}
		int[] arr = new int[index];
		for (int i = 0; i < index; i++) {
			arr[i] = temp%10;
			temp/=10;
		}

		sort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]);
	}
}