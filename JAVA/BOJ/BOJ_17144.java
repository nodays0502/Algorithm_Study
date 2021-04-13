package Lecture0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144 {
	static int n , m , t;
	static int map[][];
	static int cleanery[] = new int[2];
	static int dy[] = {0,-1, 0 ,1};
	static int dx[] = {1,0,-1,0};
	static void spread() {
		int temp[][] = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j] >= 5) {
					int value = map[i][j]/5;
					for(int k = 0 ; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if(ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] != -1) {
							temp[ny][nx] += value;
							map[i][j] -= value;
						}
					}
				}
			}
		}
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				map[i][j] += temp[i][j];
			}
		}
	}
	static void clean(int a) {
		int ny = cleanery[a];
		int nx = 0 ;
		int value = 0;
		for(int i = 0 ; i < 4; i++) {
			if(a == 1 && i % 2 == 1 ){
				ny -= dy[i];
				nx -= dx[i];														
			}else {
				ny += dy[i];
				nx += dx[i];	
			}	
			while(nx >= 0 && nx < m && ny >=0 && ny < n && map[ny][nx] != -1) {
	//			System.out.println(ny+" "+nx);
				int temp = value;
				value = map[ny][nx];
				map[ny][nx] = temp;
				if(a == 1 && i % 2 == 1 ){
					ny -= dy[i];
					nx -= dx[i];														
				}else {
					ny += dy[i];
					nx += dx[i];	
				}				
				
			}
			if(a == 1 && i % 2 == 1 ){
				ny += dy[i];
				nx += dx[i];														
			}else {
				ny -= dy[i];
				nx -= dx[i];	
			}
		}
	}
	static void doing() {
		spread();
	//	print();
		clean(0);
		clean(1);
	//	print();

	}
	static void print() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					if(cleanery[0] == 0)
						cleanery[0] = i;
					else
						cleanery[1] = i;
				}
			}
		}
		for(int i = 0 ; i < t; i++) {
			doing();
		}
		int result = 0 ;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				result += map[i][j];
			}
		}
		System.out.println(result+2);
	}

}
