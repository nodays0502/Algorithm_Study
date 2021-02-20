package Lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jung_1733 {
	static int win[] = new int[3];
	static final int SIZE = 19;
	static int[][] input = new int[SIZE][SIZE];
	static int dy[] = {1,1,0,-1}; // 0 밑 1 오른쪽 밑 2 오른쪽 3 오른쪽 위
	static int dx[] = {0,1,1,1};
	static boolean check(int cnt ,int y, int x, int color,int dir) {
		if(y >= 0 && y < SIZE && x >= 0 && x < SIZE);
		else return false;

		if(cnt == 5) { // 해당하는 한칸만 비교
			if(input[y][x] == color) {return true;}
			else return false;
		}
		boolean result = false;
		if(input[y][x] == color) {
			if(cnt == 4) {result = !check(cnt+1,y+dy[dir],x+dx[dir],color,dir);} // 5개를 체크했다면 다음것을 확인 다음것이 인덱스를 나가거나 다르거면 true;
			else if(cnt == 0 && check(5,y-dy[dir],x-dx[dir],color,dir))  {return false;} // 이전의 값을 비교해서 다르면 진행
			else{result = check(cnt+1,y+dy[dir],x+dx[dir],color,dir);}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0 ;  i < SIZE ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < SIZE ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		int result[][] = new int[][] {{-1,-1},{-1,-1},{-1,-1}}; // 1 2 이길때의 자표값
		for(int i = 0 ;  i < SIZE ; i++) {
			for(int j = 0 ; j < SIZE ; j++) {
				for(int k= 0 ; k < 4 ; k++) {
					if(input[i][j] != 0 && check(0,i,j,input[i][j],k)) {
						if(result[input[i][j]][0] == -1) {result[input[i][j]][0] = i; result[input[i][j]][1] = j;}
						win[input[i][j]]++;
					} 
				}
			}
		}
		if(win[1] > win[2]) {System.out.println(1); System.out.println((result[1][0]+1) +" "+(result[1][1]+1) );}
		else if(win[1] < win[2]) {System.out.println(2); System.out.println((result[2][0]+1) +" "+(result[2][1]+1) );}
		else {
			System.out.println(0);
		}
	}

}
