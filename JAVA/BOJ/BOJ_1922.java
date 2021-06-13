package MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
class Node{
	int end;
	int weight;
	public Node(int end, int weight) {
		super();
		this.end = end;
		this.weight = weight;
	}
}
public class BOJ_1922 {
	static int n;
	static int m;
	static List<Node> map[];
	static int prim() {
		int result = 0 ;
		int distance[] = new int[n+1];
		boolean visited[] = new boolean[n+1];
		Arrays.fill(distance,Integer.MAX_VALUE);
		distance[1] = 0;
		for(int i = 1 ; i <= n ; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = 1;
			for(int j = 1; j <= n ; j++) {
				if(!visited[j] && min > distance[j]) {
					minIndex= j;
					min = distance[j];
				}
			}
			result += min;
			visited[minIndex] = true;
			for(int j = 0 ; j < map[minIndex].size(); j++) {
				int nowIndex = map[minIndex].get(j).end;
				int length = map[minIndex].get(j).weight;
				if(!visited[nowIndex] && length < distance[nowIndex]) {
					distance[nowIndex] = length;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		map = new List[n+1];
		for(int i = 1 ; i <= n ; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a].add(new Node(b,c));
			map[b].add(new Node(a,c));
		}
		System.out.println(prim());
	}
}
