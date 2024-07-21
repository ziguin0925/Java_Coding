class Solution
{
    
    public int solution(int n, int a, int b)
    {
        
        int answer=0;
        
        if(a>b){
            answer = cal(b,a);
        }else if(b>a){
            answer =cal(a,b);
        }else{
            answer = 1;
        }
        
        return answer;
    }
    
    
    private static int cal(int a, int b){

        int answer = 1;

        while(true){
            if(a%2==1 && b%2==0 && b-a==1){
                return answer;
            }

            if(a%2==1){
                a++;
            }
            if(b%2==1){
                b++;
            }

            a/=2;
            b/=2;
            answer++;
        }
        
    }
}