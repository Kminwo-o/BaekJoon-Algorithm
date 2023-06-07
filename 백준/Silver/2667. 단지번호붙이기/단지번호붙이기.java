import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] visited;
	static int[][] arr;
	static ArrayList<Integer> ans = new ArrayList<>();
	static int count;
	
	static void dfs(int x, int y) {
		count++;
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			
			if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N) && !visited[nx][ny] && arr[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		String apart = "";
		for (int i = 0; i < N; i++) {
			apart = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Character.getNumericValue(apart.charAt(j));
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					count = 0;
					dfs(i,j);
					ans.add(count);
				} 
			}
		}
		
		Collections.sort(ans);
		
		System.out.println(ans.size());
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
}