package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
	static int N,M;
	static int input[][];
	static int dp[][][]; // 해당하는 값은 이 지점까지 오는데 걸린 시간
	static int dy[] = {1,0,-1,0};
	static int dx[] = {0,1,0,-1};
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		int result = -1; // dp[0][0][1] dp[0][0][0]
		dp[0][0][0] = 1; // 3차 배열의 인덱스의 해당하는 값은 벽을 뚫었는지 안뚫었는지를 알려준다.
		q.offer(new int[] {0,0,0}) ; 
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int count = dp[now[0]][now[1]][now[2]];
			if(now[0] == N-1 && now[1] == M-1) {result = count; break;}
			for(int i = 0 ; i < 4 ; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if(nx >= 0 && nx < M && ny >= 0 && ny < N ) { 
					if(now[2] == 0 && input[ny][nx] == 1 && dp[ny][nx][1] == 0) { 
					// 아직 안 뚤었고                벽이 존재하고                              아직 가지 않았다면
						q.offer(new int[] {ny,nx,1});
						dp[ny][nx][1] = count+1;
					}
					if(input[ny][nx] == 0 && dp[ny][nx][now[2]] == 0){
					//   벽이 존재하지 않고                          아직 가지 않았다면
						q.offer(new int[] {ny,nx,now[2]});
						dp[ny][nx][now[2]] = count+1;
					}
				}
			}
			
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N][M];
		// DP 해당 좌료를 갔는지 안갔는지를 판단하면서 해당좌표까지 가는데 걸리는 시간을 나타낸다. 3번쨰 인덱스?는 벽뚫을 사용했는지 안 했는지 판단
		dp = new int[N][M][2]; // 0 일대는 벽뚫을 아직
		for(int i = 0 ; i < N; i++) {
			String command = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				input[i][j] = command.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}
}
