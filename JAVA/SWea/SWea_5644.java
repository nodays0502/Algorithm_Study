package live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWea_5644 {
	static int dy[] = {0,-1,0,1,0};
	static int dx[] = {0,0,1,0,-1};
	static ArrayList<Integer> map[][];
	static int M,A; // 시간 , 개수
	static int move[][] = new int[2][100];
	static int battery[];
	static int cal() {
		int result = 0 ;
		int ay = 0,ax = 0;
		int by = 9,bx = 9;
		for (int i = 0; i <= M; i++) {
			PriorityQueue<Integer> A = new PriorityQueue<>((o1, o2) -> {
				return battery[o2] - battery[o1];
			});
			PriorityQueue<Integer> B = new PriorityQueue<>((o1, o2) -> {
				return battery[o2] - battery[o1];
			});
			for (int j = 0; j < map[by][bx].size(); j++) {
				B.add(map[by][bx].get(j));
			}
			for (int j = 0; j < map[ay][ax].size(); j++) {
				A.add(map[ay][ax].get(j));
			}
			if(!A.isEmpty() && !B.isEmpty()) {
				int a = A.poll();
				int b = B.poll();
				if(a == b) {
					result += battery[a];
					if(!A.isEmpty() && !B.isEmpty()) {
						a = A.poll();
						b = B.poll();
						result+= Math.max(battery[a], battery[b]);
					}
					else if(A.isEmpty() && !B.isEmpty()) {
						b = B.poll();
						result+=battery[b];
					}
					else if(!A.isEmpty() && B.isEmpty()) {
						a = A.poll();
						result+= battery[a];
					}
					else  {
						;
					}
				}else {
					result += (battery[a]+battery[b]);					
				}
			}
			else if(A.isEmpty() && !B.isEmpty()) {
				int b = B.poll();
				result+=battery[b];
			}else if(!A.isEmpty() && B.isEmpty()) {
				int a = A.poll();
				result+=battery[a];
			}
			if(i == M )break;
			ay += dy[move[0][i]];
			ax += dx[move[0][i]];
			by += dy[move[1][i]];
			bx += dx[move[1][i]];
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			map = new ArrayList[10][10];
			for(int i = 0 ; i < 10 ; i++) {
				for(int j = 0 ; j < 10 ; j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			int result = 0 ;
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			for(int i = 0 ; i < 2; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < M ; j++) {
					move[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			battery = new int[A+1];
			for(int i = 0 ; i < A; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				battery[i+1] = p;
				makeMap(y,x,c,i+1);
			}
			result = cal();
			System.out.printf("#%d %d\n",t, result);
		}
	}
	private static void makeMap(int y, int x, int c,int now) {
		for(int i = 0 ; i <= c ; i++) {
			for(int j = -c+i ; j <= c-i ; j++) {
				if(y+i >=0 && y+i < 10 && x+j >=0 && x+j < 10) {
					map[y+i][x+j].add(now);
				}
			}
			if(i == 0 )continue;
			for(int j = -c+i ; j <= c-i ; j++) {
				if(y-i >=0 && y-i < 10 && x+j >=0 && x+j < 10) {
					map[y-i][x+j].add(now);
				}
			}
		}
	}
}
