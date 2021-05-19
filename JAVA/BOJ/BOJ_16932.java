package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_16932 {
	static int n, m;
	static int map[][];
	static boolean visited[][];
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static int answer = 1;
	static int dfs(int y, int x , int num) {
		visited[y][x] = true;
		map[y][x] = num;
		int result = 1 ;
		for(int i = 0 ; i < 4 ; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(nx >=0 && nx < m && ny >=0 && ny < n && !visited[ny][nx] && map[ny][nx] == 1) {
				result += dfs(ny,nx,num);
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int number = 1;
		List<Integer> list = new ArrayList<>();
		list.add(0);
		int result = 0 ;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					int temp = dfs(i,j,number++);
					list.add(temp);
					result = Math.max(result, temp);
				}					
			}
		}
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
		//		System.out.print(map[i][j]+" " );
				if(map[i][j] == 0) {
					int sum = 1;
					Set<Integer> s = new HashSet<>();
					for(int k = 0 ; k < 4; k++) {
						int ny = i+ dy[k];
						int nx = j+ dx[k];
						if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
							s.add(map[ny][nx]);
						}
					}
					for(Iterator p = s.iterator(); p.hasNext();) {
						sum += list.get((int)p.next());
					}
					result = Math.max(result, sum);
				}
			}
		}
//		System.out.println(list);
		System.out.println(result);
	}

}
