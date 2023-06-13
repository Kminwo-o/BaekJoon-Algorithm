import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {	
	static int N, M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] guitar = new int[N];
		
		int left = 0;
		int right = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			guitar[i] = Integer.parseInt(st.nextToken());
			right += guitar[i];
			left = Math.max(left, guitar[i]);
		}
		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (sum + guitar[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum += guitar[i];
			}
			if (sum != 0) cnt++;
			if (cnt > M) left = mid+1;
			else right = mid-1;
		}
		System.out.println(left);
	}
}