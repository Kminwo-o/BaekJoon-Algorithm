import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int k, l;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<String> set = new LinkedHashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= l; i++) {
            String studentName = br.readLine();

            if (set.contains(studentName)) {
                set.remove(studentName);
            }

            set.add(studentName);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (String number: set
             ) {
            if (cnt == k) {
                break;
            }
            sb.append(number).append('\n');
            cnt++;
        }

        System.out.println(sb);
    }
}