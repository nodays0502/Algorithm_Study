package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_8980 {
	static int N , C , M;  // N 마을 개수 , C 용량 , M 박스 정보 개수
	static int[][] input;
	static int[] box; // 어디서 얼마나 내릴지 저장
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		input = new int[M][3]; // 0시작 1끝 2개수
		box = new int[N+1]; // i~j -> i에 저장
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			 for(int j = 0 ; j < 3; j++)
			input[i][j] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int diff = o1[1] - o2[1];
	//			return diff != 0? diff:  (o1[0]-o1[1]) - (o2[0]-o2[1]);
				return diff;
			};
		});
		int result = 0 ;
//		System.out.println(Arrays.deepToString(input));
		for(int i = 0 ; i < M ;i++) {
			int start = input[i][0];
			int end = input[i][1];
			int count = input[i][2];
			int max = 0 ;
			for(int j = start ; j<end;j++) {
				max = Math.max(max,box[j]);
			}
			// result += C-max;
			int temp = 0 ;
			if(count + max <= C) temp = count;
			else if(count + max > C) temp = C - max;
			result += temp;
			for(int j = start ; j<end;j++) {
				box[j] += temp;
			}
		}
//		System.out.println(Arrays.toString(box));
		System.out.println(result);
	}
}
