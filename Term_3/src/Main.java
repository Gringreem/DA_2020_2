import java.util.Random;
import java.util.Scanner;

public class Main {
	static int[] arr, tree_min, tree_max, tree_sum;
	
	static int initMin(int start, int end, int node) {
		if(start == end) {
			return tree_min[node] = arr[start];
		}
		int m = (start + end) / 2;
		return tree_min[node] = Math.min(initMin(start, m, node*2), initMin(m + 1, end, node*2+1));
	}
	
	static int initMax(int start, int end, int node) {
		if(start == end) {
			return tree_max[node] = arr[start];
		}
		int m = (start + end) / 2;
		return tree_max[node] = Math.max(initMax(start, m, node*2), initMax(m + 1, end, node*2+1));

	}
	
	static int initSum(int start, int end, int node) {
		if(start == end) {
			return tree_sum[node] = arr[start];
		}
		int m = (start + end) / 2;
		return tree_sum[node] = initSum(start, m, node*2) + initSum(m+1, end, node*2+1);
	}
	
	static int ans_min(int start, int end, int node, int left, int right) {
		if(right < start || end < left) {
			return Integer.MAX_VALUE;
		}
		if(left <= start && end <= right) {
			return tree_min[node];
		}
		int m = (start + end) / 2;
		return Math.min(ans_min(start, m, node*2, left, right), ans_min(m + 1, end, node*2+1, left, right));
	}
	
	static int ans_max(int start, int end, int node, int left, int right) {
		if(right < start || end < left) {
			return Integer.MIN_VALUE;
		}
		if(left <= start && end <= right) {
			return tree_max[node];
		}
		int m = (start + end) / 2;
		return Math.max(ans_max(start, m, node*2, left, right), ans_max(m + 1, end, node*2+1, left, right));
	}
	
	static int ans_sum(int start, int end, int node, int left, int right) {
		if(right < start || end < left) {
			return 0;
		}
		if(left <= start && end <= right) {
			return tree_sum[node];
		}
		int m = (start + end) / 2;
		return ans_sum(start, m, node*2, left, right) + ans_sum(m+1, end, node*2+1, left, right);
	}
		
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Random random = new Random(100);
		
		int N = scan.nextInt();
		arr = new int[N + 1];
		
		for(int i = 0; i<N; i++) {
			arr[i] = random.nextInt();
		}
		
		tree_min = new int[N * 4];
		tree_max = new int[N * 4];
		tree_sum = new int[N * 4];
		initMin(0, N, 1);
		initMax(0, N, 1);
		initSum(0, N, 1);
		
		int K = scan.nextInt();
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i<K; i++) {
			int a = random.nextInt(N) + 1;
			int b = random.nextInt(N) + 1;
			
			int min;
			int max;
			int sum = 0;
			
			if(a < b) {
				min = ans_min(0, N, 1, a-1, b-1);
				max = ans_max(0, N, 1, a-1, b-1);
				sum = ans_sum(0, N, 1, a-1, b-1);
			}
			else if(b < a) {
				min = ans_min(0, N, 1, b-1, a-1);
				max = ans_max(0, N, 1, b-1, a-1);
				sum = ans_sum(0, N, 1, b-1, a-1);
			}
			else {
				min = arr[a-1];
				max = arr[a-1];
				sum += arr[a-1];
			}
			
//			System.out.println(min + " , "+max+" , "+sum);
			// 출력되는 시간을 줄이기 위해 각 구간에서의 값들을 출력시키지 않고 테스트.
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Elapsed time is "+(end-start)+"ms");
		
		scan.close();
	}

}
