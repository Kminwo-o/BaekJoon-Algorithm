import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**4)

def preorder(start, end):
    global node_lst
    if start > end: return
    
    # 오른쪽이 없을 경우 오른쪽 순회를 바로 끝내기 위해 +1
    mid = end + 1
    for i in range(start + 1, end + 1):
        # 전위 순회기 때문에 뿌리 노드보다 큰 이후는 무조건 오른쪽
        # 왼, 오 구분하기 위해서 컷
        if node_lst[start] < node_lst[i]:
            mid = i
            break
    # 왼쪽
    preorder(start+1, mid-1)
    # 오른쪽
    preorder(mid, end)
    # 후위 위치에서 프린트 하면 그냥 후위 순회
    print(node_lst[start])

node_lst = []

# 입력 안되면 걍 그만
while True:
    try: node_lst.append(int(input().strip()))
    except: break

preorder(0, len(node_lst)-1)