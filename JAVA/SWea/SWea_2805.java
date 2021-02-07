import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWea_2805 {
	static int[][] map;
	static int num = 1;
	static int n ;
	static int[] dx = {1,0,-1,0}; // 순서를 오른쪽 아래 왼쪽 위
	static int[] dy = {0,1,0,-1}; // 
	static void cal(int y, int x) {
		map[y][x] = num++;
		for(int i =0;i<4;i++){
			int ny = y + dy[i];// 0 0
			int nx = x + dx[i];// 0 1
			if(ny >= 0 && ny < n && nx >=0 && nx < n && map[ny][nx] == 0){
				cal(ny,nx);
				break;
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int k = 1; k <= t; k++) {
			num = 1;
			n = Integer.parseInt(br.readLine()); // 배열의 크기 
			map = new int[n][n];
			
			cal(0,0);
			System.out.println("#"+k);
			for(int[] i : map) {
				for(int j : i) {
					System.out.print(j+" ");
				}
				System.out.println();
			}
		}
	}
}
