import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static final int first = 0;
    static final int second = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][n];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][n+1];
            dp[first][1] = arr[first][0];
            dp[second][1] = arr[second][0];

            for (int j = 2; j <= n; j++) {
                dp[first][j] = Math.max(dp[second][j - 1], dp[second][j - 2]) + arr[first][j-1];
                dp[second][j] = Math.max(dp[first][j - 1], dp[first][j - 2]) + arr[second][j-1];
            }

            System.out.println(Math.max(dp[first][n], dp[second][n]));
        }
    }
}