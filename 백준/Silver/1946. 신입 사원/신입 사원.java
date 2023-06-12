import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {	
	static int T, N;
	static StringTokenizer st;
	static int[][] worker;
	static int cnt;
	static int[] ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br. readLine());
		ans = new int[T];
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br. readLine());
			worker = new int[N][2];
			cnt = 1;
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br. readLine());
				worker[j][0] = Integer.parseInt(st.nextToken());
				worker[j][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(worker, Comparator.comparingInt(o1 -> o1[0]));
			int top = worker[0][1];
			for (int j = 1; j < N; j++) {
				if (worker[j][1] < top) {
					cnt++;
					top = worker[j][1];
				}
			}
			ans[i] = cnt;
		}
		for (int ans : ans) {
			System.out.println(ans);
		}
	}
}