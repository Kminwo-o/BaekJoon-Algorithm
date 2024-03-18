import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int start, end;
    static List<Road>[] graph;
    static boolean[] visited;
    static class Road {
        int end;
        int cost;

        public Road(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    static boolean bfs (int mid) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == end) return true;

            for (Road road : graph[now]) {
                if (road.cost >= mid && !visited[road.end]) {
                    visited[road.end] = true;
                    queue.add(road.end);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new List[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            max = Math.max(max, c);
            min = Math.min(min, c);

            graph[a].add(new Road(b, c));
            graph[b].add(new Road(a, c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        int answer = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            visited = new boolean[n + 1];

            if (bfs(mid)) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(answer);
    }
}