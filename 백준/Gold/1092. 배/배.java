import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        List<Integer> crane = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());

        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(boxes, Collections.reverseOrder());

        int day = 0;
        while (!boxes.isEmpty()) {
            int boxIdx = 0;
            int craneIdx = 0;

            if (crane.get(craneIdx) < boxes.get(boxIdx)) {
                System.out.println(-1);
                return;
            }

            while (craneIdx < n) {
                if (boxIdx == boxes.size()) {
                    break;
                } else if (crane.get(craneIdx) >= boxes.get(boxIdx)) {
                    boxes.remove(boxIdx);
                    craneIdx++;
                } else {
                    boxIdx++;
                }
            }

            day++;
        }

        System.out.println(day);
    }
}