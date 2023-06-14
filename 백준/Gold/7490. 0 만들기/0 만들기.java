import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, T;
	static StringBuilder sb;
	static List<String> ans;
	public static void dfs(int idx, int num, int sum, int op, String sik) {
		if (idx == N) {
			sum += (num*op);
			if (sum == 0) {
				sb.append(sik + "\n");
			} return;
		}
		
		dfs(idx+1, num*10+(idx+1), sum, op, sik + " " + Integer.toString(idx+1));
		dfs(idx+1, idx+1, sum+(num*op), 1, sik + "+" + Integer.toString(idx+1));
		dfs(idx+1, idx+1, sum+(num*op), -1, sik + "-" + Integer.toString(idx+1));
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			sb= new StringBuilder();
			dfs(1,1,0,1,"1");
			System.out.println(sb);
			
		}
	}
}