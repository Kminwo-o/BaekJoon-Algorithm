import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	// 처음 받을 때 문자열 그대로 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 담은 토큰들 n, m에 넣어주기
        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int sum = 0;
        for (int i = 1; i < N+1; i++) {
			sum += i;
		}
        
        System.out.println(sum);
        
    }
}