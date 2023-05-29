import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] bomb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bomb = new int[N];
        for (int i = 0; i < N; i++) {
			bomb[i] = Integer.parseInt(br.readLine());
		}
        
        if (N == 1) {
			System.out.println(1);
		} else {
			if (bomb[0] >= bomb[1]) {
				System.out.println(1);
			}
			for (int i = 1; i < N-1; i++) {
				if (bomb[i-1] <= bomb[i] && bomb[i] >= bomb[i+1]) {
					System.out.println(i+1);
				}
			}
			
			if (bomb[N-1] >= bomb[N-2]) {
				System.out.println(N);
			}
		}
        
    }
}