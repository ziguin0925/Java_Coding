import java.util.*;

class Solution {
    private static final int[] dx = {1, -1, 0, 0}; // 남, 북, 동, 서
    private static final int[] dy = {0, 0, 1, -1}; // 남, 북, 동, 서

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int[][] graph) {
        int rows = graph.length;      // 행의 개수
        int cols = graph[0].length;   // 열의 개수

        int[][] dist = new int[rows][cols]; // 거리 저장 배열
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0)); // 시작점 (0, 0) 추가
        dist[0][0] = 1; // 시작 지점의 거리 1로 설정

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 그래프 범위를 벗어나면 건너뛰기
                if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) {
                    continue;
                }

                // 이동하려는 곳이 벽이거나 이미 방문한 경우
                if (graph[nx][ny] == 0 || dist[nx][ny] != 0) {
                    continue;
                }

                // 이동 가능한 경우 거리 갱신 및 큐에 추가
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                queue.add(new Node(nx, ny));
            }
        }

        // 상대 진영 (rows-1, cols-1) 위치에 도달할 수 없는 경우 -1 반환
        return dist[rows - 1][cols - 1] == 0 ? -1 : dist[rows - 1][cols - 1];
    }
}