package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int y;
	int x;
	int map[][];
	int dir[][];
	int sum;
	int startNum;
	public Node(int y, int x, int[][] map, int[][] dir, int sum, int startNum) {
		super();
		this.y = y;
		this.x = x;
		this.map = map;
		this.dir = dir;
		this.sum = sum;
		this.startNum = startNum;
	}
	
}
public class BOJ_19236 {
	static int dy[] = {0,-1,-1,0,1,1,1,0,-1};
	static int dx[] = {0,0,-1,-1,-1,0,1,1,1};
	static int smap[][]; // 상어 20
	static int sdir[][];
	static int n = 4;
	static int result = 0;
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		int ssum = smap[0][0];
		int sstart = 1;
		if(smap[0][0] == 1) sstart++;
		smap[0][0] = 20;
		q.add(new Node(0,0,smap,sdir,ssum,sstart));
		while(!q.isEmpty()) {
			Node now = q.poll();
			int score = now.sum;
			result = Math.max(result, score);
			int[][] map =now.map; 
			int[][] dir =now.dir; 
			int y =now.y; 
			int x =now.x; 
//			System.out.println(y+" "+x + " "+ score+" "+now.startNum);
			int startNum = now.startNum;
			littleMoving(map,dir,startNum);
//			print(map);
			int nowdir = dir[y][x];
			int ny = y + dy[nowdir];
			int nx = x + dx[nowdir];
			while(nx >= 0 && nx < n && ny >= 0 && ny < n) {
				int[][] tempMap = copyArr(map);
				int[][] tempDir = copyArr(dir);
				if(tempMap[ny][nx] != 0) {
					int value = tempMap[ny][nx];
					int nowStartNum = startNum;
					if(map[ny][nx] == nowStartNum) {
						nowStartNum = 20;
						for(int i = 0 ; i < n ; i++) {
							for(int j = 0 ; j < n ; j++) {
								if(tempMap[i][j] != 0 && tempMap[i][j] != 20 && nowStartNum > tempMap[i][j])
									nowStartNum = tempMap[i][j];
							}
						}
					}
					tempMap[ny][nx] = 20;
					tempMap[y][x] = 0;
//					System.out.println(value);
					q.add(new Node(ny,nx,tempMap,tempDir,score + value,nowStartNum));
				}
				ny += dy[nowdir];
				nx += dx[nowdir];
			}
//			break;
		}
	}
	static int[][] copyArr(int[][]arr){
		int[][] temp = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}
	static void littleMoving(int[][] map , int[][] dir, int startNum) {
		for(int t = startNum;t <= 16 ; t++) {
			boolean find = false;
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(t == map[i][j]) {
						find = true;
//						System.out.println(t);
						moving(map,dir,i,j);
//						print(map);
//						System.out.println();
						break;
					}
				}
				if(find) break;
			}
		}
	}
	static void moving(int[][] map , int[][] dir, int y  , int x) {
		int nowdir = dir[y][x];
		for(int i = 0 ; i < 8 ; i++) {
			if(nowdir > 8) nowdir = 1;
			int ny = y + dy[nowdir];
			int nx = x + dx[nowdir];
			if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[ny][nx] != 20) {
				dir[y][x] = nowdir;
				swap(map,y,x,ny,nx);
				swap(dir,y,x,ny,nx);
				break;
			}
			nowdir++;
		}
	}
	static void swap(int[][] arr,int y,int x , int ny,int nx){
		int temp = arr[y][x];
		arr[y][x] = arr[ny][nx];
		arr[ny][nx] = temp;
	}
	static void print(int arr[][]) {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		smap = new int[n][n];
		sdir = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < n ; j++) {
				smap[i][j] = Integer.parseInt(st.nextToken());
				sdir[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		print(smap);
//		print(sdir);
		bfs();
		System.out.println(result);
	}
}
