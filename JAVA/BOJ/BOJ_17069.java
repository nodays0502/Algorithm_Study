package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17069 {
	static int n;
	static int map[][];
	static int[][][] moving = {
			{{0,1,0},{1,1,2}}, // 가로
			{{1,0,1},{1,1,2}},
			{{0,1,0},{1,1,2},{1,0,1}}
	};
	static long dp[][][];
	static long dfs(int y , int x , int type) {
		if(y == n-1 && x == n-1) return 1;
		if(dp[y][x][type] != -1)return dp[y][x][type];
		long result = 0;
		for(int i = 0 ; i < moving[type].length;i++) {
			int ny = y + moving[type][i][0];
			int nx = x + moving[type][i][1];
			if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[ny][nx] == 0) {
				if(i == 1 && (map[ny][x] != 0 || map[y][nx] != 0)) continue;
				result += dfs(ny,nx,moving[type][i][2]);
			}
		}
		dp[y][x][type] = result;
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		map = new int [n][n];
		dp = new long[n][n][3];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j][0] = -1;
				dp[i][j][1] = -1;
				dp[i][j][2] = -1;
			}
		}
		System.out.println(dfs(0,1,0));
	}
}
