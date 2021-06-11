package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
	static int n,m,h;
	static int map[][][];
	static int dy[] = {-1,0,1,0,0,0};
	static int dx[] = {0,1,0,-1,0,0};
	static int dh[] = {0,0,0,0,1,-1};
	static boolean check() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				for(int k = 0 ; k < h ; k++) {
					if(map[i][j][k] == 0)return false;
				}
			}
		}
		return true;
	}
	static int bfs() {
		int result = -1;
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				for(int k = 0 ; k < h ; k++) {
					if(map[i][j][k] == 1) {
						q.offer(new int[] {i,j, k});
					}
				}
			}
		}
		int cnt = 0;
		while(!q.isEmpty()) {
			int T = q.size();
			if(check()) return cnt;
			for(int t = 0; t < T ; t++) {
				int[] now = q.poll();
				for(int i = 0  ; i < 6 ; i++) {
					int ny = now[0] + dy[i];
					int nx = now[1] + dx[i];
					int nh = now[2] + dh[i];
				//	System.out.println(Arrays.toString(now));
					if(nx>=0 && nx < m && ny >= 0 && ny < n && nh >=0 && nh < h && map[ny][nx][nh] == 0) {
						map[ny][nx][nh] = 1;
						q.offer(new int[] {ny,nx,nh});
					}
				}
			}
			cnt++;
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[n][m][h];
		for(int i = 0 ; i < h ; i++) {
			for(int j = 0 ; j < n ; j++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int k = 0 ; k < m ; k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());
				}
			}
		}
		System.out.println(bfs());
	}
}
