package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963 {
	static int m, n;
	static int input[][];
	static int dy[] = {0,1,0,-1,-1,1,1,-1};
	static int dx[] = {1,0,-1,0,1,-1,1,-1};
	static void dfs(int y , int x) {
		if(input[y][x] == 1) input[y][x] = 0;
		for(int i = 0 ; i < 8 ; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(nx>=0 && nx < m && ny >=0 && ny < n && input[ny][nx] == 1) {
				dfs(ny,nx);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			input = new int[n][m];
			if(n == 0 && m == 0 )break;
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ;  j< m ; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 0;
			boolean visited[][] = new boolean[n][m];
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < m ; j++) {
					if(!visited[i][j] && input[i][j] == 1) {
						result++;
						dfs(i,j);
					}
				}
			}
			System.out.println(result);
			
		}
		
	}
}
