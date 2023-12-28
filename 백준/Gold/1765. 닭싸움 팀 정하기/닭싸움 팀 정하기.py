import sys

input = sys.stdin.readline


def union(x, y):
    x = find(x)
    y = find(y)

    if x == y:
        return


    if abs(relation[x]) >= abs(relation[y]):
        relation[x] += relation[y]
        relation[y] = x
    else:
        relation[y] += relation[x]
        relation[x] = y


def find(x):
    if relation[x] < 0:
        return x

    relation[x] = find(relation[x])

    return relation[x]


n = int(input())
m = int(input())
graph = [[] for _ in range(n + 1)]
relation = [-1] * (n + 1)

for _ in range(m):
    rel, p, q = input().split()
    p = int(p)
    q = int(q)
    if rel == "E":
        graph[p].append(q)
        graph[q].append(p)
    else:
        union(p, q)

for i in range(1, n+1):
    if (len(graph[i]) > 1):
        for j in range(1, len(graph[i])):
            union(graph[i][j-1], graph[i][j])

answer = 0
for i in range(1, n+1):
    if relation[i] < 0:
        answer += 1

print(answer)