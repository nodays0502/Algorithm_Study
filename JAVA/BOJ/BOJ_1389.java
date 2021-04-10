package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1389 {
	static int n , m;
	static int map[][];
	static final int LIMIT = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				if(i != j)
					map[i][j] = LIMIT;
			}
		}
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}

		for(int k = 1 ; k <= n ; k++) {
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 1 ; j <= n ; j++) {
					if(i != j && k != i&& k != j && map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		int min = LIMIT;
		int minIndex = 1;
		for(int i = 1 ; i <= n ; i++) {
			int sum = 0 ;
			for(int j = 1 ; j <= n ; j++) {
				sum += map[i][j];
			}
//			System.out.println(sum);
			if(sum < min) {
				min = sum;
				minIndex = i;
			}
		}
		System.out.println(minIndex);
	}
}
