package live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWea_1249 {
	static int N;
	static int map[][];
	static int dp[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int cal() {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)-> {
			return dp[o1[0]][o1[1]] - dp[o2[0]][o2[1]];
		});
		int result = 0;
		dp[0][0] = 0;
		q.offer(new int[] {0,0});
		while(!q.isEmpty()) {
			int[] now = q.poll();
//			System.out.println(now[0]+" "+now[1]);
			int count = dp[now[0]][now[1]];
			if(now[0] == N-1 && now[1] == N-1) {result = count; break;}
			for(int i = 0 ; i < 4; i++) {
				int ny = now[0] +dy[i];
				int nx = now[1] +dx[i];
				if(ny >= 0 && ny < N && nx >= 0 && nx < N && 
						(dp[ny][nx] == -1 || dp[ny][nx] > count + map[ny][nx])) {
					dp[ny][nx] = count + map[ny][nx];
					q.offer(new int[] {ny,nx});
				}
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t= 1; t <= T ; t++) {
			int result = 0 ;
			 st = new StringTokenizer(br.readLine()," ");
			 N = Integer.parseInt(st.nextToken());
			 map = new int[N][N];
			 dp = new int[N][N];
			 for(int i = 0 ; i < N ; i++) {
				 String command = br.readLine();
				 for(int j = 0 ; j< N ; j++) {
					 map[i][j] = command.charAt(j)-'0';
					 dp[i][j] = -1;
				 }
			 }
			 
			 
			 System.out.printf("#%d %d\n" , t, cal());
		}
	}

}
