import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static class Move {
        int x;
        int y;
        int cnt;

        public Move (int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static void bfs (int s, int e) {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(s, e, 1));

        map[s][e] = 0;
        visited[s][e] = true;

        while (!queue.isEmpty()) {
            Move move = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = move.x + dir[i][0];
                int ny = move.y + dir[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] != 0) {
                            map[nx][ny] = move.cnt;
                            visited[nx][ny] = true;

                            queue.add(new Move(nx, ny, move.cnt + 1));
                        }
                    }
                }
            }
        }
    }

    static void check () {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    map[i][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    N = i;
                    M = j;
                }
            }
        }

        bfs(N, M);
        check();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}