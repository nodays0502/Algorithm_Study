package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_3190 {
	static int map[][]; // 1 지렁이 3 사과
	static int n;
	static int dir;
	static int nowy; 
	static int nowx; 
	static int[] dx = {1,0,-1,0} ; //
	static int[] dy = {0,1,0,-1} ; //
	static int[] time;
	static int pos;
	static char[] changeDir;
	static int count ;
	static int command;
	static Deque<int[]> deque = new LinkedList<>();
	static boolean moving() {
		count++;
		int nx = nowx + dx[dir];
		int ny = nowy + dy[dir];
		if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
			deque.offerFirst(new int[] {ny,nx});
			if(map[ny][nx] == 1) return false;
			else if(map[ny][nx] != 3) {
				int y = deque.peekLast()[0];
				int x = deque.pollLast()[1];
				map[y][x] = 0;
			}
			map[ny][nx] = 1;
			nowy = ny;
			nowx = nx;
		}
		else return false;
		if(pos < command && time[pos] == count) {
			if( changeDir[pos] == 'D') {
				dir++;
				if(dir == 4) dir = 0 ;
			}else {
				dir--;
				if(dir == -1) dir = 3;
			}
			pos++;
		}
		return moving();
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		int apple = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < apple ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int y , x;
			y = Integer.parseInt(st.nextToken())-1;
			x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = 3; 
		}
		command = Integer.parseInt(br.readLine());
		time = new int [command];
		changeDir = new char[command];
		for(int i = 0 ; i < command ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			time[i] = Integer.parseInt(st.nextToken());
			changeDir[i] = st.nextToken().charAt(0);
		}
		deque.offerFirst(new int[] {0,0});
		moving();
		System.out.println(count);
	}
}
