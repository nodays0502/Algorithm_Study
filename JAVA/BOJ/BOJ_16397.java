package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_16397 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {N,0}); // 값 , depth
		int result = -1 ;
		Set<Integer> s = new HashSet<>();
		s.add(N);
		while(!q.isEmpty()) { // bfs
			int[] now = q.poll();
		//	System.out.println(now[0]);
			if(now[0] == G) {result = now[1]; break;} // G와 같다면 while문 빠져나온다.
			if(now[0] < 0 || now[1] >= T) continue; // 음수가 되면 양수가 될수 없고 실행 횟수가 T보다 같거나 크다면 조건문으로 간다.
			if(now[0]+1 <= 99999 && s.add(now[0] + 1)) { // N+1 // 99999보다 작아야하고 , 처음 들어가는 거여야한다.
				q.offer(new int[]{now[0] + 1 , now[1] + 1}); 
			}
			int temp = 2 * now[0]; // 2 * N
			if(temp <= 99999) { // 2* N - 최고 항?
				int num = 1; // 1의자리일떄 1빼준다. 
				while((temp / (10 * num)) >= 1) { // 가장 높은 자릿수를 찾는다.
					num *= 10;
				}
				temp -= num; // 빼준다.
				if(s.add(temp)) { // temp값이 처음 들어간다면 q에 집어 넣는다.
					q.offer(new int[]{temp , now[1] + 1});
				}
			}
		}
		if(result == -1) System.out.println("ANG");
		else System.out.println(result);
	}
}
