package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10026 {
	static int n; // 
	static char input[][];
	static boolean visited[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static int dfs(int y , int x) {
		if(visited[y][x] == true) return 0 ;
		else {
			int result = 1;
			visited[y][x] = true;
			for(int i = 0 ; i < 4 ; i++ ){
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n && input[y][x] == input[ny][nx]) {
					dfs(ny,nx);
				}
			}
			return result;
		}
	}
/*	static int dfs2(int y , int x) {
		if(visited[y][x] == true) return 0 ;
		else {
			int result = 1;
			visited[y][x] = true;
			for(int i = 0 ; i < 4 ; i++ ){
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if(input[y][x] == 'B') {
						if(input[ny][nx] == input[y][x]) dfs(ny,nx);
					}else { 
						if(input[ny][nx] == 'R' || input[ny][nx] == 'G') dfs(ny,nx);	
					}
				}
			}
			return result;
		}
	}*/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		input = new char[n][n];
		visited = new boolean[n][n];
		for(int i = 0 ; i < n ; i++) {
			String command = br.readLine();
			for(int j = 0 ; j < n ; j++) {
				input[i][j] = command.charAt(j);
			}
		}
		int[] result = new int[] {0,0};
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(dfs(i,j) != 0) {
					result[0]++;
				}
			}
		}
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(input[i][j] == 'G') input[i][j] ='R';
			}
		}
		visited = new boolean[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(dfs(i,j) != 0) {
					result[1]++;
				}
			}
		}
		System.out.println(result[0] + " " + result[1]);
	}
}
