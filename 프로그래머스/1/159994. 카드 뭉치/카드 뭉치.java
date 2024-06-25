import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String> c1 = new LinkedList<>();
        Queue<String> c2 = new LinkedList<>();
        
        
        
        for(String s : cards1){
            c1.add(s);
        }
        for(String s: cards2){
            c2.add(s);
        }
        
        //cards1과 cards2에는 서로 다른 단어만 존재합니다.
        for(int i=0;i<goal.length;i++){
            if(!(c1.isEmpty()) && c1.peek().equals(goal[i])){
                c1.poll();
            }else if(!(c2.isEmpty()) && c2.peek().equals(goal[i])){
                c2.poll();
            }else{
                answer="No";
                break;
            }
            answer ="Yes";
            
        }
        
        
        return answer;
    }
}