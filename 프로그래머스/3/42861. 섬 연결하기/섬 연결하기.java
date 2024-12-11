import java.util.Comparator;
import java.util.Arrays;


class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 각 섬의 번호는 0부터 n-1임.
        int[] isle = new int[n];
        
        /*
        인덱스는 섬의 번호, 배열 값은 부모 노드.
        */
        for(int i=0; i<n ;i++){
            isle[i]=i;
        }

        // 섬 간의 다리를 잇는 비용을 오름차순으로 정렬 
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
        
        // n-1번호 까지의 모든 섬을 연결하기 위한 반복.(모든 경우의수 확인)
        for(int[] arr : costs){
            // 섬과 섬 사이의 부모노드가 다를경우.
            if(find(isle,arr[0])!=find(isle,arr[1])){
                
                // 번호가 큰 섬은 번호가 작은 섬을 부모노드로 삼음.
                isle[Math.max(find(isle,arr[0]),find(isle,arr[1]))] 
                    = Math.min(find(isle,arr[0]),find(isle,arr[1]));
                
                // 두 섬을 연결하였으므로 최소비용을 더해준다.
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