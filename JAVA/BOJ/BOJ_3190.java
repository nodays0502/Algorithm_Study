package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_3190 {	
	static int map[][];
	static int n, m;
	static ArrayList<int[]> input;
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int nowy = 0  , nowx = 0;
	static int nowdir = 1;
	static int time = 0;
	static int index = 0 ;
	static void move() {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] {0,0});
		map[0][0] = 1;
		while(true) {
//			print();
			int[] now = deque.peek();
//			System.out.println(now[0]+" "+now[1]);
			if(index < input.size() && input.get(index)[0] == time) {
				nowdir += input.get(index)[1];
				nowdir = (nowdir +4) % 4;
//				System.out.println(nowdir +" "+input.get(index)[1]);
				index++;
			}
			int ny = now[0] + dy[nowdir];
			int nx = now[1] + dx[nowdir];
			if(ny >= 0 && ny < n && nx >= 0 && nx < n && (map[ny][nx] == 0 || map[ny][nx] == 4)) {
				if(map[ny][nx] == 4) {
					;
				}else {
					int[] back = deque.pollLast();
					map[back[0]][back[1]] = 0;
				}
				deque.addFirst(new int[] {ny,nx});
				map[ny][nx] = 1;
			}else {
				break;
			}			
			time++;
		}
		time++;
	}
	static void print() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = 4; // 사과
		}
		st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		input = new ArrayList<int[]>();
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int length = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			if(dir == 'L')
				input.add(new int[] {length,-1});
			else 
				input.add(new int[] {length,1});
		}	
		move();
		System.out.println(time);
	}
}	
