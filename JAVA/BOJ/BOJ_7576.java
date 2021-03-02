package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	static int N,M;
	static int input[][];
	static int dp[][];
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static int result = 0;
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(input[i][j] == 1) q.offer(new int[] {i,j});
				else{dp[i][j] = -1;}
			}
		}
		while(!q.isEmpty()) {
	//		System.out.println(q);
			int[] now = q.poll();
			for(int i =  0 ; i < 4 ; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				int count = dp[now[0]][now[1]];
				if(nx >=0 && nx < M && ny >=0 && ny < N && dp[ny][nx] == -1 && input[ny][nx] == 0) {
					input[ny][nx] = 1;
					dp[ny][nx] = count + 1;
					q.offer(new int[] {ny,nx});
					result = count+1;
				}
			}
		}
	}
	static boolean check() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(input[i][j] == 0) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		dp = new int[N][M];
		input = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			 st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < M ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		if(check())System.out.println(result);
		else System.out.println(-1);
	}
}
