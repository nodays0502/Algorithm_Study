package Lecture0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	static int N , M;
	static int map[][];
	static int dy[] = {0,0,1,-1};
	static int dx[] = {1,-1,0,0};
	static int bfs() {
		int result = -1 ;
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ;  j< M ; j++) {	
				if(map[i][j] == 1) {
					q.add(new int[] {i,j});
				}
			}
		}
		int cnt = 0 ;
		while(!q.isEmpty()) {
			int size = q.size();
			if(check()) {result = cnt; break;}
			for(int t = 0 ;t < size; t++) {
				int[] now  = q.poll();
				for(int i = 0 ; i < 4; i++) {
					int ny = now[0] + dy[i];
					int nx = now[1] + dx[i];
					if(nx>=0 && nx < M && ny >=0 && ny < N && map[ny][nx] == 0) {
						map[ny][nx] = 1;
						q.offer(new int[] {ny,nx});
					}
				}
			}
			cnt++;
		}
		return result;
	}
	static boolean check() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ;  j< M ; j++) {
				if(map[i][j] == 0 ) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ;  j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	//	System.out.println("?");
		System.out.println(bfs());
	}

}
