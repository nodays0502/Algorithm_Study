package Past;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_15685 {
	static int n;
	static int input[][] = new int[101][101];
	static int y , x , d , g;
	static int dy[] = {0,-1,0,1}; // 0 : →  1 : ↑  2 : ←  3 : ↓
	static int dx[] = {1,0,-1,0};
//	static int a = 1;
	static void move(int cnt,Stack<Integer> s) { // cnt = 세대 , s 이전까지의 드래곤들의 방향
		if(cnt > g) return ;
		if(cnt == 0 ) {
			input[y][x] = 1;
			int ny = y + dy[d];
			int nx = x + dx[d];
			input[ny][nx] = 1;
			s.push(d);
			y = ny;
			x = nx;
			move(cnt+1,s);
		}else {
		//	int size = s.size();
			for(int i = s.size()-1; i >= 0  ; i--) {
				int dir = s.get(i);
				dir+=1; // dir += 2 // 역방향  dir += 1 90도 회전
				if(dir >=4) {dir -= 4;}
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				input[ny][nx] = 1;
				s.push(dir);
				y = ny;
				x = nx;
			}

//			System.out.println(s);
			move(cnt+1,s);
		}
	}
	static int cal() {
		int count = 0 ;
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				boolean find = true;
				for(int k = i ; k < i + 2; k++) {
					for(int l= j ; l < j + 2; l++) {
						if(input[k][l] != 1) find = false;
					}
				}
				if(find) count++;
			}
		}
		return count;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());

		for(int i = 0 ; i < n ; i++) {
		//	System.out.println(i);
			st= new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			move(0,new Stack<Integer>());
		}
	/*	for(int i = 0 ; i < 10 ;i++) {
			for(int j =0 ; j< 10 ; j++) {
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}*/
		System.out.println(cal());
	}
}
