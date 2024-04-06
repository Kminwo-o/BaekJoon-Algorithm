import java.io.*;
import java.util.*;

public class Main {
    static int n;

    static class Problem implements Comparable<Problem>{
        int deadline;
        int cupNoodle;

        public Problem(int deadline, int cupNoodle) {
            this.deadline = deadline;
            this.cupNoodle = cupNoodle;
        }


        @Override
        public int compareTo(Problem o) {
            if (this.deadline == o.deadline) {
                return o. cupNoodle - this.cupNoodle;
            }
            return this.deadline - o.deadline;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ArrayList<Problem> problems = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            problems.add(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(problems);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Problem problem : problems) {
            queue.add(problem.cupNoodle);
            
            if (queue.size() > problem.deadline) {
                queue.poll();
            }
        }

        long answer = 0;
        while (!queue.isEmpty()) {
            answer += queue.poll();
        }

        System.out.println(answer);
    }
}