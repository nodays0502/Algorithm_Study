package Study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWea_1949 {
	static int N, K;
	static int input[][];
	static boolean dp[][];
	static int dy[] = {0,-1,0,1};
	static int dx[] = {1,0,-1,0};
	static int max = 0;
	static int dfs(int y , int x, int prev, boolean use) {
		dp[y][x] = true;
		int result = 1;
		for(int i = 0 ; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(nx >= 0 && nx < N && ny >= 0 && ny < N && !dp[ny][nx]) {
				if(prev > input[ny][nx]) {
					result = Math.max(result , dfs(ny,nx,input[ny][nx],use)+1);
				}else if(!use){
					for(int j = 1 ; j <= K ; j++) {
						if(prev > input[ny][nx] - j)
							result = Math.max(result , dfs(ny,nx,input[ny][nx] - j,true) + 1 );
					}
				}
			}
		}
		dp[y][x] = false;
		return result;
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SWea_1949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1 ; t <= T; t++) {
			max = 0 ;
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			input = new int[N][N];
			dp = new boolean[N][N];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < N; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, input[i][j]);
				}
			}
			int result = 0 ;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N; j++) {
					if(input[i][j] == max) {
						result = Math.max(result, dfs(i,j,input[i][j],false));
			//			if(result == 7) {System.out.println(i+" "+j);}
					}
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
