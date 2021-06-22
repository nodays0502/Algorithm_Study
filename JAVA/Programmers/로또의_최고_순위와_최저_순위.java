package self;

import java.util.HashSet;
import java.util.Set;

public class 로또의_최고_순위와_최저_순위 {
    static int cal(int sum){
        int result = 6;
        if(sum == 6) result = 1;
        else if(sum == 5) result =2;
        else if(sum == 4) result = 3;
        else if(sum == 3) result = 4;
        else if(sum == 2) result = 5;
        
        return result;
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int zeroCnt = 0;
        Set<Integer> s = new HashSet<>();
        for(int i = 0 ; i < win_nums.length; i++)
            s.add(win_nums[i]);
        for(int i = 0 ; i < lottos.length ; i++){
            if(lottos[i] == 0) zeroCnt++;
            else{
                if(!s.add(lottos[i]))
                    cnt++;
            }
        }
        int sum = cnt + zeroCnt;
        answer[0] = cal(sum);
        answer[1] = cal(cnt);
        return answer;
    }

}
