import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, answer = 0;
    static int[][] mountainArr;
    static boolean[][] visited;
    static boolean[][] mountainPeak;
    static int[][] dir = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    static void bfs(int x, int y) {
        visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        List<int[]> peak = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dir[i][0];
                int ny = now[1] + dir[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;

                // 걸리는 경우 해당 봉우리는 봉우리가 아님
                if (mountainArr[nx][ny] > mountainArr[x][y]) { return; }
                if (mountainArr[x][y] == mountainArr[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                    peak.add(new int[] {nx, ny});
                }

                visited[nx][ny] = true;
            }
        }

        for (int i = 0; i < peak.size(); i++) {
            mountainPeak[peak.get(i)[0]][peak.get(i)[1]] = true;
        }

        answer++;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mountainArr = new int[n][m];
        mountainPeak = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                mountainArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mountainArr[i][j] != 0 && !mountainPeak[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}