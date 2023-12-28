import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, p, q;
    static String rel;
    static List<Integer>[] graph;
    static int[] relation;
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return;

        if (Math.abs(relation[x]) >= Math.abs(relation[y])) {
            relation[x] += relation[y];
            relation[y] = x;
        } else {
            relation[y] += relation[x];
            relation[x] = y;
        }
    }
    public static int find(int x) {
        if (relation[x] < 0) {
            return x;
        }

        x = find(relation[x]);

        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new List[n + 1];
        relation = new int[n + 1];

        Arrays.fill(relation, -1);

        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rel = st.nextToken();
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            if (rel.equals("F")) {
                union(p, q);
            } else {
                graph[p].add(q);
                graph[q].add(p);
            }
        }

        for (int i = 1; i < n+1 ; i++) {
            if (graph[i].size() > 1) {
                for (int j = 1; j < graph[i].size(); j++) {
                    union(graph[i].get(j-1), graph[i].get(j));
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < n+1; i++) {
            if (relation[i] < 0) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}