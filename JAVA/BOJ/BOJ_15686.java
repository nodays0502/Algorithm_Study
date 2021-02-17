package Lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
public class BOJ_15686 {

	static int N , M;
	static int input[][];
	static List<int[]> one = new LinkedList<>();
	static List<int[]> two = new LinkedList<>();
	static int[] dis;
	static boolean isSelected[];
	static int result = Integer.MAX_VALUE;
	static void comb(int cnt , int start) { // 치킨집 M개 선택
		if(cnt == M) {
	//		System.out.println(Arrays.toString(isSelected));
			cal();
		}else {
			for(int i = start ; i < two.size() ; i++) {
				isSelected[i] = true;
				comb(cnt+1 , i+1);
				isSelected[i] = false;
			}
		}
	}
	static void cal() { // 모든 1과 선택한 2와 거리 계산
		int sum = 0 ;
		for(int i = 0 ; i < one.size(); i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0 ; j < two.size(); j++) {
				if(isSelected[j])
					min = Math.min(min, Math.abs(two.get(j)[0] -one.get(i)[0]) + Math.abs(two.get(j)[1] -one.get(i)[1]));
			}
			sum += min;
		}
		result = Math.min(result, sum);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < N ; j++) {
				input[i][j] =  Integer.parseInt(st.nextToken());
				if(input[i][j] == 1) one.add(new int[] {i,j}); // 집(1)인 값을 저장
				if(input[i][j] == 2) two.add(new int[] {i,j}); // 치킨집(2) 인 값 저장
			}
		}
		isSelected = new boolean[two.size()]; // combination을 위한 boolean값
		comb(0,0);
		System.out.println(result);
	}

}
