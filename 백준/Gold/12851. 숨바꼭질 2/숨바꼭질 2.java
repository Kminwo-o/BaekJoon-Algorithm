import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[] visited = new int[100001];
    static Queue<Integer> queue = new LinkedList<>();
    static int ans = Integer.MAX_VALUE;
    static int cnt = 0;
    public static void bfs() {
        int now;

        while (!queue.isEmpty()) {
            now = queue.poll();

            if (visited[now] > ans) {
                return;
            }
            int[] move = {now + 1, now - 1, now * 2};
            for (int i = 0; i < 3; i++) {
                int next = move[i];

                if (next < 0 || next > 100000) continue;
                if (next == K) {
                    ans = visited[now];
                    cnt++;
                }

                if (visited[next] == 0 || visited[next] == visited[now] + 1) {
                    queue.offer(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        queue.offer(N);
        visited[N] = 1;

        if (N >= K) {
            System.out.println(N-K);
            System.out.println(1);
            return;
        } else {
            bfs();
        }
        System.out.println(ans);
        System.out.println(cnt);
    }
}