import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<ArrayList<Integer>> singer = new ArrayList<>();
    public static String topologicalSort(int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            ans.add(now);

            for (int next : singer.get(now)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
            if (ans.size() != N) {
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            for (int i : ans) {
                sb.append(i + "\n");
            }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            singer.add(new ArrayList<>());
        }

        int[] indegree = new int[N+1];

        int x = 0, y = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int singer_num = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            for (int j = 1; j < singer_num; j++) {
                y = Integer.parseInt(st.nextToken());
                singer.get(x).add(y);
                indegree[y]++;

                x = y;
            }
        }

        System.out.println(topologicalSort(indegree));
    }
}