package HW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWea_1868 {
	static int n;
	static char map[][];
	static int check[][];
	static boolean visited[][];
	static int dy[] = {-1,0,1,0,-1,1,1,-1};
	static int dx[] = {0,1,0,-1,1,1,-1,-1};
	static void bfs(int y , int x) {
		Queue<int[]>q = new LinkedList<>();
		q.offer(new int[] {y,x});
		visited[y][x] = true;
		int result = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0 ; i < 8 ; i++) {
				int ny = now[0]+dy[i];
				int nx = now[1]+dx[i];
				if(nx>=0 && nx < n && ny >=0 && ny < n && !visited[ny][nx]) {
					if(check[ny][nx] == 0) {
						q.offer(new int[] {ny,nx});
					}
					visited[ny][nx] = true;
				}
			}
		}
	}
	static int count(int y , int x) {
		int cnt = 0 ;
		for(int i = 0 ; i < 8 ; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(nx>=0 && nx < n && ny >=0 && ny < n && map[ny][nx] == '*') {
				cnt++;
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			check = new int[n][n];
			visited = new boolean[n][n];
			
			for(int i = 0 ; i < n ; i++) {
				String command = br.readLine();
				for(int j = 0 ; j < n ; j++) {
					map[i][j] = command.charAt(j);
				}
			}
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(map[i][j] == '*') {
						check[i][j] = 10;
					}else {
						check[i][j] = count(i,j);
					}
				}
			}
			int result = 0 ;
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(visited[i][j]) continue;
					if(check[i][j] == 10) {
						visited[i][j] = true;
					}else if(check[i][j] == 0) {
						bfs(i,j);
						result++;
					}
				}
			}
//			System.out.println(result);
//			for(int i = 0 ; i < n ; i++) {
//				for(int j = 0 ; j < n ; j++) {
//					if(visited[i][j])
//					System.out.print(1+" ");
//					else
//						System.out.print(0+" ");
//				}
//				System.out.println();
//			}
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(!visited[i][j]) {
						result++;
					}
				}
			}
			System.out.printf("#%d %d\n",t,result);
		}
	}

}
