import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main{
    static int N;
    static int M;
    static int R;
    static int[][] arr;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static int[][] rotation(int half, int[][] tmp_arr) {
        // 회전 시작점
        for (int i = 0; i < half; i++) {
            int x = i;
            int y = i;

            int direct = 0;
            while (direct < 4) {
                int nx = x + dir[direct][0];
                int ny = y + dir[direct][1];

                if ((nx >= 0 + i && nx < N - i) && (ny >= 0 + i && ny < M - i)) {
                    tmp_arr[nx][ny] = arr[x][y];

                    x = nx;
                    y = ny;

                    continue;
                }
                direct++;
            }
        }
        return tmp_arr;
    }

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        Map <String, Integer> map = new HashMap<>();

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int len = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            int[][] tmpArr = new int[N][M];
            arr = rotation(len, tmpArr);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}