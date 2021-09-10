import java.util.*;
class Solution {
    static char[] choice;
    static char[] menu;
    static Map<String,Integer> map = new HashMap<>();
    static void pick(int depth,int length,int start){
        if(depth == length){
            String temp = new String(choice);
            Integer cnt = map.get(temp);
            if(cnt == null){
                map.put(temp,1);
            }else{
                // System.out.println(temp);
                map.put(temp,cnt+1);
            }
        }else{
            for(int i = start ; i < menu.length; i++){
                char now = menu[i];
                choice[depth] = now;
                pick(depth+1,length , i+1);
            }
        }
    }
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> tempAnswer = new ArrayList<>();
        for(String order : orders){
            for(int num : course){
                menu = order.toCharArray();
                choice = new char[num];
                Arrays.sort(menu);
                pick(0,num,0);
            }
        }
        Iterator<String> keys = map.keySet().iterator();
        int[] max = new int[21];
        while(keys.hasNext()){
            String key = keys.next();
            int cnt = map.get(key);
            max[key.length()] = Math.max(max[key.length()],cnt);
        }
        keys = map.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            int cnt = map.get(key);
            int tempmax = max[key.length()];
            if(tempmax == cnt && cnt >=2 ){
                tempAnswer.add(key);
            }
        } 
        Collections.sort(tempAnswer);
        answer = new String[tempAnswer.size()];
        for(int i = 0 ; i < tempAnswer.size();i++){
            answer[i] = tempAnswer.get(i);
        }
        return answer;
    }
}
