import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int m,n,x,y,z;
    static List<Node>[] list;
    static boolean[] visited;
    static class Node implements Comparable<Node> {
        int next;
        int cost;

        public Node (int next, int weight) {
            this.next = next;
            this.cost = weight;
        }
        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    public static int MST() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        int answer = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.next]) continue;

            answer += now.cost;
            visited[now.next] = true;

            for (int i = 0; i < list[now.next].size(); i++) {
                if (!visited[list[now.next].get(i).next]) {
                    pq.add(new Node(list[now.next].get(i).next, list[now.next].get(i).cost));
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) break;
            list = new ArrayList[m];
            visited = new boolean[m];
            for (int i = 0; i < m; i++) {
                list[i] = new ArrayList<>();
            }
            int total = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                z = Integer.parseInt(st.nextToken());

                list[x].add(new Node(y, z));
                list[y].add(new Node(x, z));
                total += z;
            }
            System.out.println(total - MST());
        }
    }
}