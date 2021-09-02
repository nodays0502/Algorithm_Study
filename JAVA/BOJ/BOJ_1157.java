package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1157 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count[] = new int[26];
        String command = br.readLine().toUpperCase();
        int max = 0;
        char alpha = 'A';
        boolean flag = false;
        for (int i = 0; i < command.length(); i++) {
            char now = command.charAt(i);
            count[now - 'A']++;
            if (max < count[now - 'A']) {
                max = count[now - 'A'];
                flag = true;
                alpha = now;
            } else if (max == count[now - 'A']) {
                flag = false;
                alpha = now;
            }
        }
        if (flag) {
            System.out.println(alpha);
        } else {
            System.out.println("?");
        }
    }
}
