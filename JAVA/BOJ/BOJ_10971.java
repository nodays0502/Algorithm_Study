import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10971 {
	static int map[][];
	static int n;
	static final int LIMIT = 987654321;
	static int dfs(List<Integer> list) {
		if(list.size() == n) {
			if(map[list.get(list.size()-1)][0] != 0) 
				return map[list.get(list.size()-1)][0];
			else return LIMIT;
		}
		int result = LIMIT; 
		for(int i = 1 ; i < n; i++) {
			if(!list.contains(i) 
					&& map[list.get(list.size()-1)][i] != 0) {
				list.add(i);
				result = Math.min(result, dfs(list)+map[list.get(list.size()-2)][i]);
				list.remove(list.get(list.size()-1));
			}
		}
		return result;
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		map = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	//	System.out.println(Arrays.deepToString(map));
		List<Integer> list = new LinkedList<Integer>();
		list.add(0);
		System.out.println(dfs(list));
	}
}
