import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0;
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		for (int i = 1; i < str.length; i++) {
			char[] first = str[0].toCharArray();
			char[] word = str[i].toCharArray();
			int equl = 0;
			for (int j = 0; j < first.length; j++) {
				for (int k = 0; k < word.length; k++) {
					if (first[j]  == word[k]) {
						first[j] = '1';
						word[k] = '2';
						equl++;
					}
				}
						
			}
//			first가 더 길면, first에서 1개 줄였을 때 같은 값이 같아야 한다. word가 더 길면, word보다 1개 작거나 같아야 한다.
			if ((equl >= first.length-1 && first.length >= word.length) || (equl >= word.length-1 && word.length >= first.length)) {
				ans++;
			}
			
		}
	
	System.out.println(ans);   	
    }
}