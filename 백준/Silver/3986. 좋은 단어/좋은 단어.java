import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for (int j = 0; j < str.length(); j++) {
				// 스택이 비어있지 않고, top이 str의 현재 문자와 같으면
				// charAt을 써야 string의 index를 활용 가능.
				if (!stack.isEmpty() && stack.peek() == str.charAt(j)) {
					stack.pop();
				} else {
					stack.push(str.charAt(j));
				}
			}
			if (stack.isEmpty()) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}