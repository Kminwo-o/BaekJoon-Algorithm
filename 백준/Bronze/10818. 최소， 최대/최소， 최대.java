import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num_lst = new int[N];
		
		for (int i = 0; i < N; i++) {
			num_lst[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num_lst);
		System.out.println(num_lst[0] + " " + num_lst[N-1]);
	
	}
}