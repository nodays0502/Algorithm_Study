package Lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 2시 40분
public class BOJ_14502 {
	static int n , m ;
	static int input[][];
	static int safeCnt = 0;
	static int dy[] = {0,0,1,-1};
	static int dx[] = {1,-1,0,0};
	static int result = 0;
	static List<int[]> virus = new ArrayList<>();

	static void comb(int depth, int start) {
//		System.out.println("comb");
		if(depth == 0) {
			int virus = bfs() + 3; // 0을 3개 1로 변했기 때문에 0의 개수를 이만큼 빼준다.
			result = Math.max(result, safeCnt - virus);
			return ;
		}
		int i = start / m;
		for(int j = start % m ; j < m ; j++) {
			if(input[i][j] == 0) {
				input[i][j] = 1;
				comb(depth-1 , i * m + j);
				input[i][j] = 0;
			}
		}
		for(i = (start / m) + 1 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(input[i][j] == 0) {
					input[i][j] = 1;
					comb(depth-1 , i * m + j);
					input[i][j] = 0;
				}
			}
		}
	}
	static int bfs() {
//		System.out.println("bfs");
		boolean visited[][] = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0 ; i < virus.size(); i++) {
			int y = virus.get(i)[0];
			int x = virus.get(i)[1];
			q.offer(new int[] {y,x});
		}
		int result = 0 ;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];
			for(int i = 0 ; i < 4 ; i++) {
				int ny = y + dy[i]; 
				int nx = x + dx[i];
				if(nx >= 0 && nx < m && ny >= 0 && ny < n && input[ny][nx] == 0 && !visited[ny][nx]) {
					result++;
					visited[ny][nx] = true;
					q.offer(new int[] {ny, nx});
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
		input = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < m ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				if(input[i][j] == 0 ) safeCnt++;
				else if(input[i][j]  == 2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		comb(3,0);
		System.out.println(result);
	}
}
