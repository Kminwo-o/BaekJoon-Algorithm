import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] coin, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int[n];
        dp = new int[k+1];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for(int i = 0; i < n; i++){
            for(int j = coin[i]; j <= k; j++){
                dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
            }
        }

        if(dp[k] == 10001)
            System.out.println(-1);
        else
            System.out.println(dp[k]);
    }
}