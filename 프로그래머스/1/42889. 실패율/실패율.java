import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] arr = new double[N+2];
        int[] k= Arrays.stream(stages).distinct().sorted().toArray();

        ArrayList<double[]> list = new ArrayList<>(N);

        for (int i = 0; i < stages.length; i++) {//각 스테이지에 도전하고 있는 사람들.
            arr[stages[i]]++;
        }

        
        double size =stages.length;
        
        for(int i =0; i<arr.length; i++){
            if(arr[i]!=0){
                double num =arr[i];
                arr[i] = arr[i]/size;
                size -= num;
            }
        }


        //check : 스테이지 별 실패율(0이 아닌)
        // k : 실패율이 0이 아닌 스테이지

       

        for(int i = 1; i < N+1; i++) {
            list.add(new double[]{i,arr[i]});
        }

        list.sort((a,b)->Double.compare(b[1],a[1]));

        for(int i=0;i<list.size();i++){
            answer[i]=(int)list.get(i)[0];
        }

        return answer;
    }
}