import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int count = 0;
        Stack<Integer> firstStack = new Stack<>();
        Stack<Integer> secondStack = new Stack<>();
        StringBuilder thirdStack = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            firstStack.push(Integer.parseInt(st.nextToken()));
        }

        while (N != 0) {
            if (firstStack.contains(N)) {
                while (firstStack.peek() != N) {
                    secondStack.push(firstStack.pop());
                    count++;
                    thirdStack.append("1 2\n");
                }
                firstStack.pop();
                N--;
                count++;
                thirdStack.append("1 3\n");
            } else if (secondStack.contains(N)) {
                while (secondStack.peek() != N) {
                    firstStack.push(secondStack.pop());
                    count++;
                    thirdStack.append("2 1\n");
                }
                secondStack.pop();
                N--;
                count++;
                thirdStack.append("2 3\n");
            }
        }

        System.out.println(count);
        System.out.println(thirdStack);
    }
}