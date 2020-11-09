import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		int N = scan.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = random.nextInt();
		}
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.close();
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int sum = 0;

		for(int i = a-1; i<b; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
			if(arr[i] > max) {
				max = arr[i];
			}
			sum += arr[i];
		}
		System.out.println(min+" , "+max+" , "+sum);
	}
}
