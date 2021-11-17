package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1021 {
    static int n, m;
    static int input[];
    static int dfs(int depth, Deque<Integer> deque){
        if(depth == m){
            return 0;
        }
        int result = 0;
        int target = input[depth];
        int size = deque.size();

        int cnt = 0;
        boolean flag = false;
        Iterator<Integer> iterator = deque.iterator();
        Iterator<Integer> descendingIterator = deque.descendingIterator();
        while(true){
            if(iterator.hasNext()){
                int num = iterator.next();
//                System.out.println("interator:"+num);
                if (num == target){
                    flag = true;
                    break;
                }
            }
            if(descendingIterator.hasNext()){
                int num = descendingIterator.next();
//                System.out.println("descendingIterator:"+num);
                if (num == target){
                    cnt++;
                    break;
                }
            }
            cnt++;
        }
        result += cnt;
        if(flag){
            for(int i = 0 ; i< cnt ; i++){
                int num = deque.pollFirst();
                deque.offerLast(num);
            }
        }else{
            for(int i = 0 ; i< cnt ; i++){
                int num = deque.pollLast();
                deque.offerFirst(num);
            }
        }
//        System.out.println(depth+" "+cnt);
        deque.pollFirst();
        result += dfs(depth+1,deque);
        return result;
    }
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        input = new int[m];
        for(int i = 0 ; i < m ; i++){
            input[i] = stoi.apply(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1 ; i <= n ; i++){
            deque.addLast(i);
        }
        System.out.println(dfs(0,deque));



    }
}
