import java.util.Comparator;
import java.util.Arrays;


class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int[] isle = new int[n];
        for(int i=0; i<n ;i++){
            isle[i]=i;
        }

        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
        
        
        for(int[] arr : costs){
            if(find(isle,arr[0])!=find(isle,arr[1])){
                isle[Math.max(find(isle,arr[0]),find(isle,arr[1]))] = Math.min(find(isle,arr[0]),find(isle,arr[1]));
                answer+=arr[2];
            }
        }
        
        
        return answer;
    }
    
    
    private static int find(int[] arr, int idx){

        if (arr[idx]==idx) return idx;

        return find(arr,arr[idx]);
    }
    
    
}