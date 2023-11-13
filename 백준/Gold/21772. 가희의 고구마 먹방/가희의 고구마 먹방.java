import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int ans = 0;

    public static class gaHwi {
        int x;
        int y;
        int cnt;
        int sweetPotato;

        public gaHwi(int x, int y, int cnt, int sweetPotato) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.sweetPotato = sweetPotato;
        }
    }

    public static void dfs(gaHwi gaHwi, char[][] arr) {
        if (gaHwi.cnt == T) {
            ans = Math.max(ans, gaHwi.sweetPotato);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = gaHwi.x + dir[i][0];
            int ny = gaHwi.y + dir[i][1];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && arr[nx][ny] != '#') {
                if (arr[nx][ny] == 'S') {
                    arr[nx][ny] = '.';
                    dfs(new gaHwi(nx, ny, gaHwi.cnt + 1, gaHwi.sweetPotato + 1), arr);
                    arr[nx][ny] = 'S';
                } else {
                    dfs(new gaHwi(nx, ny, gaHwi.cnt + 1, gaHwi.sweetPotato), arr);
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
        gaHwi gaHwi = null;

        char[][] arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line[j];

                if (arr[i][j] == 'G') {
                    gaHwi = new gaHwi(i, j, 0, 0);
                }
            }
        }

        dfs(gaHwi, arr);

        System.out.println(ans);
    }
}