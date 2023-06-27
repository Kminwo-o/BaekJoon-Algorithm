import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int t, n, start_x, start_y, end_x, end_y;

    public static boolean bfs(Node[] node) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(new Node(start_x, start_y));

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (Math.abs(n.x - end_x) + Math.abs(n.y - end_y) <= 1000) return true;

            for (int i = 0; i < node.length; i++) {
                if (!visited[i]) {
                    Node next_n = node[i];
                    int distance = Math.abs(n.x - next_n.x) + Math.abs(n.y - next_n.y);

                    if (distance <= 1000) {
                        visited[i] = true;
                        q.add(next_n);
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            Node[] lst = new Node[n];
            st = new StringTokenizer(br.readLine());
            start_x = Integer.parseInt(st.nextToken());
            start_y = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n+1; j++) {
                st = new StringTokenizer(br.readLine());
                if (j == n) {
                    end_x = Integer.parseInt(st.nextToken());
                    end_y = Integer.parseInt(st.nextToken());
                } else {
                    lst[j] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                }
            }

            System.out.println(bfs(lst)? "happy" : "sad");
        }
    }
}