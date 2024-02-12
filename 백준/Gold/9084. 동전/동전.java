import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, t;
    static int[] coin;
    static int goalMoney;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            coin = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                coin[j] = Integer.parseInt(st.nextToken());
            }

            goalMoney = Integer.parseInt(br.readLine());

            int[] dp = new int[goalMoney+1];

            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= goalMoney ; k++) {
                    if (k - coin[j] > 0) {
                        dp[k] = dp[k - coin[j]] + dp[k];
                    } else if (k - coin[j] == 0) {
                        dp[k]++;
                    }
                }
            }

            System.out.println(dp[goalMoney]);
        }
    }
}