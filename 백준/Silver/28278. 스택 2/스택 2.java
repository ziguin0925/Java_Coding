import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
    
    Stack<Integer> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    for(int i =0; i<num; i++){
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String command = st.nextToken();
        // 정수 X를 스택에 넣는다
        if(command.equals("1")){
            int value = Integer.parseInt(st.nextToken());
            stack.push(value);
            
        // 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.)
        }else if(command.equals("2")){
        // 스택이 비어있을 경우.
            if(stack.isEmpty()){
                list.add(-1);
            }else{
                int lastest = stack.pop();
                list.add(lastest);
            }
            
        // 스택에 들어있는 정수의 개수를 출력한다.
        }else if(command.equals("3")){
            list.add(stack.size());
            
        //  스택이 비어있으면 1, 아니면 0을 출력한다.
        }else if(command.equals("4")){
            if(stack.isEmpty()){
                list.add(1);
            }else{
                list.add(0);
            }
            
        // 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
        }else{
            if(stack.isEmpty()){
                list.add(-1);
            }else{
                list.add(stack.peek());
            }
          }
        }
        list.forEach(System.out::println);
    }
}
