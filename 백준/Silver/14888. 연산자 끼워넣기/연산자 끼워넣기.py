import sys
input = sys.stdin.readline

N = int(input())

num_lst = list(map(int, input().split()))
# 연산자 개수 받기
plus, minus, multi, div = map(int, input().split())
# 무한의 값으로 1e9를 사용
max_, min_ = -1e9, 1e9

# 사용한 숫자, 연산한 값, 연산자 개수
def dfs(depth, total, plus, minus, multi, div):
    global max_, min_

    # N개를 모두 사용했으면 마지막에 나온 total과, max, min을 비교해서 넣기
    if depth == N:
        max_ = max(total, max_)
        min_ = min(total, min_)
        return
    
    # 처음 해당 지점에 왔을 때, (1, 1, 2, 1, 1, 1)
    if plus:
        dfs(depth + 1, total + num_lst[depth], plus-1, minus, multi, div)
    # 처음 해당 지점에 왔을 때, (1, 1, 2, 1, 1, 1)
    if minus:
        dfs(depth + 1, total - num_lst[depth], plus, minus-1, multi, div)
    # 처음 해당 지점에 왔을 때, (1, 1, 2, 1, 1, 1)
    if multi:
        dfs(depth + 1, total * num_lst[depth], plus, minus, multi-1, div)
    # 처음 해당 지점에 왔을 때, (1, 1, 2, 1, 1, 1)
    if div:
        dfs(depth + 1, int(total / num_lst[depth]), plus, minus, multi, div-1)
    # 즉, 하나를 소모한 뒤 4개의 연산자로 이루어 질 수 있는 모든 경우의 수를 확인함.

dfs(1, num_lst[0], plus, minus, multi, div)
print(max_)
print(min_)