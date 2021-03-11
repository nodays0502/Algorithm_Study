package Study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWea_10966 {
	static int N , M;
	static char input[][];
	static boolean visit[][];
	static int result = 0 ;
	static int dy[] = {0,-1,0,1};
	static int dx[] = {1,0,-1,0};
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int sum = 0 ;
		int level = 1;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(input[i][j] == 'W') {q.offer(new int[] {i,j}); visit[i][j] = true;}
			}
		}
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0 ; i < size ; i++) {
				int[] now = q.poll();
			//	System.out.println(now[0]+" "+now[1]);
				for(int j = 0 ; j < 4; j++) {
					int ny = now[0] + dy[j];
					int nx = now[1] + dx[j];
					if(nx >= 0 && nx < M && ny >= 0 && ny < N && !visit[ny][nx]) {
						visit[ny][nx] = true;
						q.offer(new int[] {ny,nx});
						sum += level;
					}
				}
			}
			level++;
		}
		result = sum;
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SWea_10966.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t= 1 ; t <= T ; t++) {
			result = 0;
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			input = new char[N][M];
			visit = new boolean[N][M];
			for(int i = 0 ; i < N ; i++) {
				String temp =  br.readLine();
				for(int j = 0 ; j < M ; j++) {
					input[i][j] = temp.charAt(j);
				}
			}
			bfs();
			System.out.println("#"+t+" "+result);
		}
	}
}
