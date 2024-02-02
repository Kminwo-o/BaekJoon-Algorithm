import java.util.List;
import java.util.ArrayList;

class Solution {
    static int answer = 0;
    static List<Integer>[] graph;
    public static int dfs(int cur, int before) {
        // 리프노드면 이전 등대가 반드시 켜져야함
        if (graph[cur].size() == 1 && graph[cur].get(0) == before) {
            return 1;
        }
        
        int ans = 0;
        // 리프노드가 아니면 켜져야할 등대인지 판단
        for (int i = 0; i < graph[cur].size(); i++) {
            int next = graph[cur].get(i);
            if (next == before) continue;
            ans += dfs(next, cur);
        }
        
        // 켜짐 판단이 1번도 없었으면 꺼도되는 등대
        if (ans == 0) {
            return 1;
        }
        
        // 그렇지 않으면 켜야하는 등대, 켜야하는 등대인 경우 근처 등대를 켜지 않아도 되기 때문에 0 반환.
        answer++;
        return 0;
    }
    
    public int solution(int n, int[][] lighthouse) {
        graph = new List[n+1];
        // 그래프 만들기
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < lighthouse.length; i++) {
            int[] line = lighthouse[i];
            graph[line[0]].add(line[1]);
            graph[line[1]].add(line[0]);
        }
        
        dfs(1, 0);
        
        return answer;
    }
}