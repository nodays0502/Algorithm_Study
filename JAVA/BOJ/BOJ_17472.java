package Lecture3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17472 {
	static int n , m ;
	static int input[][];
	static int area = 0;
	static int dy[] = {0,0,1,-1};
	static int dx[] = {1,-1,0,0};
	static int distance[] ;
	static int map[][];
	static boolean divideVisited[][] = new boolean[n][m];
	static void divide() {
		divideVisited = new boolean[n][m];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(!divideVisited[i][j] && input[i][j] == 1) {
					area++;
					dfs(i,j);
				}
			}
		}
	}
	static void dfs(int y , int x) {
		divideVisited[y][x] = true;
		input[y][x] = area;
		for(int i = 0 ; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(nx >= 0 && nx < m && ny >= 0 && ny < n && !divideVisited[ny][nx]&&input[ny][nx] == 1) {
				dfs(ny,nx);
			}
		}
	}
	static void makeMap() {
		for(int i = 1 ; i <= area ; i++) {
			for(int j = 1 ; j <= area ; j++) {
				map[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(input[i][j] != 0) {
					makeDistance(i,j);
				}
			}
		}
	}
	static void makeDistance(int y, int x) {
		int now = input[y][x];
		for(int i = 0 ; i < 4 ; i++) {
			int length = 1 ;
			int ny = y + dy[i];
			int nx = x + dx[i];
			while(nx >= 0 && nx < m && ny >=0 && ny < n) {
				if(input[ny][nx] != 0) {
					length--;
					if(length >= 2) {
						map[now][input[ny][nx]] = Math.min(map[now][input[ny][nx]], length);
					}
					break;
				}else {
					ny += dy[i];
					nx += dx[i];
					length++;
				}
			}
		}
	}
	static int prim() {
		int result = 0 ;
		boolean primvisited[] = new boolean[area+1];
		int primdistance[] = new int[area+1];
		for(int i = 1 ; i <= area ; i++) {
			primdistance[i] = Integer.MAX_VALUE;
		}
		primdistance[1] = 0 ;
		for(int t = 1; t <= area ; t++) {
			int min = Integer.MAX_VALUE; 
			int minIndex = 0 ;		
			for(int i = 1 ; i <= area ; i++) {
				if(!primvisited[i] && min > primdistance[i]) {
					min = primdistance[i];
					minIndex = i;
				}
			}
			if(min == Integer.MAX_VALUE) {result = -1; break;}
			primvisited[minIndex] = true;
			result += min;
			for(int i = 1 ; i <= area ; i++) {
				if(!primvisited[i] && map[minIndex][i] < primdistance[i]) {
					primdistance[i] = map[minIndex][i];
				}
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < m ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide();
		map = new int[area+1][area+1];
		makeMap();
		System.out.println(prim());
	}

}
