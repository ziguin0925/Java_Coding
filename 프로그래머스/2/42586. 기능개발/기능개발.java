import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] a ={93, 30, 55};
        int[] b ={1,30,5};
        System.out.println(Arrays.toString(Solution.solution(a,b)));

    }
}

class Solution{

    public static int[] solution(int[] progresses, int[] speeds){
        Queue<Integer> qu = new LinkedList<>();

        //첫번째 작업부터 시작하여 작업완료할 수있는 날짜를 구해 큐에 추가한다.
        for(int i = 0; i < progresses.length; i++){
            qu.add((int) Math.ceil(((100.0-progresses[i])/speeds[i])));
        }
        
        //첫번째 작업완료할 수있는 날짜 Max라고 친다.
        Integer Max = qu.poll();
        List<Integer> list = new ArrayList<>();
        int count =1;
        
        //첫번째 작업완료할 수 있는 날짜보다 같거나 작은 배포일은 같이 배포될 수 있으므로 count를 증가 시킨다.
        //Max보다 더 큰 날짜가 나온 경우에는 Max를 바꾸어주고 count를 1로 돌린 후 다시 비교한다.  
        while(!qu.isEmpty()){
            if( Max < qu.peek()){
                Max=qu.poll();
                list.add(count);
                count=1;
            }else{
                qu.poll();
                count++;
            }
        }
        //마지막 count 추가
        list.add(count);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}