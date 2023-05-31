import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String document;
	static String search; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		document = br.readLine();
		search = br.readLine();
		
		int idx = 0;
		int ans = 0;
		
		while (document.length() - search.length() >= idx) {
			if (document.substring(idx, idx + search.length()).equals(search)) {
				ans++;
				idx += search.length();
			} else {
				idx++;
			}
		}
		System.out.println(ans);
	}
}