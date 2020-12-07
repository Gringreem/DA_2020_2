import java.util.Scanner;

public class Main {
	// ºĞÇÒÁ¤º¹
	static int histo(int[] v, int a, int b) {
		if(a == b) {
			return v[a];
		}
		
		int m = (a + b) / 2;
		
		int r = Math.max(histo(v, a, m), histo(v, m+1, b));
		
		int start = m;
		int end = m+1;
		
		int min = Math.min(v[start], v[end]);
		r = Math.max(r,  min*2);
		
		while(a < start || end < b) {
			if(a < start && ((b == end) || (v[start-1] > v[start + 1]))) {
				--start;
				min = Math.min(min, v[start]);
			}
			else {
				++end;
				min = Math.min(min, v[end]);
			}
			r = Math.max(r, min*(end-start+1));
		}
		
		return r;
	}
	// n : »ùÇÃ¼ö
	// v : n°³ »ùÇÃµéÀÇ µµ¼ö
	// return: ³ĞÀÌ
	static int histo(int[] v, int n) {
		return histo(v, 0, n-1);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] v = new int[n];
		
		for(int i=0; i<n; i++) {
			v[i] = scan.nextInt();
		}
		
		int r = histo(v, n);
		
		System.out.println(r);
	}

}
