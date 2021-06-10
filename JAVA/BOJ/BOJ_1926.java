package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1926 {
	static int n, m;
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int map[][];
	static boolean visited[][];
	static int dfs(int y, int x) {
		int result = 1;
		visited[y][x] = true;
		for(int i = 0 ; i < 4 ; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == 1 && !visited[ny][nx]) {
				result += dfs(ny,nx);
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		int count = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					count++;
					result = Math.max(result, dfs(i,j));
				}
			}
		}
		System.out.println(count);
		System.out.println(result);
	}
}
