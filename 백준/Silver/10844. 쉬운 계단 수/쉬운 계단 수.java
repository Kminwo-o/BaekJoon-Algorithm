import java.util.Scanner;

public class Main {
	static long div = 1000000000;
	static long sum = 0;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] dp = new long[N+1][10];
		
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i < N+1; i++) {
			for (int j = 0; j < 10; j++) {
				if (j==0) {
					dp[i][j] = dp[i-1][1] % div;
				}
				else if (j==9) {
					dp[i][j] = dp[i-1][8] % div;
				}
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % div;
				}				
			}
		}
		for (int i = 0; i < 10; i++) {
			 sum += dp[N][i];
		}
		System.out.println(sum % div);
	}
}