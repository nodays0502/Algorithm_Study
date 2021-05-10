package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class Pair implements Comparable<Pair>{
	int a;
	int b;
	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(Pair o) {
		return a - o.a;
	}
}
public class BOJ_2565 {
	static int n;
	static Pair input[];
	static int LIS[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		input = new Pair[n];
		LIS = new int[n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			input[i] = new Pair(a,b);
		}
		int result = 1;
		Arrays.sort(input);
		for(int i = 0 ; i < n ; i++) {
			if(LIS[i] == 0)
			LIS[i] = 1;			
			for(int j = i+1 ; j < n ; j++) {
				if(input[i].b < input[j].b) {
					LIS[j] = Math.max(LIS[i] + 1, LIS[j]);
					result = Math.max(LIS[j], result);
				}
			}
		}
//		System.out.println(Arrays.toString(LIS));
		System.out.println(n - result);
	}
}
