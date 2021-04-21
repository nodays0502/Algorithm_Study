package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
public class BOJ_2412 {
	static int n;
	static int T;
	static List<Integer> map[];
	static Set<Integer> set[];
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		int result = -1;
		q.add(new int[] {0,0});
		set[0].add(0);
		int cnt = 0 ;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int t = 0 ; t < size; t++) {
				int[] now = q.poll();
				if(now[0] == T) {result = cnt; return result;}
				for(int i = Math.max(now[0] - 2, 0)  ; i <= now[0] + 2 ; i++) {
					for(int j = 0 ; j < map[i].size() ; j++) {
						int x = map[i].get(j);
						if(Math.abs(x-now[1]) <= 2 && set[i].add(x)) {
							q.add(new int[] {i,map[i].get(j)});
						}
					}
				}
			}
			cnt++;
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new ArrayList[n+1];
		set = new HashSet[n+1];
		for(int i = 0 ; i <= n ; i++) {
			map[i] = new ArrayList<Integer>();
			set[i] = new HashSet<Integer>();
		}
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(b > T) continue;
			map[b].add(a);
		}
		System.out.println(bfs());
	}

}
