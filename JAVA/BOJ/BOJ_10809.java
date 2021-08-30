package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10809 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int firstIndex[] = new int[26];
        String command = br.readLine();
        Arrays.fill(firstIndex, -1);
        for(int i = 0 ; i < command.length(); i++){
            int now = command.charAt(i) - 'a';
            if(firstIndex[now] == -1){
                firstIndex[now] = i;
            }
        }
        for(int cnt : firstIndex){
            System.out.print(cnt+" ");
        }
    }
}
