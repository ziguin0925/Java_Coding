import java.util.HashMap;
import java.util.HashSet;

class Solution {
    
        public static int solution(String[] want, int[] number, String[] discount){
            int answer = 0;

            HashMap<String, Integer> map = new HashMap<>();

            for(int i =0; i<number.length; i++){
                map.put(want[i], number[i]);
            }

            for(int i =0; i<discount.length-9; i++) {
                HashMap<String, Integer> disMap=  new HashMap<>();

                for(int j =i; j<i+10; j++) {
                    if(!disMap.containsKey(discount[j])){
                        disMap.put(discount[j],1);
                    }else{
                        disMap.put(discount[j], disMap.get(discount[j])+1);
                    }
                }
                if(disMap.equals(map)) answer++;

            }
            return answer;
        }
    
    /*
       static public int solution3(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i=0;i<discount.length-9;i++) {
            int j;
            for(j=0;j<want.length;j++) {
                int check=0;
                for(int k=i;k<i+10;k++) {
                    if(discount[k].equals(want[j])) check++;
                }        
                if(check<number[j]) {
                     break;
                }
            }
           if(j==want.length) answer ++;
        }
        return answer;
    }
    
    public int solution2(String[] want, int[] number, String[] discount) {
        int answer = 0;

            HashMap<String, Integer> map = new HashMap<>();
            HashSet<String> set = new HashSet<>();

            for(int i =0; i<number.length; i++){
                // map.put(want[i], number[i]);
                set.add(want[i]);
            }

            for(int i =0; i<discount.length()-9; i++){
                //현재 discount품목이 want에 포함이 된다면
                if(set.contains(discount[i])){
                    map.put(discount[i],1);

                    //현재 discount 품목 다음부터 9개 읽기.
                    for(int j =1; j<10;j++){
                        if(!set.contains(discount[i+j])){
                            //i+j번째 discount 품목이 set에 없으면 map 초기화
                            map.clear();
                            break;
                        }

                        if(!map.containsKey(discount[i+j])){
                            map.put(discount[i+j],1);
                        }else{
                            map.put(discount[i+j], map.get(discount[i+j])+1);
                        }

                        if(j==9){
                            for(int k=0;k<number.length;k++){
                                if(map.get(want[k])!=number[k]){
                                    break;
                                }
                                if(k==number.length-1){
                                    answer++;
                                }
                            }
                            map.clear();
                        }
                    }
                }
            }
            return answer;
    }
    */
}