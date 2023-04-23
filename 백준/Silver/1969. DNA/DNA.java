import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	// 처음 받을 때 문자열 그대로 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 공백을 기준으로 담기
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 담은 토큰들 n, m에 넣어주기
        int N = Integer.parseInt(st.nextToken()); // dna 수
        int M = Integer.parseInt(st.nextToken()); // 문자열의 길이
        String[] s = new String[N];
        for (int i = 0; i < N; i++) {
			s[i] = br.readLine();
		}
        
        int sum = 0;
        String result = "";
        for(int i = 0; i < M; i++) {
			int max = -1;
			int idx = 0;
			int arr[] = new int[4];
			for (int j = 0; j < N; j++) {
				if (s[j].charAt(i) == 'A') {
					arr[0]++;
				} else if (s[j].charAt(i) == 'C') {
					arr[1]++;
				} else if(s[j].charAt(i) == 'G') {
					arr[2]++; 
				} else {
					arr[3]++;
				}
			}
			for (int j = 0; j <4; j++) {
				if (arr[j] > max) {
					max = arr[j];
					idx = j;
				}
			}
			if (idx == 0) {
				result += 'A';
			} else if (idx == 1) {
				result += 'C';
			} else if (idx == 2) {
				result += 'G';
			} else if (idx == 3) {
				result += 'T';
			}
			for (int j = 0; j < 4; j++) {
				if (j != idx) {
					sum += arr[j];
				}
			}
        }
        System.out.println(result);
        System.out.println(sum);
    }
}