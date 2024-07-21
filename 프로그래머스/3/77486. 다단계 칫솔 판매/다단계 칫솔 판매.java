import java.util.HashMap;


class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        HashMap<String, Box> map = new HashMap<>();

        for(int i = 0; i < enroll.length; i++){
            map.put(enroll[i], new Box(referral[i]));
        }

        for(int i = 0; i < seller.length; i++){
            cal(map ,seller[i],amount[i]*100);
        }

        for(int i = 0; i < enroll.length; i++){
            answer[i] = map.get(enroll[i]).profit;
        }

        return answer;



    }

    private static void cal(HashMap<String, Box> map, String seller,int amount) {

        int profit = (int) Math.ceil(amount*0.9);
        map.get(seller).profit += profit;
        if(map.get(seller).refer.equals("-") || (amount-profit)==0){
            return ;
        }else{
            cal(map, map.get(seller).refer,amount-profit);
        }
    }
}

class Box{
    String refer;
    int profit;

    Box(String refer){
        this.refer = refer;
        this.profit = 0;
    }

    @Override
    public String toString() {
        return profit+",";
    }
}

