package HW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1987 {
	static int N , M;
	static char map[][];
	static boolean use[] = new boolean[26];
//	static int result= 0;
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static int dfs(int y , int x) {
		int result = 0;
		for(int i = 0 ; i < 4 ; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(nx>= 0 && nx < M && ny >= 0 && ny < N && !use[map[ny][nx] - 'A']) {
				use[map[ny][nx] - 'A'] = true;
				result = Math.max(result, dfs(ny,nx));
				use[map[ny][nx] - 'A'] = false;
			}
		}
		return result + 1;
	//		System.out.println(result);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " " );
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][];
		for(int i = 0 ; i < N ; i++) {
			map[i] = br.readLine().toCharArray();
		}

		use[map[0][0] - 'A'] = true;
		System.out.println(dfs(0,0));
		
	}
}
