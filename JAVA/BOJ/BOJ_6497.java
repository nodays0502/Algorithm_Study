package MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class MyNode{
	int from;
	int to;
	int weight;
	public MyNode(int from, int to, int wi) {
		super();
		this.from = from;
		this.to = to;
		this.weight = wi;
	}
	
}
public class BOJ_6497 {
	static int n,m;
	static MyNode edgeList[];
	static int parents[];
	static void makeSet() {
		for(int i = 0 ; i < n ; i++) {
			parents[i] = i;
		}
	}
	static int findSet(int a) {
		if(a == parents[a]) return a;
		else return parents[a] = findSet(parents[a]);
	}
	static boolean union(int a, int b) {
		int aParent = findSet(a);
		int bParent = findSet(b);
		if(aParent == bParent) return false;
		else {
			parents[bParent] = aParent;
			return true;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if(n == 0 && m == 0)break;
			edgeList = new MyNode[m];
			parents = new int[n];
			int sum = 0 ;
			for(int i = 0 ; i < m ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
			//	System.out.printf("%d %d %d\n",a,b,c);
				sum += c;
				edgeList[i] = new MyNode(a,b,c);
			}
			Arrays.sort(edgeList,(o1,o2)->{
				return o1.weight - o2.weight;
			});
			makeSet();
//			System.out.println(Arrays.toString(parents));
//			System.out.println(Arrays.toString(edgeList));
			int result = 0;
			for(MyNode edge : edgeList) {
		//		System.out.printf("%d %d %d\n",edge.from,edge.to,edge.weight);
				if(union(edge.from, edge.to)) {
					result += edge.weight;
				}
			}
			System.out.println(sum - result);
		}
		
	}
}
