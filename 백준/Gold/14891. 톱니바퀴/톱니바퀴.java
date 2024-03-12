import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int k;
    static int[][] command;
    static List<Integer>[] gear = new List[4];
    static boolean[] visited = new boolean[4];
    // 왼쪽과 비교시 움직인 기어 6, 좌측 기어 2,
    // 오른쪽과 비교시 움직인 기어 2, 우측 기어 6
    static void solution (int targetGear, int dir) {
        if (visited[targetGear]) return;
        visited[targetGear] = true;

        switch (targetGear) {
            case 0:
                if (rightCheck(targetGear, targetGear + 1)) {
                    solution(targetGear + 1, dir * -1);
                }
                break;
            case 1:
                if (leftCheck(targetGear, targetGear - 1)) {
                    solution(targetGear - 1, dir * -1);
                }
                if (rightCheck(targetGear, targetGear + 1)) {
                    solution(targetGear + 1, dir * -1);
                }
                break;
            case 2:
                if (leftCheck(targetGear, targetGear - 1)) {
                    solution(targetGear - 1, dir * -1);
                }
                if (rightCheck(targetGear, targetGear + 1)) {
                    solution(targetGear + 1, dir * -1);
                }
                break;
            case 3:
                if (leftCheck(targetGear, targetGear - 1)) {
                    solution(targetGear - 1, dir * -1);
                }
                break;
        }
        visited[targetGear] = false;

        if (dir == 1) {
            clockwise(targetGear);
        } else {
            counterclockwise(targetGear);
        }
    }

    static boolean rightCheck(int thisGear, int rightGear) {
        if (gear[thisGear].get(2) != gear[rightGear].get(6)) {
            return true;
        }
        return false;
    }
    static boolean leftCheck(int thisGear, int leftGear) {
        if (gear[thisGear].get(6) != gear[leftGear].get(2)) {
            return true;
        }
        return false;
    }
    static void clockwise (int targetGear) {
        int state = gear[targetGear].remove(7);
        gear[targetGear].add(0, state);
    }
    static void counterclockwise (int targetGet) {
        int state = gear[targetGet].remove(0);
        gear[targetGet].add(state);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            gear[i] = new LinkedList<>();
        }

        for (int i = 0; i < 4; i++) {
            String[] gearState = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                gear[i].add(Integer.valueOf(gearState[j]));
            }
        }

        k = Integer.valueOf(br.readLine());
        command = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] line = br.readLine().split(" ");
            solution(Integer.valueOf(line[0]) - 1, Integer.valueOf(line[1]));
        }

        int answer = 0;
        int score = 1;
        for (int i = 0; i < 4; i++) {
            if (gear[i].get(0) == 1) { answer += score; }
            score *= 2;
        }

        System.out.println(answer);
    }
}