package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1613 {
	static int n, k,s;
	static int map[][]; // 앞 번호 먼저 -1 뒤 번호 먼저 1 모르면  0
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," " );
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		for(int i = 0 ; i < k ; i++) {
			st = new StringTokenizer(br.readLine()," " );
			int a = Integer.parseInt(st.nextToken()); // 먼저
			int b = Integer.parseInt(st.nextToken());
			map[b][a] = 1;
		}
		for(int l = 1 ; l <= n ; l++) {
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 1; j <= n ; j++) {
					if(map[i][j] == 1) continue;
					map[i][j] = map[i][l] & map[l][j];
				}
			}
		}
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1; j <= n ; j++) {
				if(map[i][j] == 1)
					map[j][i] = -1;
			}
		}

		st = new StringTokenizer(br.readLine()," " );
		s = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < s ; i++) {
			st = new StringTokenizer(br.readLine()," " );
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(map[a][b]);
		}
	}
}
