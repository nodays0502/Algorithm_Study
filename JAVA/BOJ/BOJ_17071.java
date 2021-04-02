import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17071 {
	static int N;
	static int K;
	static boolean num[][] = new boolean[500001][2];
	static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		int cnt = 0;
		int result = -1;
		num[N][0] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			if(num[K][cnt % 2]) {result = cnt; return result;}
			int time = (cnt+1) % 2;
			for(int t = 0 ; t < size ; t++) {
				int now = q.poll();
				for(int i = -1 ; i <= 1; i++) {
					int nx = now;
					if(i == 0) {
						nx *= 2;
					}else {
						nx += i;
					}
					if(nx >= 0 && nx <= 500000 && !num[nx][time]) {
						num[nx][time] = true;
						q.offer(nx);
					}
				}
			}	
//			System.out.println(q);
			cnt++;
			K += cnt;
			if(K > 500000) break;
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		System.out.println(bfs());
	}
}
