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

        for(int i = 0; i < progresses.length; i++){
            qu.add((int) Math.ceil(((100.0-progresses[i])/speeds[i])));
        }

        Integer Max = qu.poll();
        List<Integer> list = new ArrayList<>();
        int count =1;
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
        list.add(count);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}