package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_2589 {
	static int n,m;
	static char map[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {y,x});
		boolean visited[][] = new boolean[n][m];
		visited[y][x] = true;
		int result = -1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int t = 0 ; t < size ; t++) {
				int[] now = q.poll();
				for(int i = 0 ; i < 4; i++) {
					int ny = now[0] + dy[i];
					int nx = now[1] + dx[i];
					if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && map[ny][nx] == 'L') {
						visited[ny][nx] = true;
						q.offer(new int[] {ny,nx});
					}
				}
			}
			result++;
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for(int i = 0 ; i < n ; i++) {
			String Command = br.readLine();
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Command.charAt(j);
			}
		}
		int result = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
	//			System.out.println(i+" "+j);
				if(map[i][j] == 'L')
					result = Math.max(result, bfs(i,j));
			}
		}
		System.out.println(result);
	}
}
