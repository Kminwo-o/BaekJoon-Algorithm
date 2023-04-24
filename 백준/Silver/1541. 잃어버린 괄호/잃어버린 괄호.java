import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] num = br.readLine().split("-");
    	int sum = Integer.MAX_VALUE;
    	for (int i = 0; i < num.length; i++) {
			int tmp = 0;
			String[] tmp_num = num[i].split("\\+");
			for (int j = 0; j < tmp_num.length; j++) {
				tmp += Integer.parseInt(tmp_num[j]);
			}
			if (i == 0) {
				sum = tmp;
			} else {
				sum -= tmp;
			}
		}
    	System.out.println(sum);
    }
}