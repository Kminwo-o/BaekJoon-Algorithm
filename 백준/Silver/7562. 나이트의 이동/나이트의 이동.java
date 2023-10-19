import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static int T, N;
    static boolean[][] visited;
    static int[][] dir = {{-2, -1}, {-1, -2}, {2, -1}, {1, -2}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

    static class Node {
        int x;
        int y;
        int cnt;

        public Node (int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static int bfs(int sx, int sy, int ex, int ey) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sx, sy, 0));
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == ex && node.y == ey) {
                return node.cnt;
            }

            for (int i = 0; i < 8; i++) {
                int nx = node.x + dir[i][0];
                int ny = node.y + dir[i][1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    queue.add(new Node(nx, ny, node.cnt + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sx, sy, ex, ey;
        int answer;
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            answer = bfs(sx, sy, ex, ey);
            System.out.println(answer);
        }
    }
}