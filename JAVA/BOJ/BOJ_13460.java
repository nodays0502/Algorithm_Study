package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460 {
	static int n , m;
	static char map[][];
	static int red[] = new int[2];
	static int blue[]= new int[2];
	static int target[] = new int[2];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int distinction[] = {-1,1,1,-1};
	static int[] move(int[]a , int b[],int dir) {
		int ny = a[0];
		int nx = a[1];
		while(ny >= 0 && ny < n && nx >= 0 && nx < m && (map[ny][nx] == '.' || map[ny][nx] == 'O' || (ny == b[0] && nx == b[1]))) {
			if(map[ny][nx] == 'O') return new int[] {ny,nx};
			else if(ny == b[0] && nx == b[1]) break;
			ny += dy[dir];
			nx += dx[dir];
		}
		ny -= dy[dir];
		nx -= dx[dir];
		return new int[] {ny,nx};
	}
	static int bfs() {
		boolean visited[][][][] = new boolean[n][m][n][m]; // red y x blue y x 
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {red[0],red[1],blue[0],blue[1]});
		visited[red[0]][red[1]][blue[0]][blue[1]] = true;
		int result = -1;
		int cnt = 0 ;
		while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			if(cnt > 10) break;
			for(int t = 0 ; t < size ; t++) {
				int[] now = q.poll();
				int[] r = new int[] {now[0],now[1]};
				int[] b = new int[] {now[2],now[3]};
				for(int i = 0 ; i < 4; i++) {
					int[] nr;
					int[] nb;
					if(distinction[i]*r[i%2] > distinction[i]*b[i%2]) {
						nr = move(r,b,i);
						nb = move(b,nr,i);
					}else {
						nb = move(b,r,i);
						nr = move(r,nb,i);
					}
					if(nr[0] == target[0] && nr[1] == target[1] && (nb[0] != target[0] || nb[1] != target[1])) {
						result = cnt;
						return result;
						}
					else if(nb[0] == target[0] && nb[1] == target[1]) ;
					else {
						if(!visited[nr[0]][nr[1]][nb[0]][nb[1]]) {
							visited[nr[0]][nr[1]][nb[0]][nb[1]] = true;
							q.offer(new int[] {nr[0],nr[1],nb[0],nb[1]});
						}
					}
				}				
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for(int i = 0 ; i < n ; i++) {
			String command = br.readLine();
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = command.charAt(j);
				if(map[i][j] == 'R') {
					red[0] = i;
					red[1] = j;
					map[i][j] = '.';
				}else if(map[i][j] == 'B') {
					blue[0] = i;
					blue[1] = j;
					map[i][j] = '.';
				}else if(map[i][j] == 'O') {
					target[0] = i;
					target[1] = j;
				}
			}
		}
		System.out.println(bfs());
	}
}
