import java.io.*;
import java.util.*;

public class Main {

    static int[][] map; // 지도를 저장할 배열
    static boolean[][] visited; // 방문 여부를 체크할 배열
    static int[] dx = {1, -1, 0, 0}; // 이동 방향 (상, 하, 좌, 우)
    static int[] dy = {0, 0, 1, -1};
    static int n; // 지도의 크기
    static List<Integer> complexes = new ArrayList<>(); // 각 단지의 크기 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력: 지도 크기 N
        n = Integer.parseInt(br.readLine());

        // 지도 배열 초기화
        map = new int[n][n];
        visited = new boolean[n][n];

        // 지도 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0'; // 문자열을 숫자로 변환
            }
        }

        // DFS를 이용해 단지 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) { // 집이 있고 방문하지 않은 경우
                    int size = dfs(i, j); // 단지 크기 계산
                    complexes.add(size); // 결과 리스트에 추가
                }
            }
        }

        // 결과 출력
        Collections.sort(complexes); // 단지 크기 오름차순 정렬
        System.out.println(complexes.size()); // 단지 수 출력
        for (int size : complexes) {
            System.out.println(size); // 각 단지 크기 출력
        }
    }

    // DFS를 이용한 단지 탐색
    static int dfs(int x, int y) {
        visited[x][y] = true; // 현재 위치 방문 처리
        int count = 1; // 현재 위치 포함

        // 상하좌우로 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크 및 조건 확인
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) { // 범위 내에 있고
                if (map[nx][ny] == 1 && !visited[nx][ny]) { // 집이 있으며 방문하지 않은 경우
                    count += dfs(nx, ny); // 재귀 호출하여 연결된 집 개수 누적
                }
            }
        }

        return count; // 연결된 집의 개수 반환
    }
}