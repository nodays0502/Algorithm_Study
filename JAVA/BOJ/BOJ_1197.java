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
public class BOJ_1197 {
	static int V ,E;
	static List<Node> map[];
	static int prim() {
		int result = 0;
		int distance[] = new int[V+1];
		boolean visited[] = new boolean[V+1];
		Arrays.fill(distance,Integer.MAX_VALUE);
		distance[1] = 0;
		for(int i = 1 ; i <=V ; i++ ) {
	//		System.out.println(Arrays.toString(distance));
			int min = Integer.MAX_VALUE;
			int minIndex = 1;
			for(int j = 1; j <= V ; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					minIndex = j;
				}
			}
			result += min;
			visited[minIndex] = true;
//			System.out.println(minIndex);
			for(int j = 0 ; j < map[minIndex].size(); j++) {
				int nowIndex = map[minIndex].get(j).end;
				int length = map[minIndex].get(j).weight;
				if(!visited[nowIndex] && length < distance[nowIndex]) {
	//				System.out.println("length:"+length);
					distance[nowIndex] = length;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		map = new List[V+1];
		for(int i = 0 ; i <= V ; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < E ; i++) {
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
