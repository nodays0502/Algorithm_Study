package im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2564 {
	static int n , row,col;
	static int store[][];
	static int ndir,nlocation;
	static int cal() {
		int sum = 0 ;
		for(int i = 0 ; i < store.length;i++) {
			System.out.println(sum);
			int storedir = store[i][0];
			int storelocation = store[i][1];
			if((ndir == 1 || ndir == 2)&&(storedir == 1 || storedir == 2)) {
				if(ndir != storedir) {
					sum += row + Math.min(nlocation+storelocation, 2*col-nlocation-storelocation);
				}else {
					sum += Math.abs(nlocation - storelocation);
				}
			}else if((ndir == 3 || ndir == 4)&&(storedir == 3 || storedir == 4)) {
				if(ndir != storedir) {
					sum += col + Math.min(nlocation+storelocation, 2*row-nlocation-storelocation);
				}else {
					sum += Math.abs(nlocation - storelocation);
				}
			}else {
				int[] storeyx = new int[2];
				int[] nowyx = new int[2];
				change(storedir,storelocation,storeyx);
				change(ndir,nlocation,nowyx);
				sum += Math.abs(storeyx[0] - nowyx[0]) + Math.abs(storeyx[1] - nowyx[1]); 
	//			System.out.printf("%d %d %d %d\n",storeyx[0],storeyx[1],nowyx[0],nowyx[1]);
			}
		//	 ndir = storedir;
		//	 nlocation = storelocation ;
		}
		return sum;
	}
	static void change(int dir,int location,int[] yx) {
		switch(dir) {
		case 1: yx[0] = row; yx[1] = location;break;
		case 2: yx[0] = 0; yx[1] = location;break;
		case 3: yx[0] = row - location; yx[1] = 0;break;
		case 4: yx[0] = row- location; yx[1] = col;break;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		col  = Integer.parseInt(st.nextToken());
		row  = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		store=  new int[n][2];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int dir = Integer.parseInt(st.nextToken());
			int location = Integer.parseInt(st.nextToken());
			store[i][0] = dir;
			store[i][1] = location;
		}
		st = new StringTokenizer(br.readLine()," ");
		ndir = Integer.parseInt(st.nextToken());
		nlocation = Integer.parseInt(st.nextToken());

		System.out.println(cal());
	}
}
