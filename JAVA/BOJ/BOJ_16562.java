import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16562 {
	static int n,m,k;
	static int money[];
	static int parents[];
	static void makeSet() {
		for(int i = 0; i <= n ; i++)
			parents[i] = i;
	}
	static int findSet(int a) {
		if(a == parents[a])return a;
		else return parents[a] = findSet(parents[a]);
	}
	static boolean union(int a, int b) {
		int aParent = findSet(a);
		int bParent = findSet(b);
		if(aParent == bParent) {
			return true;
		}else {
			parents[aParent] = bParent;
			money[bParent] = Math.min(money[bParent], money[aParent]);
			money[aParent] = 0;
			return false;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		money = new int[n+1];
		parents = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		makeSet();
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		int sum = 0 ;
		for(int i = 1 ; i <= n ; i++) {
			sum+= money[i];
		}
		if(sum <= k) {
			System.out.println(sum);
		}else {
			System.out.println("Oh no");
		}
	}
}
