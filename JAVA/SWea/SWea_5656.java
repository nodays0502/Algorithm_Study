package Study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWea_5656 {
	static int N , W , H;
	static int input[][];
	static int result = Integer.MAX_VALUE; 
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static void count(int[][] arr) {
		int cnt = 0 ;
		for(int i = 0 ; i < H ; i++) {
			for(int j = 0 ; j < W ; j++) {
				if(arr[i][j] > 0) cnt++;
			}
		}
		result = Math.min(result, cnt);
	}
	
	static void swap(int[][]arr, int y,int x , int ny , int nx) {
		int temp = arr[y][x];
		arr[y][x] = arr[ny][nx];
		arr[ny][nx] = temp;
	}
	
	static void down(int[][] arr) {
		for(int i = 0 ; i < W ; i++) {
			int bottomIndex = H-1;
			for(int j = H-1 ; j >= 0 ; j--) {
				if(arr[j][i] != 0) {
					swap(arr,j,i,bottomIndex,i);
					bottomIndex--;
				}
			}
		}
	}
	
	static void copy(int[][] arr1 , int[][] arr2) { // depp copy arr1 = arr2;
		for(int i = 0 ; i < H; i++) {
			for(int j = 0 ; j < W; j++) {
				arr1[i][j] = arr2[i][j];
			}
		}
	}
	
	static void perm(int depth, int [][] arr) {
	//	print(arr);
		if(depth == N) {
			count(arr);
		}else {
			boolean find = false;
			for(int i = 0 ; i < W ; i++) {
				int[][] temp = new int[H][W];
				copy(temp , arr);
				for(int j = 0 ; j < H ; j++) {
					if(arr[j][i] != 0 ) {
						find = true;
				//		System.out.println("전");
				//		print(temp);
						crush(temp,j,i);
				//		System.out.println("후");
				//		print(temp);
						down(temp);
						perm(depth+1,temp);
						break;
					}
				}
			}
			if(!find) result = 0 ;
		}
	}
	
	static void crush(int[][] arr , int y , int x) {
		int length = arr[y][x] - 1;
		arr[y][x] = 0;
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 1 ; j <= length ; j++) {
				int ny = y + j * dy[i];
				int nx = x + j * dx[i];
				if(nx >= 0 && nx < W && ny >= 0 && ny < H) {
					if(arr[ny][nx] == 1)
						arr[ny][nx] = 0;
					if(arr[ny][nx] != 0 && arr[ny][nx] != 1) { 
						crush(arr,ny,nx);
					}
				}
			}
		}
	}
	static void print(int[][] arr) {
		for(int i = 0 ; i < H ; i++) {
			for(int j = 0 ; j < W ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SWea_5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			result = Integer.MAX_VALUE;
			input = new int [H][W];
			for(int i = 0 ; i < H ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < W ; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			perm(0,input);
			System.out.println("#"+t+" "+result);
		}
	}
}
