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
		
		int doc_len = document.length();
		int search_len = search.length();
		
		document = document.replace(search, "");
		int ans = (doc_len - document.length()) / search_len;
		System.out.println(ans);
	}
}