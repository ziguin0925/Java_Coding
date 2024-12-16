import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];

        List<Integer> list = new ArrayList<>();

        // commands에서 1차원 배열 순회.
        for(int num = 0; num < commands.length; num++){

            // list에 담기.
            for(int i = commands[num][0]-1; i<commands[num][1]; i++){
                list.add(array[i]);
            }

            list = list.stream().sorted().collect(Collectors.toList());
            answer[num] = list.get(commands[num][2]-1);
            list.clear();
        }        
        
        return answer;
    }
}