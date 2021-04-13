package Lecture0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_11559 {
	static int n = 12 , m = 6;
	static char map[][] = new char[n][m];
	static boolean visited[][];
	static int dy[] = {0,0,1,-1};
	static int dx[]= {1,-1,0,0};
	static void gravity() {
		for(int j = 0 ; j < m ; j++) {
			List<Character> list = new ArrayList<>();
			for(int i = n-1 ; i >=0 ; i--) {
				if(map[i][j] != '.') {
					list.add(map[i][j]);
					map[i][j] = '.';
				}
			}
//			System.out.println(list.size());
			for(int i = 0 ; i < list.size()  ; i++) {
				map[n-1-i][j] = list.get(i);
			}
			list.clear();
		}
	}
	static boolean pung() {
		visited = new boolean[n][m];
		boolean flag = false;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(!visited[i][j] && map[i][j] != '.') {
					flag = (flag | dfs(i,j));
				}
			}
		}
		return flag;
	}
	static boolean dfs(int y, int x) {
		visited[y][x] = true;
		Queue<int[]> q = new LinkedList<>();
		List<int[]> list = new ArrayList<>();
		q.offer(new int[] {y,x});
		list.add(new int[] {y,x});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0 ; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && map[ny][nx] == map[y][x]) {
					visited[ny][nx] = true;
					q.offer(new int[] {ny,nx});
					list.add(new int[] {ny,nx});
				}
			}
		}
/*		System.out.println(map[y][x]);
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i)[0]+" "+list.get(i)[1]);
		}*/
		if(list.size() < 4) return false;
		for(int i = 0 ; i < list.size(); i++) {
			int[] now = list.get(i);
			map[now[0]][now[1]] = '.';
		}
		return true;
	}
	static int doing() {
		boolean flag = true;
		int cnt = 0 ;
		while(true) {
			flag = pung();
			if(!flag) break;
			gravity();
			cnt++;
//			System.out.println(cnt);
//			print();
		}
		return cnt;
	}
	static void print() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < n ; i++) {
			String command = br.readLine();
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = command.charAt(j);
			}
		}
		System.out.println(doing());
	}

}
