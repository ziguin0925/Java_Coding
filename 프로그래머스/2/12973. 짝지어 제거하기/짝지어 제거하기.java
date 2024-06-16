
import java.util.Stack;
class Solution{
    public int solution(String s){
        int answer = -1;
        
        Stack<Character> st = new Stack<>();
        int length = s.length();
        if(length%2!=0){
            return 0;
        }
        
        for(int i =0; i<length; i++){
            if(st.isEmpty()){
                st.add(s.charAt(i));
                continue;
            }
            if(st.peek()==s.charAt(i)){
                st.pop();
                continue;
            }
            st.add(s.charAt(i));
        }
        if(st.isEmpty()){
            return 1;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return 0;
    }
}