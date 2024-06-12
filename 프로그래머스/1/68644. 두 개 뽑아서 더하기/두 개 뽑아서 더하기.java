import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        Set<Integer> set = new HashSet();
        int length =numbers.length;
        for(int i =0; i<length; i++){
            for(int j =i+1; j<length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        answer= set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}