class Solution {
    public int solution(String dirs) {
        int answer = 0;

        boolean[][] map = new boolean[21][21];
        int x = 10;
        int y = 10;



        for(int i =0; i<dirs.length(); i++){
            if(dirs.charAt(i)=='U'&& y!=0){
                y=y-2;
                if(!map[x][y+1]){
                    map[x][y+1] = true;
                    answer++;
                }
            }else if(dirs.charAt(i)=='D'&& y!=20){
                y=y+2;
                if(!map[x][y-1]){
                    map[x][y-1] = true;
                    answer++;
                }

            }else if(dirs.charAt(i)=='R'&& x!=20){
                x=x+2;
                if(!map[x-1][y]){
                    map[x-1][y] = true;
                    answer++;
                }

            }else if(dirs.charAt(i)=='L'&& x!=0){
                x=x-2;
                if(!map[x+1][y]){
                    map[x+1][y] = true;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
