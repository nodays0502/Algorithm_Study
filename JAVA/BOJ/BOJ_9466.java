package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9466 {
	static int input[];
	static boolean team[];
	static boolean visited[];
	static boolean finished[];
	static int N;
	static int cnt;
	static void dfs( int now ) {
		visited[now] = true;
		int next = input[now];
		if(!visited[next]) {
			dfs(next);
		}else if(!finished[next]) {
			for(int i = next; i != now ; i = input[i]) {
				cnt++;
			}
			cnt++;
		}
		finished[now] = true;
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T =  Integer.parseInt(st.nextToken());
		for(int t= 0 ; t < T ; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			input = new int[N+1];
			team = new boolean[N+1];
			visited = new boolean[N+1];
			finished = new boolean[N+1];
			cnt = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1 ; i <= N ; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 1 ; i <= N ; i++) {
				if(!visited[i])
					dfs(i);
			}

			System.out.println(N-cnt);
		}
		
	}

}
