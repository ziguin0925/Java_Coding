import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int v = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(w);
            graph[w].add(u); // 양방향 그래프
        }

        // 정점 번호가 작은 순서대로 방문하기 위해 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 탐색
        visited = new boolean[n + 1];
        dfs(v);
        System.out.println(dfsResult.toString().trim());

        // BFS 탐색
        visited = new boolean[n + 1];
        bfs(v);
        System.out.println(bfsResult.toString().trim());
    }

    static void dfs(int now) {
        visited[now] = true;
        dfsResult.append(now).append(" ");

        for (int next : graph[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            bfsResult.append(now).append(" ");

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}