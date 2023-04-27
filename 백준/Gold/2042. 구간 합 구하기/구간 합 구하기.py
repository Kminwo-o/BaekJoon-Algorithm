import sys
input = sys.stdin.readline

# 트리 만들기
def tree(start, end, idx):
    # start와 end가 같으면 리프노드
    if start == end:
        segment_tree[idx] = num_lst[start-1]
        return segment_tree[idx]
    
    # 총 start ~ end*2까지 나옴.
    mid = (start+end) // 2
    segment_tree[idx] = tree(start, mid, idx*2) + tree(mid+1, end, idx*2+1)
    return segment_tree[idx]

# 트리에서 값 찾기
def search(start, end, idx, left, right):
    # 찾는 법위가 start ~ end 밖이라면 0 반환
    if start > right or end < left:
        return 0
    
    # 찾는 범위가 트리 내에 있다면 !! 매우 중요
    if start >= left and end <= right:
        return segment_tree[idx]
    
    # 트리에서 범위 값을 맞추기 위해 조정
    mid = (start + end) // 2
    tmp_sum = search(start, mid, idx*2, left, right) + search(mid+1, end, idx*2+1, left, right)
    return tmp_sum

# 트리에서 값 변경하기 (구간 값도 모두 변경해야함)
def update(start, end, idx, update_idx, update_num):
    # update 하려는 범위가 초과될 경우
    if start > update_idx or end < update_idx:
        return
    
    segment_tree[idx] += update_num

    # 같으면 분할 불가
    if start == end:
        return
    
    mid = (start + end) // 2
    update(start, mid, idx*2, update_idx, update_num)
    update(mid+1, end, idx*2+1, update_idx, update_num)


N,M,K = map(int, input().split())

num_lst = []
# 가장 가까우면서 N보다 큰 제곱수의 *2를 해야하지만 보통 N*4로 함.
segment_tree = [0] *(N*4)

for _ in range(N):
    num_lst.append(int(input()))

tree(1, N, 1)

for _ in range(M+K):
    # a가 1이면 변경, 2면 구간합 구하기
    a, b, c = map(int, input().split())
    if a == 1:
        # 바꾸는 값 - 원래 값을 미리 구하여 넣어준다.
        # update시 값 오류를 막기 위함
        tmp = c - num_lst[b-1]
        num_lst[b-1] = c
        update(1, N, 1, b, tmp)
    
    else:
        print(search(1,N,1,b,c))