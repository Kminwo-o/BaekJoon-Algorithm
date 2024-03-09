import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] times;
    static int[] usedComputer = new int[100001];
    static class Computer implements Comparable<Computer> {
        int computer;
        int endTime;

        public Computer(int computer, int endTime) {
            this.computer = computer;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Computer o) {
            return endTime - o.endTime;
        }
    }

    public static void Solution () {
        PriorityQueue<Computer> pq = new PriorityQueue();
        PriorityQueue<Integer> numQ = new PriorityQueue<>();
        int computerNumber = 1;
        usedComputer[computerNumber] = 1;
        pq.add(new Computer(computerNumber++, times[0][1]));

        for (int i = 1; i < n; i++) {

            while (!pq.isEmpty() && pq.peek().endTime < times[i][0]) {
                numQ.add(pq.poll().computer);
            }

            if (!numQ.isEmpty()) {
                int num = numQ.poll();
                usedComputer[num]++;
                pq.add(new Computer(num, times[i][1]));
            } else {
                usedComputer[computerNumber]++;
                pq.add(new Computer(computerNumber++, times[i][1]));
            }
        }

        System.out.println(computerNumber-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= computerNumber - 1; i++) {
            sb.append(usedComputer[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        times = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (t1, t2) -> t1[0] == t2[0] ? t1[1] - t2[1] : t1[0] - t2[0]);

        Solution();
    }
}