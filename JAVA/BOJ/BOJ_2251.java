package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2251 {
    static class Node{
        int a, b,c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] input = new int[3];
        for(int i = 0 ;i <3; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Set<String> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> result = new HashSet<>();
        result.add(input[2]);
        q.offer(new int[] {0,0,input[2]});
        set.add(Arrays.toString(new int[] {0,0,input[2]}));

        while(!q.isEmpty()){
            int[] now = q.poll();
            System.out.println(Arrays.toString(now));
            for(int i = 0 ; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(i == j) continue;
                    int[] clone = Arrays.copyOf(now,now.length);
                    clone[i] += clone[j];
                    clone[j] = 0;
                    if(clone[i] > input[i]){
                        clone[j] = (clone[i] - input[i]);
                        clone[i] = input[i];
                    }
                    if(!set.contains(Arrays.toString(clone))){
                        set.add(Arrays.toString(clone));
                        if(clone[0] == 0) {
                            result.add(clone[2]);
                        }
                        q.offer(clone);
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>(result);
        Collections.sort(list);
        for(int i = 0 ; i < list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
