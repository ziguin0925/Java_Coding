import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        ArrayList<Score> Student = new ArrayList<>();

        Student.add(new Score(new int[] {1,2,3,4,5}));
        Student.add(new Score(new int[] {2,1,2,3,2,4,2,5}));
        Student.add(new Score(new int[] {3,3,1,1,2,2,4,4,5,5}));

        int length = answers.length;
        for(int i=0; i<length; i++){
            for(Score an : Student){
                if(answers[i]==an.number[i% an.number.length]){
                    an.score++;
                }
            }
        }

        int[] arr = {Student.get(0).score, Student.get(1).score, Student.get(2).score};
        List<Integer> a = new ArrayList<>();
        int k = Arrays.stream(arr).max().getAsInt();
        for(int i=0; i<Student.size(); i++){
            if(k==Student.get(i).score){
                a.add(i+1);
            }

        }
        int[] answer= a.stream().mapToInt(Integer::intValue).toArray();

        return a.stream().mapToInt(Integer::intValue).toArray();


    }
}

class Score{
    int score=0;
    int[] number;

    public Score(int[] number){
        this.number = number;
    }
}