
import java.util.*;

class Solution {
    public static int[] solution(int[] answers) {
       int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] hit = new int[3];
        for(int i = 0; i < hit.length; i++) {
            for(int j = 0; j < answers.length; j++) {
                if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
            }
        }

        List<Integer> a = new ArrayList<>();
        int k = Math.max(hit[0], Math.max(hit[1], hit[2]));
        for(int i=0; i<hit.length; i++){
            if(k==hit[i]){
                a.add(i+1);
            }

        }
        int[] answer = new int[a.size()];
        int cnt = 0;
        for(int num : a)
            answer[cnt++] = num;

        return answer;
    }
}