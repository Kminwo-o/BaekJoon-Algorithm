import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
     
        dp[1] = 3;
        dp[2] = 7;
        dp[3] = 17;
        dp[4] = 41;
        
        for (int i = 5; i < N+1; i++) {
			dp[i] = (dp[i-2] + (dp[i-1] * 2)) % 9901;
		}
        
        System.out.println(dp[N]);
    }
}