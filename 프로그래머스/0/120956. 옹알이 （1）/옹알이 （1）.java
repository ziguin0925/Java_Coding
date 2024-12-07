import java.util.*;

class Solution {

    public int solution(String[] babbling) {

        
        // 가능한 발음 조각
        List<String> validParts = Arrays.asList("aya", "ye", "woo", "ma");
        int count = 0;

        for (String word : babbling) {
            String originalWord = word;
            for (String part : validParts) {
                // 발음할 수 있는 부분을 빈 문자열로 대체
                word = word.replaceFirst(part, " ");
            }
            // 단어가 모두 비워지면 유효한 발음으로 간주
            if (word.trim().isEmpty()) {
                count++;
            }
        }

        return count;

    }
}