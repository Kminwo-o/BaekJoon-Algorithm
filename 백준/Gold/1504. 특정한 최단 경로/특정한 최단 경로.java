import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v, e;
    static List<int[]>[] graph;
    public static class Node implements Comparable<Node> {
        int distance;
        int region;

        public Node(int distance, int region) {
            this.distance = distance;
            this.region = region;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static int[] dijkstra(int start) {
        int[] distance = new int[v+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Node> heapQ = new PriorityQueue<>();
        heapQ.add(new Node(0, start));

        while (!heapQ.isEmpty()) {
            Node node = heapQ.poll();

            if (distance[node.region] < node.distance) {
                continue;
            }

            for (int[] dis : graph[node.region]) {
                int cost = node.distance + dis[1];

                if (distance[dis[0]] > cost) {
                    distance[dis[0]] = cost;
                    heapQ.add(new Node(cost, dis[0]));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new List[v+1];
        for (int i = 0; i < v+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[] {b, c});
            graph[b].add(new int[] {a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] totalStart = dijkstra(1);
        int[] v1Start = dijkstra(v1);
        int[] v2Start = dijkstra(v2);

        int v1F = totalStart[v1] + v1Start[v2] + v2Start[v];
        int v2F = totalStart[v2] + v2Start[v1] + v1Start[v];

        int ans = Math.min(v1F, v2F);
        if (ans >= (int) 1e9 || ans < 0) {
            ans = -1;
        }

        System.out.println(ans);
    }
}