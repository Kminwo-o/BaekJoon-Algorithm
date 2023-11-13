import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int ans = 0;

    public static void dfs(int x, int y, int cnt, int sweetPotato, char[][] arr) {
        if (cnt == T) {
            ans = Math.max(ans, sweetPotato);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && arr[nx][ny] != '#') {
                if (arr[nx][ny] == 'S') {
                    arr[nx][ny] = '.';
                    dfs(nx, ny, cnt + 1, sweetPotato + 1, arr);
                    arr[nx][ny] = 'S';
                } else {
                    dfs(nx, ny, cnt + 1, sweetPotato, arr);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int x = 0;
        int y = 0;

        char[][] arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line[j];

                if (arr[i][j] == 'G') {
                    x = i;
                    y = j;
                }
            }
        }

        dfs(x, y, 0, 0, arr);

        System.out.println(ans);
    }
}