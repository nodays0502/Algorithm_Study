package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1269 {
	static int a,b;
	static int A[],B[];
	static int cal() {
		int result = 0;
		Arrays.sort(A);
		Arrays.sort(B);
	/*	for(int i = 0 ; i < a; i++) {
			int index = Arrays.binarySearch(B, A[i]);
			if(index >= 0) result++;
		}*/
		for(int i = 0 ; i < a ; i++) {
			int start = 0;
			int end = a;
			while(start <= end) {
				int mid = (start + end)/2;
				if(B[mid] == A[i]) {
					result++;
					break;
				}else if(B[mid] < A[i]) {
					start = mid+1;
				}else {
					end = mid-1;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		A = new int[a];
		B = new int[b];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < a; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < b ; i++){
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = a + b;
		System.out.println(result - 2*cal());
	}
}
