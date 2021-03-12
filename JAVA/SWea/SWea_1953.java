package Study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWea_1953 {
	static int N , M , R ,C , L; // 세로 가로 맨홀 y 맨홀x 시간
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int tunnel[][] = {
			{},
			{0,1,2,3}, // 1
			{0,2}, // 2
			{1,3}, // 3
			{0,1}, // 4
			{1,2}, // 5
			{2,3}, // 6
			{3,0} // 7
	};
	static int input[][] ;
	static boolean visit[][];
	static int result = 0 ;
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int sum = 1;
		int level = 1;
		visit[R][C] = true;
		q.add(new int[] {R,C});
		while(!q.isEmpty()) {
			if(level == L) break;
			int size = q.size();
			for(int k = 0 ; k < size ; k++) {
				int[] now = q.poll();
				int nValue = input[now[0]][now[1]];
				for(int i = 0 ; i < tunnel[nValue].length;i++) {
					int dir = tunnel[nValue][i];
					int ny = now[0] + dy[dir];
					int nx = now[1] + dx[dir];
		//			System.out.println(now[0]+" "+now[1]+" "+dir);
					if(nx >= 0 && nx < M && ny >=0 && ny < N && !visit[ny][nx] && input[ny][nx] != 0) {
						int reverseDir = (dir + 2) % 4;
					//	System.out.println("res"+reverseDir);
						for(int p = 0 ; p < tunnel[input[ny][nx]].length ; p++) {
							if(tunnel[input[ny][nx]][p] == reverseDir) {
					//			System.out.println(tunnel[input[ny][nx]][p]);
								visit[ny][nx] = true;
								q.add(new int[] {ny,nx});
								sum++;
								break;
							}
						}

					}
				}				
			}
			level++;
		}
		result = sum;
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SWea_1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T ; t++) {
			result = 0 ;
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			input = new int[N][M];
			visit = new boolean[N][M];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < M ; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs();

			System.out.println("#"+t+" "+result);
		}
	}
}
