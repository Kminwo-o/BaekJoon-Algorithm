import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static class susik {
        int[] left = new int[4];
        int operate;
        int[] right = new int[4];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        susik[] susiks = new susik[3];
        for (int i = 0; i < 3; i++) {
            String input = br.readLine();

            if (input.isEmpty()) {
                input = br.readLine();
            }

            st = new StringTokenizer(input);
            susiks[i] = new susik();

            for (int j = 0; j < 4; j++) {
                susiks[i].left[j] = Integer.valueOf(st.nextToken());
            }

            String operate = st.nextToken();
            if (operate.equals("<")) {
                susiks[i].operate = -1;
            } else if (operate.equals("=")) {
                susiks[i].operate = 0;
            } else {
                susiks[i].operate = 1;
            }

            for (int j = 0; j < 4; j++) {
                susiks[i].right[j] = Integer.valueOf(st.nextToken());
            }
        }

        int[] arr = new int[12];

        for (int i = 0; i < 12; i++) {
            arr[i] = 10;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            arr[i/2] += i % 2 == 1 ? 1 : -1;

            boolean result = true;

            for (int j = 0; j < 3; j++) {
                int allLeft = 0, allRight = 0;

                for (int k = 0; k < 4; k++) {
                    allLeft += arr[susiks[j].left[k] - 1];
                }

                for (int k = 0; k < 4; k++) {
                    allRight += arr[susiks[j].right[k] - 1];
                }

                if (susiks[j].operate == -1) {
                    result = allLeft < allRight;
                } else if (susiks[j].operate == 0) {
                    result = allLeft == allRight;
                } else {
                    result = allLeft > allRight;
                }

                if (!result) break;
            }

            if (result) {
                list.add(i);
            }
            arr[i/2] = 10;
        }

        StringBuilder sb = new StringBuilder();
        if (list.size() == 1) {
            sb.append(list.get(0) / 2 + 1);
            sb.append(list.get(0) % 2 == 1 ? "+" : "-");
        } else if (list.isEmpty()) {
            sb.append("impossible");
        } else {
            sb.append("indefinite");
        }

        System.out.println(sb);
    }
}