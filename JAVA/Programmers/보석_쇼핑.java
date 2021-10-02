import java.util.*;

class Solution {
    boolean check(int[] counts){
        for(int count : counts){
            if(count ==0)return false;
        }
        return true;
    }
    public int[] solution(String[] gems) {
        int[] answer = {};
        int cnt = 0;
        Map<String,Integer> map = new HashMap<>();
        for(String gem : gems){
            if(!map.containsKey(gem))
                map.put(gem,cnt++);
        }
        int count[] = new int[cnt];
        int si = 0;
        int ei = -1;
        int min = 100001;
        int[] result = new int[] {0,0};
        while(true){
            if(check(count)){
                // System.out.println(si+" "+ei);
                if(min > ei - si){
                    min = ei - si;
                    result = new int[] {si+1, ei+1};
                }
                int index = map.get(gems[si]);
                count[index]--;
                si++;
            }else{
                ei++;
                if(ei > gems.length-1){
                    break;
                }
                int index= map.get(gems[ei]);
                count[index]++;
                
            }
        }
        answer = result;
        return answer;
    }
}
