import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static char[][] arr;
	static int R;
	static int C;
	static int ans;
	static int[] dir = {-1, 0, 1};
	
	static boolean dfs(int x, int y) {
		if (y == C-1) {
			return true;
		}
		
		for (int num : dir) {
			int nx = x + num;
			int ny = y + 1;
			
			if (0 <= nx && nx < R) {
				if (arr[nx][ny] != 'x' && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					if (dfs(nx, ny)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		ans = 0;
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			if (dfs(i, 0)) ans++;
		}
		System.out.println(ans);
	}
}