package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {
	static char input[][];
	static int dp[][];
	static int N,M;
	static int sy,sx;
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		int result = -1 ;
		q.offer(new int[] {sy,sx});
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(input[i][j] == '*') {
					q.offer(new int[] {i,j});
				}
			}
		}
//		System.out.println(q.size());
//		System.out.println((q));
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int ny , nx;
			int count = dp[now[0]][now[1]];
	//		System.out.println(input[now[0]][now[1]]+" "+now[0] +" "+ now[1]+" "+ count);
			if(input[now[0]][now[1]] == '^') {input[now[0]][now[1]] = '*';q.offer(new int[] {now[0],now[1]});continue;} 
			for(int i = 0 ; i < 4 ; i++) {
				if(input[now[0]][now[1]] == '*') {
					ny = now[0] + dy[i];
					nx = now[1] + dx[i];
					if(nx >= 0 && nx < M && ny >=0 && ny < N && (input[ny][nx] == '.' || input[ny][nx] == '@')) {
						if(input[ny][nx] == '@'){
							input[ny][nx] = '^'; // 불과 사람이 겹칠때
						}else {input[ny][nx] = '*';
							q.offer(new int[] {ny,nx});
						}
					}
				}else {
					if(now[0] == 0 || now[1] == 0 || now[0] == N-1 || now[1] == M-1 ) {return count; }
					ny = now[0] + dy[i];
					nx = now[1] + dx[i];
					if(nx >= 0 && nx < M && ny >= 0 && ny < N && input[ny][nx] == '.' && dp[ny][nx] == 0) {
						input[ny][nx] = '@';
						input[now[0]][now[1]] = '.';
						q.offer(new int[] {ny,nx});
						dp[ny][nx] = count + 1;
					}
				}
				
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0 ; t < T ; t++) {
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			input = new char[N][M];
			dp = new int[N][M];
			for(int i = 0 ; i < N ; i++) {
				String command = br.readLine();
				for(int j = 0 ; j < M ; j++) {
					input[i][j] = command.charAt(j);
					if(input[i][j] == '@'){
						sy = i ; sx = j;
					}
				}
			}
			dp[sy][sx] = 1;
			int result = bfs();
			if(result == -1)System.out.println("IMPOSSIBLE");
			else System.out.println(result);

		}
	}
}
