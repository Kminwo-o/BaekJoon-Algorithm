import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class num implements Comparable<num> {
    int num;

    public num(int number) {
        this.num = number;
    }

    @Override
    public int compareTo(num o) {
        if (Math.abs(num) == Math.abs(o.num)) {
            return num - o.num;
        }
        return Math.abs(num) - Math.abs(o.num);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<num> q = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int cmd = Integer.parseInt(br.readLine());

            if (cmd != 0) {
                q.add(new num(cmd));
            } else {
                if (q.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(q.poll().num);
                }
            }
        }
    }
}