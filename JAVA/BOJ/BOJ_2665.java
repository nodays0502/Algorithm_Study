package dij;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_2665 {
	static int n;
	static int map[][];
	static int cache[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int bfs() {
		int result = 0;
		PriorityQueue<int[]> q= new PriorityQueue<>((o1,o2)->{
			return cache[o1[0]][o1[1]] - cache[o2[0]][o2[1]];
		});
		q.offer(new int[] {0,0});
		cache[0][0] = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
		//	if(now[0] == n-1 && now[1] == n-1) break;
			int value = cache[now[0]][now[1]];
			for(int i = 0 ; i < 4 ; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n ) {
					if(map[ny][nx] == 0 && (cache[ny][nx] == -1 || cache[ny][nx] > value + 1)) {
						cache[ny][nx] = value + 1;
						q.offer(new int[] {ny,nx}); 
					}
					else if(map[ny][nx] == 1 && (cache[ny][nx] == -1 || cache[ny][nx] > value)) {
						cache[ny][nx] = value;
						q.offer(new int[] {ny,nx}); 
					}
				}
			}
		}
		result = cache[n-1][n-1];
		return result;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		cache = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = temp.charAt(j)-'0';
				cache[i][j] = -1;
			}
		}
		System.out.println(bfs());
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(cache[i][j]);
			}	
			System.out.println();
		}
	}
}
