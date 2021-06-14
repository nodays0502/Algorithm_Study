package MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int from;
	int to;
	int weight;
	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge o) {
		return weight - o.weight;
	}
}
public class BOJ_1647 {
	static int n, m;
	static Edge[] edgeList;
	static int parents[];
	static void makeSet() {
		for(int i = 0 ; i <= n ; i++) {
			parents[i] = i;
		}
	}
	static int findSet(int a) {
		if(parents[a] == a)return a;
		else return parents[a] = findSet(parents[a]);
	}
	static boolean union(int a , int b) {
		int aParent = findSet(a);
		int bParent = findSet(b);
		if(aParent == bParent) return false;
		else {
			parents[bParent] = aParent;
			return true;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		edgeList = new Edge[m];
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(a,b,c);
		}
		Arrays.sort(edgeList);
		parents = new int[n+1];
		makeSet();
		int result = 0;
		int count = 0;
		for(Edge edge : edgeList) {
			if(union(edge.from,edge.to)) {
				result += edge.weight;
				if(++count == n-2) break;
			}
		}
		System.out.println(result);
	}
}
