package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {
	static int N , M;
	static int input[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static boolean check[][] ;
	static int result = 0 ;
	static int special[][][] = { // y , x
			{{0,0}, {1,0}, {2,0} , {1,1}}, // ㅏ
			{{0,0}, {0,1}, {0,2} , {1,1}}, // ㅜ
			{{0,0}, {1,0} ,{1,-1}, {2,0}}, // ㅓ
			{{0,0}, {0,1}, {-1,1} , {0,2}} // ㅗ			
	};
	static void dfs(int y , int x , int cnt ,int sum) {
		if(cnt >= 4) {
			result = Math.max(result,sum);
		}else {
			for(int i = 0 ; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(nx >= 0 && nx < M && ny >= 0 && ny < N && !check[ny][nx]) {
					check[ny][nx] = true;
					dfs(ny , nx , cnt + 1 , sum + input[ny][nx]);
					check[ny][nx] = false;
				}
			}
		}
	}
	static void specialcase(int y , int x) {
		for(int i = 0 ; i < 4 ; i++) {
			int sum = 0;
			for(int j = 0 ; j < 4 ; j++) {
				int ny = y + special[i][j][0];
				int nx = x + special[i][j][1];
				if(nx >= 0 && nx < M && ny >= 0 && ny < N) {
					sum += input[ny][nx];
				}else{
					 sum = 0 ;break;
				}
			}
			result = Math.max(result, sum);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N][M];
		check = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < M ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				 check[i][j] = true;
				 dfs(i,j, 1,input[i][j]);
				 check[i][j] = false;
				 specialcase(i, j);
			}
		}
		System.out.println(result);
	}
}
