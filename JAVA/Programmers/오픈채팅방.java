import java.util.Arrays;
import java.util.HashMap;

class Solution {
	static String[] moving= {"Enter","Leave"};
	static String[] str = {"님이 들어왔습니다.","님이 나갔습니다."};
	public String[] solution(String[] record) {
        String[] answer = {};
        int size = record.length;
        HashMap<String,String> map = new HashMap<String,String>();
        int resultmove[] = new int[size];
        String resultuser[] = new String[size];
        int cnt = 0;
        String move;
        String userid;
        String nickname = null;
        for(int i = 0 ; i < record.length; i++) {
        	String[] temp = record[i].split(" ");
    //    	System.out.println(Arrays.toString(temp));
    //    	System.out.println(temp.length);
        	move = temp[0];
        	userid = temp[1];
        	resultuser[i] = userid;
        	resultmove[i] = -1;
        	if(move.equals(moving[1]) == false) {
        		nickname = temp[2];
        		map.put(userid,nickname);
        	}
        	for(int j = 0 ; j < 2 ; j++) {
        		if(move.equals(moving[j])) {
        			resultmove[i] = j;
        			cnt++;
        			break;
        		}
        	}
        }
//        System.out.println(Arrays.toString(resultmove));
        answer = new String[cnt];
        int num = 0;
        for(int i = 0 ; i < record.length; i++) {
        	StringBuilder sb = new StringBuilder();
        	if(resultmove[i] != -1) {
        		String user = map.get(resultuser[i]);
        		sb.append(user);
        		sb.append(str[resultmove[i]]);
       // 		System.out.println(sb);
        		answer[num++] = sb.toString();
        	}
        }
        return answer;
    }
}
