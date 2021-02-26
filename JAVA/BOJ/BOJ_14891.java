package Past;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;



public class BOJ_14891 {
	static List<LinkedList<Integer>> input;
	static int n;
	static void rotation(int num, int dir) {
		if(dir == 1){
			int temp = input.get(num).pollLast();
			input.get(num).offerFirst(temp);
		}else {
			int temp = input.get(num).pollFirst();
			input.get(num).offerLast(temp);			
		}
	}
	static void rotationAll(int num, int dir) {
//		rotation(num,dir);
		int now = num;
		int nowdir = dir;
		int doRotation[] = new int[4];
		doRotation[num] = dir;
		while(true) {
	//		System.out.println(now+" "+dir);
			if(now == 3) break;
			if(input.get(now).get(2) != input.get(now+1).get(6)) {
				nowdir = ~nowdir+1;
		//		System.out.println((now+1)+"rotation"+(nowdir));
				doRotation[now+1] = nowdir;
		//		rotation(now+1,nowdir);
			}else {break;}
			now++;
		}
		now = num;
		nowdir = dir;
		while(true) {
			if(now == 0) break;
			if(input.get(now).get(6) != input.get(now-1).get(2)) {
		//		System.out.println(input.get(now).get(6)+" "+input.get(now-1).get(2));
				nowdir = ~nowdir+1;
				doRotation[now-1] = nowdir;
		//		System.out.println((now-1)+"rotation"+(nowdir));
		//		rotation(now-1,nowdir);
			}else {break;}
			now--;
		}
		for(int i = 0 ; i < 4 ; i++) {
			if(doRotation[i] != 0){
				rotation(i,doRotation[i]);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		input = new ArrayList<LinkedList<Integer>>();
		for(int i = 0 ; i < 4; i++) {
			input.add(new LinkedList<Integer>());
			String command = br.readLine();
			for(int j = 0 ; j < 8 ; j++)
				input.get(i).add(command.charAt(j)-'0');
		}
		st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < n ; i++) {
		//	System.out.println(i);
			st = new StringTokenizer(br.readLine()," ");
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()); // 1 시계 방향 -1 반시계 방향
			rotationAll(num-1,dir);
		}
		int sum = 0;
		int count = 1;
		for(int i = 0 ; i < 4 ;i++) {
			sum += count * input.get(i).get(0);
	//		System.out.println(sum);
			count*=2;
		}
		System.out.println(sum);
	}
}
