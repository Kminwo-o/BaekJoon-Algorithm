import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static String[] masterPattern = new String[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        masterPattern = br.readLine().split("\\*");

        int allLen = masterPattern[0].length() + masterPattern[1].length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String fileName = br.readLine();

            if (fileName.length() < allLen) {
                sb.append("NE\n");
                continue;
            }

            if (fileName.startsWith(masterPattern[0]) && fileName.endsWith(masterPattern[1])) {
                sb.append("DA\n");
            } else {
                sb.append("NE\n");
            }
        }

        System.out.println(sb);
    }
}