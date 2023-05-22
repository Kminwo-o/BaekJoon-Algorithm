import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] alphabet_lst = new String[N];
		int[] alpha_value = new int[26];
		for (int i = 0; i < N; i++) {
			alphabet_lst[i] = br.readLine();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < alphabet_lst[i].length(); j++) {
				char word = alphabet_lst[i].charAt(j);
				alpha_value[word-65] += (int)Math.pow(10, alphabet_lst[i].length()-j-1);
			}
		}
		Arrays.sort(alpha_value);
		
		int num = 9;
		int sum = 0;
		int turn = 25;
		
		while (turn != 0) {
			sum += alpha_value[turn] * num;
			--num; 
			--turn;
		}
		
		System.out.println(sum);
	}
}