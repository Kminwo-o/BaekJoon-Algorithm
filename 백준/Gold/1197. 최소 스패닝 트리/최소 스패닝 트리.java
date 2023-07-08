import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int next;
        int weight;

        public Node (int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    static int V, E, A, B, C;
    static List<Node>[] graph;
    static boolean[] visited;
    public static long Prim() {
        HashSet<Integer> set = new HashSet<>();
        long weight = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (visited[now.next]) continue;
            visited[now.next] = true;
            weight += now.weight;
            for (Node node : graph[now.next]) {
                queue.add(node);
            }
        }

        return weight;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V+1];
        visited = new boolean[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        System.out.println(Prim());
    }
}