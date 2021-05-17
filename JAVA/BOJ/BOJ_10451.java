package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10451 {
	static int parents[];
	static int n;
	static int findSet(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = findSet(parents[a]);
	}
	static boolean union(int a, int b) {
		int parentA = findSet(a);
		int parentB = findSet(b);
		if(parentA == parentB) return false;
		else {
			parents[b] = parentA;
			return true;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t= 0 ; t < T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			n  = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			for(int i = 1 ; i <= n ; i++) {
				parents[i] = i;
			}
			int result = 0 ;
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 1 ; i <= n ; i++) {
				int child = i;
				int parent = Integer.parseInt(st.nextToken());
				if(!union(child,parent)) {
					result++;
				}
			}
			System.out.println(result);
		}
	}
}
