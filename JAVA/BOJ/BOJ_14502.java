package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_14502 {
	static int n,m;
	static int input[][];
	static int count;
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static int result = 0 ;
	static void comb(int cnt, int start) {
		if(cnt == 3) {
			bfs();
		}else {
			int i = start / m;
			for(int j = start % m ; j < m ; j++) {
				if(input[i][j] == 0) {
					input[i][j] = 1;
					comb(cnt+1 , i * m + j);
					input[i][j] = 0;
				}
			}
			for(i = (start / m) + 1 ; i < n ; i++) {
				for(int j = 0 ; j < m ; j++) {
					if(input[i][j] == 0) {
						input[i][j] = 1;
						comb(cnt+1 , i * m + j);
						input[i][j] = 0;
					}
				}
			}
		}
	}
	static void bfs() {
		boolean check[][] = new boolean[n][m];
	//	System.out.println("bfs()");
		int sum = 0 ;
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(input[i][j] == 2) {
					q.offer(new int[] {i,j});
					check[i][j] = true;
	//				sum++;
				}
			}
		}
//		System.out.println(sum);
		while(!q.isEmpty()) {
			int[] now = q.poll();
//			System.out.println(now[0] +" "+now[1]);
			for(int i = 0 ; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if(nx >= 0 && nx < m && ny >= 0 && ny < n && input[ny][nx] == 0 && check[ny][nx] == false) {
					check[ny][nx] = true;
					q.offer(new int[] {ny,nx});
					sum++;
				}
			}
		}
		result = Math.max(result, count - sum - 3);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < m ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				if(input[i][j] == 0) count++;
			}
		}
//		System.out.println(count);
		comb(0,0);
		System.out.println(result);
	}
}
