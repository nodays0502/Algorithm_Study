package divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2447 {
	static int n;
	static char smallbox [][] = {
			{'*','*','*'},
			{'*',' ','*'},
			{'*','*','*'}
	};
	static char result[][];
	static void dnc(int length , int y,int x) {
		if(length == 3) {
			for(int i = 0 ; i < length ; i++) {
				for(int j = 0 ; j < length ; j++) {
					result[y+i][x+j] = smallbox[i][j];
				}
			}
		}else {
			int nowlength = length/3;
			for(int i = 0 ; i < 3 ; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					if(smallbox[i][j] == '*') {
						dnc(nowlength,y + nowlength*i,x + nowlength*j);
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		result = new char[n][n];
		dnc(n,0,0);
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(result[i][j] == '*') sb.append(result[i][j]);
				else sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
