import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int[] graph;
    static boolean[] visited;
    static List<Integer> contain;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 0; t < n; t++) {
            int size = Integer.parseInt(br.readLine()); // 노드 개수
            graph = new int[size+1]; // 1-based 인덱스 사용
            visited = new boolean[size+1];
            contain = new ArrayList<>();
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= size; j++) { // 1부터 시작
                graph[j] = Integer.parseInt(st.nextToken());
            }

            for (int start = 1; start <= size; start++) {
                if (!visited[start]) {
                    dfs(start);
                }
            }

            System.out.println(answer);
        }
    }

    static void dfs(int node) {
        if (contain.contains(node)) { // 사이클 감지
            answer++;
            return;
        }

        if (visited[node]) { // 이미 방문한 경우
            return;
        }

        visited[node] = true;
        contain.add(node);
        dfs(graph[node]); // 다음 노드 방문
        contain.remove(contain.size() - 1); // 해당 노드 지우기.
    }
}