import sys
input = sys.stdin.readline

N = int(input())
# 정렬해서 left와 right idx를 뽑아야 하기 때문에 int화
A = list(map(int,input().split()))
M = int(input())
B = list(map(int, input().split()))
A.sort()

for i in B:
    # 할 때 마다 다시 찾아줘야해서
    left = 0
    right = N - 1
    cnt = 0
    # 보다 크면 left가 커지고, 작으면 right가 줄어들기 때문에
    while left <= right:
        mid = (left + right) // 2

        if i == A[mid]:
            cnt += 1
            print('1')
            break
        elif i < A[mid]:
            right = mid - 1
        elif i > A[mid]:
            left = mid + 1

    # 다 돌았는데 없으면
    if cnt == 0:
        print('0')