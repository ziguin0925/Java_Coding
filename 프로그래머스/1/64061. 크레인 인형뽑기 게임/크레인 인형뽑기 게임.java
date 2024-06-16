import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        int answer = 0;
        
        for(int i=0; i<moves.length; i++){
            moves[i] -= 1;
        }
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<moves.length; i++){
            
            for(int j=0; j<board.length; j++){
                
                if(board[j][moves[i]]!=0){
                    if(!st.isEmpty() && board[j][moves[i]]==st.peek()){
                        st.pop();
                        answer+=2;
                        board[j][moves[i]]=0;
                        break;
                    }
                    st.add(board[j][moves[i]]);
                    board[j][moves[i]]=0;
                    break;
                }//endif
                
            }//endfor_j
            
        }//endfor_i
        return answer;
    }
}