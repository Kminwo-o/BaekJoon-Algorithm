import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int N;
    static int M;
    static int R;
    static int[][] arr;

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int len = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < len; j++) {
                int x = j;
                int y = j;
                int tmp = arr[j][j];

                for (int k = j + 1; k < N - j; k++) {
                    x = k;
                    int prev_value = arr[x][y];
                    arr[x][y] = tmp;
                    tmp = prev_value;
                }

                for (int k = j + 1; k < M - j; k++) {
                    y = k;
                    int prev_value = arr[x][y];
                    arr[x][y] = tmp;
                    tmp = prev_value;
                }

                for (int k = j + 1; k < N - j; k++) {
                    x = N - k - 1;
                    int prev_value = arr[x][y];
                    arr[x][y] = tmp;
                    tmp = prev_value;
                }

                for (int k = j + 1; k < M - j; k++) {
                    y = M - k - 1;
                    int prev_value = arr[x][y];
                    arr[x][y] = tmp;
                    tmp = prev_value;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}