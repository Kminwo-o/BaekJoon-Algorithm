import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, answer = 0;
    static int[][] mountainArr;
    static boolean[][] visited;
    static int[][] dir = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        boolean peak = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dir[i][0];
                int ny = now[1] + dir[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (mountainArr[x][y] < mountainArr[nx][ny]) {
                    peak = false;
                }

                if (visited[nx][ny]) continue;

                if (mountainArr[x][y] == mountainArr[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        if (peak) {
            answer++;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mountainArr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                mountainArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mountainArr[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}