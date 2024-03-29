import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        Stack<String> stackLeft = new Stack<>();
        Stack<String> stackRight = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String[] password = br.readLine().split("");
            for (int j = 0; j < password.length; j++) {
                if (password[j].equals("<")) {
                    if (stackLeft.isEmpty()) continue;
                    stackRight.push(stackLeft.pop());
                } else if (password[j].equals(">")) {
                    if (stackRight.isEmpty()) continue;
                    stackLeft.push(stackRight.pop());
                } else if (password[j].equals("-")){
                    if (stackLeft.isEmpty()) continue;
                    stackLeft.pop();
                } else {
                    stackLeft.push(password[j]);
                }
            }

            int leftSize = stackLeft.size();
            for (int j = 0; j < leftSize; j++) {
                stackRight.push(stackLeft.pop());
            }


            int rightSize = stackRight.size();
            for (int j = 0; j < rightSize; j++) {
                sb.append(stackRight.pop());
            }

            sb.append('\n');
        }
        System.out.println(sb);
    }
}