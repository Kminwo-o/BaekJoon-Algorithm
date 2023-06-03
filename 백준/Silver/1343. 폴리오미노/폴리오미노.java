import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String str;
	static String ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        
        str = str.replace("XXXX", "AAAA");
        ans = str.replace("XX", "BB");
		
        if (ans.contains("X")) {
        	ans = "-1";
        }
        System.out.println(ans);	
    }
}