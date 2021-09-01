import java.util.*;
import java.io.*;
class Solution {
    static int cal(int cnt){
        if(cnt == 6){
            return 1;
        }else if(cnt == 5){
            return 2;
        }else if(cnt == 4){
            return 3;
        }else if(cnt == 3){
            return 4;
        }else if(cnt == 2){
            return 5;
        }else{
            return 6;
        }
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int min = 0;
        int max = 0;
        Set<Integer> map = new HashSet<>();
        for(int num : win_nums){
            map.add(num);
        }
        for(int num : lottos){
            if(num == 0){
                max++;
            }else  if(map.contains(num)){
                max++;
                min++;
            }
        }
        max = cal(max);
        min = cal(min);
        answer = new int[]{max,min};
        return answer;
    }
}
