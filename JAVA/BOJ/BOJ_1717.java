import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
	static int n, m ;
	static int parents[];
	static void makeSet() {
		for(int i = 0 ; i <= n ; i++) {
			parents[i] = i;
		}
	}
	static int findSet(int now) {
		if(now == parents[now]) return now;
		else return parents[now]= findSet(parents[now]);
	}
	static boolean union(int a, int b) {
		int aParent = findSet(a);
		int bParent = findSet(b);
		if(aParent == bParent) return false;
		else {
			parents[aParent] = bParent;
			return true;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		makeSet();
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(command == 0) {
				union(a,b);
			}else {
				if(findSet(a) == findSet(b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
}
