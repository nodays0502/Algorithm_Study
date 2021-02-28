package SsafyPrac;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_16113 {
	static int n;
	static char input[][];
	static char num[][][] = {
			{					//0
				{'#','#','#'}, 
				{'#','.','#'},
				{'#','.','#'},
				{'#','.','#'},
				{'#','#','#'}
			}, 
			{				// 1
				{'#'},
				{'#'},
				{'#'},
				{'#'},
				{'#'}
			},
			{					//2
				{'#','#','#'}, 
				{'.','.','#'},
				{'#','#','#'},
				{'#','.','.'},
				{'#','#','#'}
			},
			{					//3
				{'#','#','#'}, 
				{'.','.','#'},
				{'#','#','#'},
				{'.','.','#'},
				{'#','#','#'}
			},
			{					//4
				{'#','.','#'}, 
				{'#','.','#'},
				{'#','#','#'},
				{'.','.','#'},
				{'.','.','#'}
			},
			{					//5
				{'#','#','#'}, 
				{'#','.','.'},
				{'#','#','#'},
				{'.','.','#'},
				{'#','#','#'}
			},
			{					//6
				{'#','#','#'}, 
				{'#','.','.'},
				{'#','#','#'},
				{'#','.','#'},
				{'#','#','#'}
			},
			{					//7
				{'#','#','#'}, 
				{'.','.','#'},
				{'.','.','#'},
				{'.','.','#'},
				{'.','.','#'}
			},
			{					//8
				{'#','#','#'}, 
				{'#','.','#'},
				{'#','#','#'},
				{'#','.','#'},
				{'#','#','#'}
			},
			{					//9
				{'#','#','#'}, 
				{'#','.','#'},
				{'#','#','#'},
				{'.','.','#'},
				{'.','.','#'}
			}
	};
	static String cal() {
		StringBuilder sb = new StringBuilder();
		for(int col = 0 ; col < n/5 ;) {
			if(input[0][col] == '#') {
				int temp = find(col);
				if(temp == 1) { sb.append(temp); col++;}
				else {sb.append(temp); col+=3;}
			}
			else {
				col++;
			}
		}
		return sb.toString();
	}
	static void print(int col) {
		for(int i = 0 ; i < 5; i++) {
			for(int j = col ; j < col + 3 ; j++)
				{System.out.print(input[i][j]+" ");}
			System.out.println();
		}
	}
	static int find(int col) {
	//	System.out.println(col);
	//	print(col);
		if(col+2 < n/5 && input[0][col+1] == '.') {
	//		System.out.println("1");
			boolean correct = true;
			for(int i = 0 ; i < 5; i++) {
				for(int j = 0 ; j < 1; j++) {
					if(input[i][col+j] != num[1][i][j]) {
						correct = false;
					}
				}
			}
			if(correct) {return 1;}
			correct = true;
			for(int i = 0 ; i < 5; i++) {
				for(int j = 0 ; j < 3; j++) {
					if(input[i][col+j] != num[4][i][j]) {
						correct = false;
					}
				}
			}
			if(correct) {return 4;}
		}else if(col == n/5 -1 || col == n/5 - 2) {
			return 1;
		}else {
			for(int k = 0 ; k < 10 ; k++) {
				boolean correct = true;
				if(k == 1) continue;
				for(int i = 0 ; i < 5; i++) {
					for(int j = 0 ; j < 3; j++) {
						if(input[i][col+j] != num[k][i][j]) {
							correct = false;
						}
					}
				}	
				if(correct) {return k;}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		input = new char[5][n/5];
		String command = br.readLine();
		for(int i = 0 ; i < 5; i++) {
			for(int j = 0 ; j < n/5 ; j++) {
				input[i][j] = command.charAt((n/5)*i + j);
			}
		}
		System.out.println(cal());
	}
}
