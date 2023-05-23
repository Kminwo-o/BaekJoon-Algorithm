import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] floor = new int[15][15];
		
		
		for (int i = 0; i < floor.length; i++) {
			floor[0][i] = i+1;
		}
		
		for (int i = 1; i < floor.length; i++) {
			for (int j = 0; j < floor.length; j++) {
				for (int k = 0; k <= j; k++) {
					floor[i][j] += floor[i-1][k];
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(floor[k][n-1]);
		}
	}
}