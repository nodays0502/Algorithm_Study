import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Node{
	int y;
	int x;
	int mode;
	int target;
	int cnt;
	public Node(int y, int x, int mode, int target, int cnt) {
		super();
		this.y = y;
		this.x = x;
		this.mode = mode;
		this.target = target;
		this.cnt = cnt;
	}
}
public class BOJ_16959 {
	static int n;
	static int input[][];
	static int y[];
	static int x[];
	static int dy[][] = {
			{2,1,-1,-2,-2,-1,1,2}, // 나이트
			{1,-1,-1,1}, // 비숍
			{0,0,1,-1} // 룩
	};
	static int dx[][] = {
			{1,2,2,1,-1,-2,-2,-1},
			{1,1,-1,-1},
			{1,-1,0,0}
	};
	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		boolean visited[][][][] = new boolean[n][n][3][n*n+3]; // y x mode target
		int result = 0;
		for(int i = 0 ; i < 3; i++) {
			visited[y[1]][x[1]][i][2] = true;
			q.offer(new Node(y[1],x[1],i,2,0)); // Node y x mode target cnt
		}
		while(!q.isEmpty()) {
			int size = q.size();
			for(int t = 0 ; t < size ; t++) {
				Node now = q.poll();
				int target = now.target;
				int mode = now.mode;
				int cnt = now.cnt;
				if(now.y == y[target] && now.x == x[target]) { 
					target++; 
			//		System.out.printf("y:%d x:%d mode:%d target:%d cnt:%d\n",now.y, now.x,mode,target,cnt);
					if(target == n*n+1) {
						result = cnt;
						return result;
					}
				}
			//	if(target == n * n+1) {result = cnt; break;}
				if(mode == 0) {
					for(int i = 0 ; i < 8 ; i++) {
						int ny = now.y + dy[mode][i];
						int nx = now.x + dx[mode][i];
						if(nx >= 0 && nx < n && ny >=0 && ny < n && !visited[ny][nx][mode][target]) {
							visited[ny][nx][mode][target] = true;
							q.offer(new Node(ny,nx,mode,target,cnt+1));
						}
					}
				}else {
					for(int i = 0 ; i < 4 ; i++) {
						int ny = now.y + dy[mode][i];
						int nx = now.x + dx[mode][i];
						while(nx >= 0 && nx < n && ny>= 0 && ny < n ) {
							if(!visited[ny][nx][mode][target]) {
								visited[ny][nx][mode][target] = true;
								q.offer(new Node(ny,nx,mode,target,cnt+1));
							}
							ny += dy[mode][i];
							nx += dx[mode][i];
						}
					}
				}
				for(int i = 0 ; i < 3; i++) {
					if(!visited[now.y][now.x][i][target]) {
						visited[now.y][now.x][i][target] = true;
						q.offer(new Node(now.y,now.x,i,target,cnt+1));
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
		y = new int[n*n+1];
		x = new int[n*n+1];
		input = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < n ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				y[input[i][j]] = i;
				x[input[i][j]] = j;
			}
		}
		System.out.println(bfs());
	}
}
