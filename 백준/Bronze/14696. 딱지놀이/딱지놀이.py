import sys
input = sys.stdin.readline

N = int(input())

for _ in range(N):
    A_lst = list(map(int, input().split()))
    B_lst = list(map(int, input().split()))
    check = False
    A = A_lst.pop(0)
    B = B_lst.pop(0)
    
    if A < B:
        for i in range(B-A):
            A_lst.append(0)
        le = B
    else:
        for i in range(A-B):
            B_lst.append(0)
        le = A
    
    A_lst.sort(reverse=True)
    B_lst.sort(reverse=True)

    for i in range(le):
        for j in range(i, le):
            if A_lst[i] == B_lst[j]:
                break
            else:
                if A_lst[i] > B_lst[j]:
                    print('A')
                    check = True
                    break
                else:
                    print('B')
                    check = True
                    break
        if check == True:
            break
    else:
        print('D')