package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012 {
	static int map[][];
	static int check[][];
	static int N,M,K;
	
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static int dfs(int y , int x) {
		if(map[y][x] == 0 || check[y][x] == 1)return 0;
		else {
			check[y][x] = 1;
			for(int i = 0 ; i < 4 ; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(nx >=0 && nx < M && ny >= 0 && ny < N) {
					dfs(ny ,  nx);
				}
			}
			return 1;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T= Integer.parseInt(st.nextToken());
		for(int t = 0 ; t < T ; t++) {
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int y ,x;
			int result = 0;
			map = new int[N][M];
			check = new int[N][M];
			for(int i = 0 ; i < K ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					result += dfs(i,j);					
				}
			}
			System.out.println(result);
		}
	}
}
