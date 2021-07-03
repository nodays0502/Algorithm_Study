import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5567 {
	static int n,m;
	static List<Integer> map[];
	static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		boolean visited[] = new boolean[n+1];
		int result = 0;
		visited[1] = true;
		int cnt = 0 ;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int t = 0 ; t < size ; t++) {
				int now = q.poll();
				for(int i = 0 ; i < map[now].size(); i++) {
					int next =  map[now].get(i);
					if(!visited[next]) {
						result++;
						visited[next] = true;
						
						q.offer(next);
					}
				}
			}
			cnt++;
			if(cnt >= 2) break;
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		map = new ArrayList[n+1];
		for(int i = 0 ; i <= n ; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}
		System.out.println(bfs());
	}
}
