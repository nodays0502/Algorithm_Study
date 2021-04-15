package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1504 {
	static int N , E;
	static int map[][];
	static final int INF = 98765432;
	static int target1 , target2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(i != j) {
					map[i][j] = INF;			
				}
			}
		}
		for(int i = 0 ;i < E ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = Math.min(c, map[a][b]);
			map[b][a] = Math.min(c, map[b][a]);
		}
		st = new StringTokenizer(br.readLine()," ");
		target1 = Integer.parseInt(st.nextToken());
		target2 = Integer.parseInt(st.nextToken());
		// 플루이드 워샬사용한 이유 -> 시간복잡도 1억정도
		for(int k = 1 ; k <= N ; k++) { // 플루이드 워샬
			for(int i = 1; i <= N ; i++) {
				for(int j = 1; j <= N ; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		int result = Math.min(map[1][target1] + map[target1][target2] + map[target2][N], map[1][target2] + map[target2][target1] + map[target1][N]);
		if(result >= INF) result = -1; // 3개중 하나가 INF이라는 것 즉, 갈수 없다.
		System.out.println(result);
	}
}
