package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1504 {

    static class Node {

        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static int n, e;

    static int dij(int start, int end) {
        int result = -1;
        boolean visited[] = new boolean[n + 1];
        int distance[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            distance[i] = 900000;
        }
        distance[start] = 0;
        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(distance));
            int min = 900000;
            int minIndex = 0;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && min > distance[j]) {
                    min = distance[j];
                    minIndex = j;
                }
            }
            if (minIndex == end) {
                return min;
            } else if (minIndex == 0) {
                return -1;
            }

            visited[minIndex] = true;

            for (int j = 0; j < map[minIndex].size(); j++) {
                int nextIndex = map[minIndex].get(j).end;
                int weight = map[minIndex].get(j).weight;
                if (!visited[nextIndex] && distance[nextIndex] > weight + min) {
                    distance[nextIndex] = weight + min;
                }
            }
        }

        return -1;
    }

    static List<Node> map[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        map = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Node(b, c));
            map[b].add(new Node(a, c));
        }
        int result = 0;
        st = new StringTokenizer(br.readLine(), " ");
        int input[] = new int[4];
        input[0] = 1;
        input[1] = Integer.parseInt(st.nextToken());
        input[2] = Integer.parseInt(st.nextToken());
        input[3] = n;
        for(int i = 0 ; i < 3; i++){
            int temp = dij(input[i],input[i+1]);
//            System.out.println(temp);
            if(temp != -1)
                result += temp;
            else{
                result = -1;
                break;
            }
        }
        if(result != -1){
            int tempresult=0;
            int temp = input[1];
            input[1] = input[2];
            input[2] = temp;
            for(int i = 0 ; i < 3; i++){
                tempresult += dij(input[i],input[i+1]);
            }
            result = Math.min(result,tempresult);
        }
        System.out.println(result);
    }
}
