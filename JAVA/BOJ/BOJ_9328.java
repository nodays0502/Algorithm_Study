package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9328 {
	static int n , m;
	static char map[][];
	static boolean visited[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static boolean key[] ;// 키는 소문자, 대문자는 문\
	static int bfs() {
		int result = 0;
		Queue<int[]> q = new LinkedList<>();
//		System.out.println(Arrays.toString(key));
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= m ; j++) {
				if(map[i][j] >= 'A' && map[i][j] <= 'Z') {
					if(key[map[i][j]-'A']) {
						map[i][j] = '.';
					}
				}
			}
		}
		q.offer(new int[] {0,0});
		visited[0][0]= true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if((map[now[0]][now[1]] >= 'a' && map[now[0]][now[1]]<='z')) {
				int nowkey = map[now[0]][now[1]] - 'a';
	//			System.out.println((char)(nowkey+'a'));
				key[nowkey] = true;
	//			System.out.println((char)(nowkey+'A'));
				for(int i = 1 ; i <= n ; i++) {
					for(int j = 1 ; j <= m ; j++) {
						if(map[i][j] == (nowkey+'A')) {
							if(visited[i][j])
								q.offer(new int[] {i,j});
//							System.out.println(i+" "+j);
						//	visited[i][j] = true;
							map[i][j] = '.';
						}
					}
				}
			}else if(map[now[0]][now[1]] == '$') {
				map[now[0]][now[1]] = '.';
				result++;
			}else if(map[now[0]][now[1]] >='A' && map[now[0]][now[1]]<='Z')
				continue;
				
			for(int i = 0 ; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if(nx>=0 && nx <= m+1 && ny>=0 && ny <= n+1 && !visited[ny][nx] && (map[ny][nx] == '.' 
						|| (map[ny][nx] >= 'a' && map[ny][nx] <= 'z') || map[ny][nx] == '$' || map[ny][nx] == '\u0000'
						|| (map[ny][nx] >= 'A' && map[ny][nx] <= 'Z') )) {
					visited[ny][nx] = true;
					q.offer(new int[] {ny,nx});
				}
			}
		}
		return result;
	}
	static void print() {
		for(int i = 0 ; i < n+2 ; i++) {
			for(int j = 0 ; j < m+2 ; j++) {
				if(visited[i][j])
				System.out.print(1+" ");
				else
					System.out.print(0+" ");
					
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0 ; t < T;  t++) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			key = new boolean[26]; 
			map = new char[n+2][m+2];
			visited = new boolean[n+2][m+2];
			for(int i = 0 ; i < n ; i++) {
				String command = br.readLine();
				for(int j = 0 ; j < m ; j++) {
					map[i+1][j+1] = command.charAt(j);
				}
			}
			String command = br.readLine();
			if(command.equals("0")) ;
			else {
				for(int i = 0 ; i < command.length();i++) {
					key[command.charAt(i)-'a'] = true;
				}
			}
			System.out.println(bfs());			
			print();
		}
	}
}
