package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2212 {
	static int N ,K; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		K = Integer.parseInt(st.nextToken());  // ------------------------------------------------------------
		Set<Integer> s = new HashSet<>(); // set으로 중복 제거
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++) {
			s.add(Integer.parseInt(st.nextToken()));
		}
		List<Integer> list = new ArrayList<>(s); // Linked List로 정렬할때 시간 복잡도 편하게
		Collections.sort(list); 

		int[] dir = new int[list.size()-1]; // 근처 센서와의 거리 저장
		for(int i = 0,size = list.size() ; i < size-1 ; i++) {
			dir[i] = list.get(i+1) - list.get(i);
		}

		Arrays.sort(dir); // 정렬

		int sum = 0 ;
		for(int i = 0 ; i < dir.length - K + 1 ; i++) {
			sum += dir[i];
		}
		System.out.println(sum);
	}

}
