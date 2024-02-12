import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        k = 1;
        while (n != 0) {
            arr = new int[n][3];
            int[][] dp = new int[n+1][3];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][0] = arr[0][1] + arr[1][0];
            dp[1][1] = Math.min(Math.min(dp[1][0] + arr[1][1], arr[0][1] + arr[1][1]), arr[0][1] + arr[0][2] + arr[1][1]);
            dp[1][2] = Math.min(Math.min(dp[1][1] + arr[1][2], arr[0][1] + arr[1][2]), arr[0][1] + arr[0][2] + arr[1][2]);

            // 맨 오른쪽 + 되서 내려오는 거 바꾸면 됨.
            for (int i = 2; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        dp[i][j] = Math.min(dp[i-1][j] + arr[i][j], dp[i-1][j+1] + arr[i][j]);
                    } else if (j == 1) {
                        dp[i][j] = Math.min(Math.min(Math.min(dp[i-1][j-1] + arr[i][j], dp[i-1][j] + arr[i][j]), dp[i-1][j+1] + arr[i][j]), dp[i][j-1] + arr[i][j]);
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1] + arr[i][j], dp[i-1][j] +  + arr[i][j]), dp[i][j-1] + arr[i][j]);
                    }
                }
            }

            System.out.println(k+". "+dp[n-1][1]);
            k++;

            n = Integer.parseInt(br.readLine());
        }
    }
}