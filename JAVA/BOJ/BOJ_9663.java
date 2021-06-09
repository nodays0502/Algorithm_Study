package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9663 {
	static int N;
	static int result = 0 ;
	static int map[][];
	static int dy[] = {-1,0,1,0,-1,1,1,-1};
	static int dx[] = {0,1,0,-1,1,1,-1,-1};
	static boolean col[];
	static void dfs(int depth){
		if(depth == N) {
			result++;
		}else {
			for(int i = 0 ; i < N ; i++) {
				if(map[depth][i] == 0 && !col[i] && check(depth,i)) {
					col[i] = true;
					map[depth][i] = 1;
					dfs(depth+1);
					col[i] = false;
					map[depth][i] = 0;
				}
			}
		}
	}
	static boolean check(int y, int x) {
		boolean flag = true;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == 1 && Math.abs(y-i) == Math.abs(x-j)) {
					return false;
				}
			}
		}
		return flag;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		col = new boolean[N];
		dfs(0);
		System.out.println(result);
	}
}
