import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] arr = new int[n+1];
		int[] stack = new int[n+1];
		String[] answer = new String[1024];
		int count = 0;
		int top = 0;
		int k = 1;
		
		for(int i = 1; i<=n; i++) {
			arr[i] = scan.nextInt();
		}
		
		for(int i = 1; i<=n; i++) {
			stack[++top] = i;
			answer[count++] = "+";
			while(top != 0 && stack[top] == arr[k]) {
				top--;
				answer[count++] = "-";
				k++;
			}
		}
		
		if(top == 0) {
			for(int i = 0; i<count; i++) {
				System.out.println(answer[i]);
			}
		}else{
			System.out.println("NO");
		}		
	}
}
