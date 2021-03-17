package Study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWea_5644 {
	static int dy[] = {0,-1,0,1,0}; // 상 우 하 좌
	static int dx[] = {0,0,1,0,-1};
	static int M, A ; // M  이동시간 , A BC의 개수
	static int move[][];
	static int BC[][];
	static int map[][] = new int[10][10];
	static int a[] = {0,0};
	static int b[] = {9,9};
	static int result = 0 ;
	static void moving(int depth) {
//		System.out.println("depth"+depth+" "+result);
		int ay = a[0]; 
		int ax = a[1];
		int by = b[0];
		int bx = b[1];
		List<Integer> aL = new ArrayList<>();
		List<Integer> bL = new ArrayList<>();
		int temp = map[ay][ax];
		while(temp > 0) {
			aL.add(temp%10);
			temp /= 10;
		}
		
		temp =  map[by][bx];
		while(temp > 0) {
			bL.add(temp%10);
			temp /= 10;
		}
	
		int Aarea = 0;
		int Afirst = 0;
		int Asecond = 0 ;
		for(int i = 0 ; i < aL.size(); i++) {
			if(Afirst < BC[aL.get(i)][3]) {
				Aarea = aL.get(i);
				Asecond = Afirst;
				Afirst = BC[aL.get(i)][3];
			}else if(Asecond < BC[aL.get(i)][3]) {
				Asecond = BC[aL.get(i)][3];
			}
		}
		result += Afirst;
		int Bfirst = 0;
		int Bsecond = 0;
		int Barea = 0;
		
		for(int i = 0 ; i < bL.size(); i++) {
			if(Bfirst < BC[bL.get(i)][3]) {
				Barea = bL.get(i);
				Bsecond = Bfirst;
				Bfirst = BC[bL.get(i)][3];
			}else if(Asecond < BC[bL.get(i)][3]) {
				Bsecond = BC[bL.get(i)][3];
			}
		}
		if(Barea == Aarea) {
			result += Math.max(Asecond, Bsecond);
		}else {
			result+=Bfirst;			
		}
		if(depth == M) {
			return ;
		}else {
			a[0] = ay + dy[move[0][depth]];
			a[1] = ax + dx[move[0][depth]];
			b[0] = by + dy[move[1][depth]];
			b[1] = bx + dx[move[1][depth]];
			moving(depth+1);
		}
	}
	static void makeMap() {
		for(int a = 1 ; a <= A ; a++) {
			int x = BC[a][0]-1;
			int y = BC[a][1]-1;
			int c = BC[a][2];
			int p = BC[a][3];
		//	map[y][x] = p;
			for(int i = 0 ; i <= c ; i++) {
				for(int j = -i ; j <= i ; j++) {
		//			System.out.println("1 "+i+" "+j);
					if(!(y - c + i >= 0 && y - c + i < 10 && x+j>=0 && x+j<10))continue;
					if(map[y - c + i][x + j] == 0 ) {
						map[y - c + i][x + j] = a;
					}else {
						map[y - c + i][x + j] = map[y - c + i][x + j]*10 + a;
					}
				}
			}		
			for(int i = 0 ; i < c ; i++) {
				for(int j = -i ; j <= i ; j++) {
		//			System.out.println("2 "+i+" "+j);
					if(!(y + c - i >= 0 && y + c - i < 10 && x+j>=0 && x+j<10))continue;
					if(map[y + c - i][x + j] == 0 ) {
						map[y + c - i][x + j] = a;
					}else {
						map[y + c - i][x + j] = map[y + c - i][x + j]*10 + a;
					}
				}
			}		
	//		print();
		}
	}
	static void print() {
		for(int i = 0 ; i < 10 ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				System.out.printf("%6d ",map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SWea_5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1 ; t <= T ; t++) {
			result = 0 ;
			a = new int[] {0,0};
			b = new int[] {9,9};
			map = new int[10][10];
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			move = new int[2][M];
			for(int i = 0 ; i < 2 ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < M ; j++) {
					move[i][j] = Integer.parseInt(st.nextToken());
				}				
			}
			BC = new int[A+1][4];
			for(int i = 1 ; i <= A ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < 4 ; j++) {
					BC[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			makeMap();
		//	print();
			moving(0);
			System.out.println("#"+t+" "+result);
		}
	}
}
