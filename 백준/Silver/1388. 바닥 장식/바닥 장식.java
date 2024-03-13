import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m;
    static char[][] arr;
    static boolean[][] visited;
    static int[][] dir = new int[][] {{0, 1}, {1, 0}};
    public static void dfs (int x, int y, int direction) {
        visited[x][y] = true;

        int nx = x + dir[direction][0];
        int ny = y + dir[direction][1];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
            if (!visited[nx][ny] && arr[x][y] == arr[nx][ny]) {
                dfs(nx, ny, direction);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) continue;

                if (arr[i][j] == '-') {
                    dfs (i, j, 0);
                } else {
                    dfs(i, j, 1);
                }

                answer++;
            }
        }
        System.out.println(answer);
    }
}