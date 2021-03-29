import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1242 {
	static int N,K,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ; i <= N ; i++) {
			list.add(i);
		}
		int size = N;
		int cnt = 0 ;
		int deleteIndex = 0;
		while(true) {
			deleteIndex += K;
			cnt++;
	//		System.out.println(list);
	//		System.out.println("delete : " + deleteIndex);
			if(deleteIndex >= size) {
				deleteIndex = deleteIndex % size;
				if(deleteIndex == 0) deleteIndex = size;
				if(list.remove(deleteIndex) == M) break;
			}else {
				if(list.remove(deleteIndex) == M) break;
			}
			size--;
		}
		System.out.println(cnt);
	}
}	
