package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {
	static int n, m ;
	static int dy[] = {0,0,1,-1};
	static int dx[] = {-1,1,0,0};
	static int input[][] ;
	static int bfs() {
		boolean visited[][] = new boolean[n][m]; // 방문체크
		Queue<int[]> q  = new LinkedList<>();
		q.add(new int[] {0,0});
		visited[0][0] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if(nx >= 0 && nx < m && ny>=0 && ny<n && !visited[ny][nx]) {
					visited[ny][nx] = true;
					if(input[ny][nx] == 1) { // 공기 중의 치즈 부분
						input[ny][nx] = 0; 
						cnt++;
					}else { // 공기들
						q.offer(new int[] {ny,nx});
					}
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < m ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int cheeze = 0 ;
		int lastcheeze = 0;
		while(true) {
			cheeze = bfs();
			if(cheeze == 0)break;
			cnt++;
			lastcheeze = cheeze;
		}
		System.out.println(cnt);
		System.out.println(lastcheeze);
	}
}
