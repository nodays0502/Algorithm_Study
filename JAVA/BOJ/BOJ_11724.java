package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724 {
	static int N,M;
	static boolean connected[][];
	static boolean check[];
	static int dfs(int now) {
		if(check[now] == true) return 0;
		else {
			check[now] = true;
			for(int i = 1 ; i <= N ; i++) {
				if(connected[i][now]) {
					dfs(i);
				}
			}
			return 1;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		connected = new boolean[N+1][N+1];
		check = new boolean[N+1];
		for(int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int y , x;
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			connected[y][x] = true;
			connected[x][y] = true;
		}
		int result = 0;
		for(int i = 1; i <= N ; i++) {
			result += dfs(i);
		}
		System.out.println(result);
	}
}
