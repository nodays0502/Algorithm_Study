package lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWea_7465 {
	static int N, M;
	static int parent[];
	static int result;
	static void make() {
		for(int i = 0 ; i <= N; i++) {
			parent[i] = i;
		}
	}
	static int findSet(int a) {
		if(a == parent[a]) return a;
		else return parent[a] = findSet(parent[a]);
	}
	static void union(int a , int b) {
		int parentA = findSet(a);
		int parentB = findSet(b);
		if(parentA == parentB) {
			;
		}else {
			result--;
			parent[parentB] = parentA;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T ; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken()); 
			M = Integer.parseInt(st.nextToken()); 
			result = N;
			parent = new int[N+1];
			make();
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
