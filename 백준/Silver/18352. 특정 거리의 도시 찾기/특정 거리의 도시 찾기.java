import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k, x;
    static List<Integer>[] graph;
    static boolean[] visited;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void bfs(int city) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {city, 0});
        visited[city] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[1] > k) break;
            if (now[1] == k) {
                answer.add(now[0]);
            }

            for (int i = 0; i < graph[now[0]].size(); i++) {
                int nextCity = graph[now[0]].get(i);
                if (visited[nextCity]) continue;
                visited[nextCity] = true;
                queue.add(new int[] {nextCity, now[1] + 1});
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }

        bfs(x);

        Collections.sort(answer);
        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }
    }
}