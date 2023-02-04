import sys
input = sys.stdin.readline

N,M = map(int,input().split())
tree_lst = list(map(int,input().split()))

low, high = 1, max(tree_lst)


while low <= high:
    mid = (low + high) // 2
    get_tree = 0

    for i in tree_lst:
        if i > mid:
            get_tree += (i-mid)

    if get_tree >= M:
        low = mid + 1

    elif get_tree < M:
        high = mid - 1

print(high)