package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {
	static int n , m;
	static char map[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<>();
	static int bfs() {
		int cnt = 0;
		for(int i = 0  ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j] == 'F')
				q.offer(new int[] {i,j,'F'});
			}
		}
		while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for(int t = 0 ; t < size ; t++) {
				int[] now = q.poll();
//				System.out.println(Arrays.toString(now));
				int type = now[2];
				if(type == 'J' && map[now[0]][now[1]] == 'F') continue;
				for(int i = 0 ; i < 4 ; i++) {
					int ny = now[0] + dy[i];
					int nx = now[1] + dx[i];
					if((nx < 0 || ny >= n || nx < 0 || nx >= m) && type == 'J'){
						return cnt;
					}
					if(ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] != '#' && map[ny][nx] != 'F') {
						if(type == 'J' && map[ny][nx] == 'J') {
							;
						}else {
							map[ny][nx] = (char)type;
							q.offer(new int[] {ny,nx,type});														
						}

					}
				}
			
			}
		}
		
		return -1;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for(int i = 0  ; i < n ; i++) {
			String command = br.readLine();
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = command.charAt(j);
				if(map[i][j] == 'J')
					q.offer(new int[] {i,j,'J'});
			}
		}
		int result = bfs();
		if(result == -1)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(result);
	}
}
