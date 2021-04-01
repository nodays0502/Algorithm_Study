import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {
	static int start,goal;
/*	static int bfs() {
		int[] dp = new int[goal+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		dp[start] = 1;
		int result = -1;
		while(!q.isEmpty()) {
			int now = q.poll();
			int cnt = dp[now];
			if(now == goal) {result = cnt ; break;}
			int next = 2*now;
			if(next <= goal && dp[next] ==0) {
				dp[next] = cnt+1;
				q.offer(next);
			}
			next = 10*now + 1;
			if(next <= goal && dp[next] ==0) {
				dp[next] = cnt+1;
				q.offer(next);
			}
		}
		return result;
	}*/
	static long bfs() {
		Queue<long[]> q = new LinkedList<>();
		q.offer(new long[] {start,1});
		long result = -1;
		while(!q.isEmpty()) {
			long[] now = q.poll();
			long cnt = now[1];
			if(now[0] == goal) {result = cnt ; break;}
			long next = 2 * now[0];
			if( next >= 0 && next <= goal ) {
				q.offer(new long[] {next,cnt+1});
			}
			next = 10 * now[0] + 1;
			if(next >= 0 && next <= goal ) {
				q.offer(new long[] {next,cnt+1});
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		start = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs());
	}
}
