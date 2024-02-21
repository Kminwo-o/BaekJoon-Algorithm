import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Jewel implements Comparable<Jewel> {
        int weight;
        int value;

        Jewel (int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            if (o.weight == this.weight) return o.value - this.value;

            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[n];
        int[] bag = new int[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels);
        Arrays.sort(bag);

        // 내림차순 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());;
        long answer = 0;
        for (int i = 0, idx = 0; i < k; i++) {
            while (idx < n && jewels[idx].weight <= bag[i]) {
                pq.add(jewels[idx].value);
                idx++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}