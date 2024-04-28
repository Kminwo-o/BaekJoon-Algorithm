import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][][] visited;

    static class Node {
        int r;
        int c;
        int crash;

        public Node(int r, int c, int crash) {
            this.r = r;
            this.c = c;
            this.crash = crash;
        }
    }
    public static int bfs () {
        Queue<Node> queue = new LinkedList<>();
        visited[0][0][0] = 1;
        queue.add(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.r == n -1 && node.c == m - 1) {
                return visited[node.r][node.c][node.crash];
            }

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dir[i][0];
                int nc = node.c + dir[i][1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (map[nr][nc] == 1 && node.crash == 0) {
                    visited[nr][nc][1] = visited[node.r][node.c][0] + 1;
                    queue.add(new Node(nr, nc, 1));
                }
                if (map[nr][nc] == 0 && visited[nr][nc][node.crash] == 0) {
                    visited[nr][nc][node.crash] = visited[node.r][node.c][node.crash] + 1;
                    queue.add(new Node(nr, nc, node.crash));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        System.out.println(bfs());
    }
}