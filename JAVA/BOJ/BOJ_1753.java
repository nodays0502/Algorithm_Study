package Lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1753 {	
	static ArrayList<int[]> input[];
	static int V,E,start;
	static boolean[] visited;
	static int length[];
	static void dij() {
		visited = new boolean[V+1];
		length = new int[V+1];
		for(int i = 1 ; i <= V; i++) {
			length[i] = Integer.MAX_VALUE;
		}

		length[start] = 0;
		for(int t = 0 ; t < V ; t++) {
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for(int i = 1 ; i <= V; i++) {
				if(!visited[i] && min > length[i]) {
					min = length[i];
					minIndex = i;
				}
			}
			visited[minIndex] = true;
			if(min == Integer.MAX_VALUE) break;
			for(int j = 0 ; j < input[minIndex].size();j++) {
				int now = input[minIndex].get(j)[0];
				if(!visited[now] && input[minIndex].get(j)[1] + min < length[now]) {
					length[now] = input[minIndex].get(j)[1] + min;
				}
			}			
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		input = new ArrayList[V+1];
		for(int i = 0 ; i < V+1 ; i ++) {
			input[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			input[a].add(new int[] {b,w});
		}
		dij();
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= V; i++) {
			if(length[i] != Integer.MAX_VALUE)
				sb.append(length[i]+"\n");
			//	System.out.println(length[i]);
			else
				sb.append("INF\n");
			//	System.out.println("INF");
		}
		System.out.println(sb.toString());
	}
}
