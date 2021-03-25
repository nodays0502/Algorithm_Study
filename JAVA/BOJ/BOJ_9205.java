package HW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9205 {
	static int n;
	static int y[];
	static int x[];
	static final int INF = 987654321;
	static boolean prim() {
		int distance[] = new int[n];
		boolean visited[] = new boolean[n];
		for(int i = 0 ; i < n ; i++) {
			distance[i] = INF;
		}
		distance[0] = 0;
		for(int i = 0 ; i < n ; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for(int j = 0 ; j < n ; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					minIndex = j;
				}
			}
			visited[minIndex] = true;
	//		System.out.println(Arrays.toString(distance));
	//		System.out.println(min+" " +minIndex);
			if(minIndex == n-1) {
				if(min <= 50*20) return true;
			}
			if(min > 50*20) return false;
			for(int j = 0 ; j < n ; j++) {
				if(!visited[j] ) {
					int length = Math.abs(y[j]-y[minIndex])+Math.abs(x[j] - x[minIndex]);
					distance[j] = Math.min(distance[j], length);
				}
			}
		}
		System.out.println("?");
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0 ; t < T ; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken())+2;
			y = new int[n];
			x = new int[n];
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				y[i] = Integer.parseInt(st.nextToken());
				x[i] = Integer.parseInt(st.nextToken());
			}
			if(prim()) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
	}
}
