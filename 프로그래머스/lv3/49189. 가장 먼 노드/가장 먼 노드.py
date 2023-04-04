from collections import deque

def solution(n, edge):
    node_lst = [[] for _ in range(n+1)]
    visited = [0] * (n+1)
    
    for x, y in edge:
        node_lst[x].append(y)
        node_lst[y].append(x)
    
    visited[1] = 1
    queue = deque([1])
    
    while queue:
        v = queue.popleft()
        for next_v in node_lst[v]:
            if not visited[next_v]:
                visited[next_v] = visited[v] + 1
                queue.append(next_v)
                
    distance_node = max(visited)
    cnt = 0
    for i in visited:
        if i == distance_node:
            cnt += 1
        
    return cnt