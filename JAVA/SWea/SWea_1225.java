package day04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWea_Password {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Queue<Integer> queue = null;
		for(int t = 1 ; t <= 10 ; t++) {
			st = new StringTokenizer(br.readLine()," ");
			st = new StringTokenizer(br.readLine()," ");
			queue = new LinkedList<Integer>();
			for(int i = 0 ; i < 8 ; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			int j  = 1;
			while(true) {
				int temp = queue.poll();
				if(temp - j > 0) {
					queue.offer(temp-j);
				}else {
					queue.offer(0);
					break;
				}
				j++;
				if(j == 6) j = 1;
			}
			System.out.println(queue);
			System.out.print("#"+t);
			for(int i = 0 ; i < 8 ; i++) {
				System.out.print(" " + queue.poll());
			}
			System.out.println();
		}
	}
}
/*

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Queue<Integer> queue = null;
		LinkedList<Integer> list = null;
		for(int t = 1 ; t <= 10 ; t++) {
			st = new StringTokenizer(br.readLine()," ");
			st = new StringTokenizer(br.readLine()," ");
			queue = new LinkedList<Integer>();
			list  = new LinkedList<Integer>();
		//	queue = Queue<Integer>(list);
			for(int i = 0 ; i < 8 ; i++) {
				list.add(Integer.parseInt(st.nextToken())); // 각 요소에 (가장 작은 수/15) * 15를 뺸다.
			}
			boolean over = true;
			while(true) {
				over = true;
				for(int i = 0 ; i < 8 ; i++) {
					if(list.get(i) <= 15) {
						over = false;
						break;
					}
				}
				if(!over) break;
				else {
					for(int i = 0 ; i < 8 ; i++) {
						list.set(i,list.get(i)-15);
					}
				}
			}
			queue = list;
			int j = 1;
			while(true) {
				int temp = queue.poll();
				if(temp - j > 0) {
					queue.offer(temp-j);
				}else {
					queue.offer(0);
					break;
				}
				j++;
				if(j == 6) j = 1;
			}
			System.out.print("#"+t);
			for(int i = 0 ; i < 8 ; i++) {
				System.out.print(" " + queue.poll());
			}
			System.out.println();
		}
	}
}
*/

