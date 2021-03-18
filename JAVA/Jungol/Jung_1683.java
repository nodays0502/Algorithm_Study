package Live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jung_1863 {
	static int n , m;
	static int parent[];
	static int result = 0 ;
	static int getParent(int index) {
		if(index == parent[index]) return index;
		else return parent[index] = getParent(parent[index]);
	}
	static void union(int a, int b) {
		int parentA = getParent(a);
		int parentB = getParent(b);
		if(parentA == parentB) ;
		else {
			result--;
			parent[parentB] = parentA;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i = 0 ; i <= n ; i++) {
			parent[i] = i;
		}
		result = n;
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		System.out.println(result);
	}
}
