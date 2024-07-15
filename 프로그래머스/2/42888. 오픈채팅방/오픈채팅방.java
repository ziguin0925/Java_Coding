import java.util.List;
import java.lang.StringBuilder;

import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {

        int count = 0;
        StringBuilder sb = new StringBuilder();

        HashMap<String , String> hm = new HashMap<>();

        //record[0] = 방식
        //record[1] = uid
        //record[2] = 이름
        for(int i =0; i<record.length; i++){
            String[] parse = record[i].split(" ");

            if(parse[0].equals("Enter")){
                count++;
                hm.put(parse[1],parse[2]);
                sb.append(parse[0]+" ");
                sb.append(parse[1]+" ");
            }
            else if(parse[0].equals("Leave")){
                count++;
                sb.append(parse[0]+" ");
                sb.append(parse[1]+" ");
            }
            //Change
            else{
                hm.put(parse[1], parse[2]);
            }
        }

        String[] answer = new String[count];

        String[] result = sb.toString().split(" ");

        sb.delete(0, sb.length());

        for(int i =0; i<count; i++)
        {
            if(result[i*2].equals("Enter")){
                sb.append(hm.get(result[(i*2)+1])).append("님이 들어왔습니다.");
            }
            else if(result[i*2].equals("Leave")){
                sb.append(hm.get(result[(i*2)+1])).append("님이 나갔습니다.");
            }
            answer[i] = sb.toString();
            sb.delete(0, sb.length());

        }
        
        return answer;
    }
}