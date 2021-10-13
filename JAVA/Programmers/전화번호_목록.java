import java.util.*;
class Solution {
    static Set<String> set = new HashSet<>();
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book,(s1,s2)->{return s1.length() - s2.length();});
        for(String number : phone_book){
            for(int i = 1 ; i <= number.length(); i++){
                String subString = number.substring(0,i);
                // System.out.println(subString);
                if(set.contains(subString)){
                    // System.out.println("false");
                    answer = false;
                    break;
                }
            }
            if(!answer){
                break;
            }else{
                set.add(number);
            }
        }
        return answer;
    }
}
