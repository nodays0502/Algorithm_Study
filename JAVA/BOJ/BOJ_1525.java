package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
class Node{
	int count = 0 ;
	int[][] arr;
	public Node(int count, int[][] arr) {
		super();
		this.count = count;
		this.arr = arr;
	}
}
public class BOJ_1525 {
	static int dx[] = {0,-1,0,1};
	static int dy[] = {1,0,-1,0};
	static int input[][] = new int[3][3]; // 처음 값
	static int correct[][] = new int[][] {{1,2,3},{4,5,6},{7,8,0}}; // 최종 목표의 배열
	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		Set<String> s = new HashSet<>();
		Node n = new Node(0,input);
		q.add(n);
		int result = -1;
		while(!q.isEmpty()) {
			Node now = q.poll();
			int[][] arr = now.arr;
			int count = now.count;
//			System.out.println(Arrays.deepToString(arr)+" "+count);
			boolean flag = true;
			for(int i = 0 ; i < 3; i++) { // 맞춰하는 모양과 같은지 체크한다.
				for(int j = 0 ; j< 3; j++) {
					if(arr[i][j] != correct[i][j]) {flag = false;}
				}
			}
			if(flag) {result = count; break;}
			int y = 0 ,x = 0;
			for(int i = 0 ; i < 3; i++) { 
				for(int j = 0 ; j < 3; j++) {
					if(arr[i][j] == 0) {
						y = i;
						x = j;
					}
				}
			}
//			System.out.println(y+" "+x);
			for(int i = 0 ; i < 4 ; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
					int [][] temp = arrCopy(arr);
					swap(temp,y,x,ny,nx);
					if(s.add(makeString(temp))) {
						q.add(new Node(count + 1,temp));
					}
				}
			}
		}
		return result;
	}
	static int[][] arrCopy(int[][] arr){ // 딮 카피를 하기위해
		int[][] temp = new int[3][3];
		for(int i = 0 ; i < 3; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}
	static void swap(int[][] arr , int y , int x , int ny , int nx) {  // 배열 내부에서 스왑
		int temp = arr[y][x];
		arr[y][x] = arr[ny][nx];
		arr[ny][nx] = temp;
	}
	static String makeString(int[][] arr) { // 숫자 순서대로 문자열을 만들어서 set을 통해 해당하는 곳에 방문 했는지 체크한다.
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 3; i++) {
			for(int j = 0 ; j< 3; j++) {
				sb.append(arr[i][j]);
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0 ; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < 3; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
	}
}
