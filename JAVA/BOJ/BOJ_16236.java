package Past;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16236 {
	static int n;
	static int input[][];
	static int check[][];
	static int dy[] = {-1,0,0,1};
	static int dx[] = {0,-1,1,0};
	static int level = 2;
	static int cnt = 0;
	static int now = 10;
	static int result = 0 ;
	static boolean check() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(input[i][j] != 0 && input[i][j] < level) return true;
			}
		}
		return false;
	}
	static void bfs(int sy ,int sx) {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1 , o2) -> {
			if(o1[2] != o2[2]) return o1[2]-o2[2];
			if(o1[0] == o2[0]) return o1[1]-o2[1];
			else return o1[0] - o2[0];
		});
		q.offer(new int[] {sy,sx,0});
		check[sy][sx] = now;
		if(!check()) {
			return;
		}
		while(!q.isEmpty()) {
			int[] nowyx = q.poll();
//			System.out.println(Arrays.toString(nowyx)+" "+level);
			if(input[nowyx[0]][nowyx[1]] != 0 && level > input[nowyx[0]][nowyx[1]]) {
	//			System.out.println(now+" "+level);
				input[nowyx[0]][nowyx[1]] = 0 ;
				check[nowyx[0]][nowyx[1]] = ++now;
				if(++cnt == level) {level++; cnt=0;}
				result = nowyx[2]; 
				if(!check()) {return;}
				q.clear();
			}
			for(int i = 0 ; i < 4; i++) {
				int ny = nowyx[0] + dy[i];
				int nx = nowyx[1] + dx[i];
				int count = nowyx[2];
				
				if(nx >=0 && nx < n && ny >=0 && ny < n && check[ny][nx] != now && input[ny][nx] <= level) {
					check[ny][nx] = now;
					q.offer(new int[] {ny,nx,count+1});
				}
			}
			
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		int sy = 0 ,sx = 0 ;
		input = new int[n][n];
		check = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < n ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				if(input[i][j] == 9) {
					sy = i;
					sx = j;
					input[i][j] = 0;
				}
			}
		}
		bfs(sy,sx);
		System.out.println(result);
	}
}
