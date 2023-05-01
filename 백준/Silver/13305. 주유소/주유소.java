import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	// 처음 받을 때 문자열 그대로 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 담은 토큰들 n, m에 넣어주기
        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int[] road_lst = new int[N-1];
        int[] cost = new int[N];
        int dis = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N-1; i++) {
			road_lst[i] = Integer.parseInt(st.nextToken());
		}
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
        
        int sum = 0;
        int low_cost = Integer.MAX_VALUE;
        
        for (int i = 0; i < N-1; i++) {
			if (cost[i] < low_cost) {
				low_cost = cost[i];
				sum += low_cost * road_lst[i];
			} else {
				sum += low_cost * road_lst[i];
			}
		}
        
        System.out.println(sum);
    }
}