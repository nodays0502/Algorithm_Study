package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Edge{
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
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
	}
	
}
class MyNode{
	int x;
	int y;
	int z;
	int index;
	public MyNode(int x, int y, int z, int index) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.index = index;
	}
	
}
public class BOJ_2887 {
	static int n;
	static int INF = Integer.MAX_VALUE;
	static int parents[];
	static int findSet(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = findSet(parents[a]); 
	}
	static boolean union(int a ,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	static List<Edge> edgeList ;
	static List<MyNode> nodeList ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		edgeList = new ArrayList<Edge>();
		nodeList = new ArrayList<MyNode>();
		parents = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			parents[i] = i;
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			nodeList.add(new MyNode(x,y,z,i));
		}
		nodeList.sort((o1,o2)->o1.x - o2.x);
		for(int i = 1 ; i < n ; i++) {
			edgeList.add(new Edge(nodeList.get(i-1).index,nodeList.get(i).index,nodeList.get(i).x - nodeList.get(i-1).x));
		}
		nodeList.sort((o1,o2)->o1.y - o2.y);
		for(int i = 1 ; i < n ; i++) {
			edgeList.add(new Edge(nodeList.get(i-1).index,nodeList.get(i).index,nodeList.get(i).y - nodeList.get(i-1).y));
		}
		nodeList.sort((o1,o2)->o1.z - o2.z);
		for(int i = 1 ; i < n ; i++) {
			edgeList.add(new Edge(nodeList.get(i-1).index,nodeList.get(i).index,nodeList.get(i).z - nodeList.get(i-1).z));
		}
		edgeList.sort((o1,o2) -> o1.weight - o2.weight);
//		System.out.println(edgeList);
		int result = 0 ;
		int count = 0 ;
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result+= edge.weight;
				if(++count == n-1) break;
			}
		}
		System.out.println(result);
	}
	
}
