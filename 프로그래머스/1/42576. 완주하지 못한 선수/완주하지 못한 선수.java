import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        String answer="";
        
        for(String name : completion){
            if(map.containsKey(name)){
                map.put(name,map.get(name)+1);
                continue;
            }
            map.put(name,1);
        }
        
        for(String name : participant){
            //if there is a data in the map for name
            if(map.containsKey(name)){
                //value가 1
                if(map.get(name)==0){
                    answer=name;
                    break;
                }
                //value is over 1
                map.put(name,map.get(name)-1);
                continue;
            }
            answer=name;
        }
        return answer;
    }
}