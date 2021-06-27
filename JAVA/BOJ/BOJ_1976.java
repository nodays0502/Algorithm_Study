import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976 {
	static int parents[];
	static void makeSet() {
		for(int i = 0 ; i <= n ; i++) {
			parents[i] = i;
		}
	}
	static int findSet(int now) {
		if(now == parents[now]) return now;
		else return parents[now] = findSet(parents[now]);
	}
	static boolean union(int a, int b) {
		int aParent = findSet(a);
		int bParent = findSet(b);
		if(aParent == bParent) return true;
		else {
			parents[aParent] = bParent;
			return false;
		}
	}
	static int n;
	static int m;
	static int input[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		input = new int[m];
		parents = new int[n+1];
		makeSet();
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1 ; j <= n ; j++) {
				int bool = Integer.parseInt(st.nextToken());
				if(bool == 1) {
					union(i,j);
				}
			}
		}	
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < m ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		boolean flag = true;
		for(int i = 1 ; i < m ; i++) {
			int aParent = findSet(input[i-1]);
			int bParent = findSet(input[i]);
			if(aParent != bParent) {
				flag = false;
				break;
			}
		}
		if(flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
