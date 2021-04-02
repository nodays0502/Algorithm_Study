import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16973 {
	static int n , m ;
	static int input[][];
	static int start[] = new int[2];
	static int goal[] = new int[2];
	static int nS , mS;
	static int dy[] = {0,0,1,-1};
	static int dx[] = {1,-1,0,0};
	static int bfs() {
		boolean visited[][] = new boolean[n][m]; 
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start[0],start[1]});
		visited[start[0]][start[1]] = true;
		int cnt = 0 ;
		int result = -1 ;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int t = 0 ; t < size; t++) {
				int[] now = q.poll();
	//			System.out.println(now[0]+" "+now[1]);
				if(now[0] == goal[0] && now[1] == goal[1]) {result = cnt;break;}
				for(int i = 0 ; i < 4; i++) {
					int ny = now[0] + dy[i];
					int nx = now[1] + dx[i];
					if(nx >= 0 && nx + mS<= m && ny >= 0 && ny + nS <= n && !visited[ny][nx] && check(ny,nx)) {
						visited[ny][nx] = true;
						q.offer(new int[] {ny,nx});
					}
				}
			}
			cnt++;
		}
		return result;
	}
	static boolean check(int y, int x) { // 직사각형을 놓을수 있으면 true
		for(int i = 0; i < nS ; i++) {
			for(int j = 0 ; j < mS ; j++) {
				if(input[y+i][x+j] != 0) {
					return false;
				}
			}
		}
		return true;
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
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		nS = Integer.parseInt(st.nextToken());
		mS = Integer.parseInt(st.nextToken());
		start[0] = Integer.parseInt(st.nextToken())-1;
		start[1] = Integer.parseInt(st.nextToken())-1;
		goal[0] = Integer.parseInt(st.nextToken())-1;
		goal[1] = Integer.parseInt(st.nextToken())-1;
		System.out.println(bfs());
	}
}
