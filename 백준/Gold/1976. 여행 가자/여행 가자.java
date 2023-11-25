import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] plan;
    static List<Integer>[] graph;
    static boolean possible = false;
    public static boolean bfs(int start, int target) {
        if (start == target) {
            return true;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);

                if (next == target) return true;

                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new List[N+1];

        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N+1; i++) {
            String[] connection = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (connection[j].equals("1")) {
                    graph[i].add(j+1);
                }
            }
        }

        plan = new int[M];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M-1; i++) {
            possible = bfs(plan[i], plan[i+1]);
            if (!possible) {
                break;
            }
        }

        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
