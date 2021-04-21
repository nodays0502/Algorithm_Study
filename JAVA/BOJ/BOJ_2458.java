package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2458 {
	static int n ,m;
	static boolean map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n+1][n+1];
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
		}
		int result = 0;
		for(int k = 1; k <= n ; k++) {
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 1; j <= n ; j++) {
					if(map[i][k] && map[k][j]) {
						map[i][j] = true;
					}
				}
			}
		}
		for(int i = 1 ; i <= n ; i++) {
			int cnt = 0;
			for(int j = 1; j <= n ; j++) {
				if(i == j) continue;
				if(map[i][j] || map[j][i]) {
					cnt++;
				}
			}
			if(cnt == n-1) result++;
		}
		System.out.println(result);
	}
}
