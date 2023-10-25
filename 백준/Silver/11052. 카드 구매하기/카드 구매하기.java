import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] card_lst;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		card_lst = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			card_lst[i] = Integer.parseInt(st.nextToken());
		}
		
		// i개의 카드를 가져야 할 때 최대 값
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < i+1; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + card_lst[j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}