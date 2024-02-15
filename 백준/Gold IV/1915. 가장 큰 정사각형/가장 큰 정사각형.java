import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][m+1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                int now = Character.getNumericValue(arr[j-1]);

                if (i == 1 && j == 1) {
                    dp[i][j] = now;
                    answer = Math.max(answer, dp[i][j]);
                } else {
                    if (now == 1) {
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                        answer = Math.max(answer, dp[i][j]);
                    }
                }
            }
        }

        System.out.println(answer * answer);
    }
}